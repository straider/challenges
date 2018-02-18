#!/usr/bin/env groovy

String DEV_PROJECT_NAME = "${env.PROJECT_NAME}-dev"
String TST_PROJECT_NAME = "${env.PROJECT_NAME}-tst"
String STG_PROJECT_NAME = "${env.PROJECT_NAME}-stg"
String GIT_BRANCH       = 'master'
String CREDENTIALS_ID   = '[CREDENTIALS_ID]'

String application_name    = ''
String application_version = ''

def notifySlack( String buildStatus = 'STARTED' ) {
    buildStatus = buildStatus ?: 'SUCCESS' // Build status of null means success.

    String color
    switch ( buildStatus ) {
        case 'STARTED':
            color = '#D4DADF'
            break
        case 'APPROVAL':
            color = '#0072BC'
            break
        case 'SUCCESS':
            color = '#BDFFC3'
            break
        case 'UNSTABLE':
            color = '#FFFE89'
            break
        default:
            color = '#FF9FA1'
            break
    }

    def resultBefore = currentBuild.result
    try {
        String message = "${buildStatus}: `${env.JOB_NAME}` #${env.BUILD_NUMBER}:\n<${env.JENKINS_URL}blue/organizations/jenkins/${env.JOB_NAME}/detail/${env.JOB_NAME}/${env.BUILD_NUMBER}/pipeline|Click Here To View Pipeline>"

        slackSend( channel: env.SLACK_CHANNEL, color: color, message: message )
    } catch( exception ) {
        currentBuild.result = resultBefore
    }
}

def mvn( String goals ) {
    sh "./mvnw -s configuration/settings.xml --show-version --batch-mode ${goals}"
}

String get_application_name() {
    pom = readMavenPom file: 'pom.xml'
    pom.artifactId
}

String get_application_version() {
//    String gitHash = sh script: "git log --pretty=format:'%h' -n 1", returnStdout: true

    pom = readMavenPom file: 'pom.xml'
//    "${pom.version}-${gitHash.trim()}"
    "${pom.version}-${env.BUILD_NUMBER}"
}

String countResource( String type, String appName, String environment ) {
    sh "oc project ${environment} > /dev/null"

    String resourceCount = sh script: "oc get ${type} ${appName} --no-headers --namespace ${environment} | wc -l | xargs", returnStdout: true
    resourceCount.trim()
}

def createOrApplyResource( String type, String appName, String environment, String resourcePath ) {
    String resourceCount = countResource( type, appName, environment )
    String operation     = resourceCount == '0' ? 'create' : 'apply'

    sh "oc ${operation} -f ${resourcePath} --namespace ${environment}"

    if ( type == 'dc' ) {
        script {
            String projectGroupName       = sh script: "oc project --short | grep --extended-regexp --only-matching '\\w+-\\w+'", returnStdout: true
            String developmentEnvironment = "${projectGroupName.trim()}-dev"
            String imageStream            = sh script: "oc get is --namespace ${developmentEnvironment} ${appName} --template '{{.status.dockerImageRepository}}'", returnStdout: true
            String applicationVersion     = get_application_version()

            String patch = "'{ \"spec\": { \"template\": { \"spec\": { \"containers\": [ { \"name\": \"${appName}\", \"image\": \"${imageStream}:${applicationVersion}\" } ] } } } }'"
            sh "oc patch --namespace ${environment} dc/${appName} --patch ${patch}"
        }
    }
}

def createResourceIfMissing( String type, String appName, String environment, String resourcePath ) {
    String resourceCount = countResource( type, appName, environment )
    if ( resourceCount == '0' ) {
        sh "oc create -f ${resourcePath} --namespace ${environment}"
    } else if ( resourceCount == '1' ) {
        sh "echo 'Resource ${resourcePath} already exists in ${environment} - it cannot be updated.'"
    } else {
        sh "echo 'Unknown response: resourceCount == ${resourceCount}'"

        currentBuild.result = 'FAILURE'
        error( 'Unknown response' )
    }
}

def updateDeploymentResources( String appName, String environment ) {
    createOrApplyResource( 'dc' , appName, environment, 'configuration/deploy-config.yaml' )
    createOrApplyResource( 'svc', appName, environment, 'configuration/service.yaml'       )

    if ( fileExists( 'configuration/route.yaml' ) ) {
        createResourceIfMissing( 'routes', appName, environment, 'configuration/route.yaml' )
    }
}

def deploy( String appName, String environment ) {
    openshiftDeploy           deploymentConfig: appName, namespace: environment
    openshiftVerifyDeployment deploymentConfig: appName, namespace: environment, verifyReplicaCount: true
    openshiftVerifyService    serviceName:      appName, namespace: environment
}

try {

    node( 'maven' ) {
        stage( 'DEV: Initialise' ) {
        }

        stage( 'DEV: Checkout' ) {
            git url: '[GIT_REPOSITORY_URL]/[SERVICE_ARTIFACT_ID].git', branch: GIT_BRANCH, credentialsId: CREDENTIALS_ID

            application_name    = get_application_name()
            application_version = get_application_version()

            stash name: 'resources', includes: 'configuration/*.yaml'
        }

        stage( 'DEV: Build Artifact' ) {
            sh "mvn -N io.takari:maven:wrapper -Dmaven=3.3.9 -s configuration/settings.xml"
            mvn '--version'

            mvn 'install -DskipTests'
        }

        stage( 'DEV: Quality Checks' ) {
            mvn 'verify'
            cucumber 'target/cucumber.json'
            mvn 'pact:verify -D[PRODUCER_SERVICE].host=[PRODUCER_SERVICE]'
            // mvn 'dependency-check:check'

            // Due to memory constraints, the sonar Maven goal can't be joined with other goals such as verify!
            mvn "sonar:sonar -Dsonar.host.url=${env.SONAR_HOST_URL}"

            // def httpResponse          = httpRequest "${env.SONAR_HOST_URL}/api/qualitygates/project_status?projectKey=${application_name}"
            // def projectStatusResponse = readJSON text: httpResponse.content
            // def qualityGateStatus     = projectStatusResponse.projectStatus.status
            // echo "Quality Gate Status: ${qualityGateStatus}" // Must wait, given a webhook or a retry block, for analysis to complete!

            // if ( qualityGateStatus != 'OK' ) {
                // error "Quality Gate Failed: ${qualityGateStatus}"
            // }
        }

        stage( 'DEV: Update Build Resources' ) {
            createOrApplyResource( 'is', application_name, DEV_PROJECT_NAME, 'configuration/image-stream.yaml' )
            createOrApplyResource( 'bc', application_name, DEV_PROJECT_NAME, 'configuration/build-config.yaml' )
        }

        stage( 'DEV: Build Image' ) {
            sh "oc start-build ${application_name} --from-dir=. --follow -n ${DEV_PROJECT_NAME}"
        }

        stage( 'DEV: Tag' ) {
            openshiftTag srcStream: application_name, srcTag: 'latest', destinationStream: application_name, destinationTag: application_version, verbose: true, namespace: DEV_PROJECT_NAME
        }

        stage( 'DEV: Update Deployment Resources' ) {
            updateDeploymentResources( application_name, DEV_PROJECT_NAME )
        }

        stage( 'DEV: Deploy' ) {
            deploy( application_name, DEV_PROJECT_NAME )
        }

        stage( 'TST: Update Deployment Resources' ) {
            updateDeploymentResources( application_name, TST_PROJECT_NAME )
        }

        stage( 'TST: Deploy' ) {
            deploy( application_name, TST_PROJECT_NAME )
        }

        // How about Blue/Green route deployments or A/B Testing?

        stage( 'STG: Update Deployment Resources' ) {
            updateDeploymentResources( application_name, STG_PROJECT_NAME )
        }

        stage( 'STG: Deploy' ) {
            deploy( application_name, STG_PROJECT_NAME )
        }
    }

} catch ( exception ) {
    currentBuild.result = 'FAILURE'
    notifySlack( currentBuild.result )
    throw exception
}
