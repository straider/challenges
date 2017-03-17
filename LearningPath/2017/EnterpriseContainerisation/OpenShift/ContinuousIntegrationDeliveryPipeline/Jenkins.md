:: OpenShift :: CI / CD Pipeline :: Jenkins ::
==============================================

# Overview

## Concepts

# Resources

## Articles

- [Microservices CI/CD Pipelines in Openshift](https://developers.redhat.com/blog/2016/09/14/microservices-cicd-pipelines-in-openshift/)
- [OpenShift 3.3 Pipelines – Deep Dive](https://blog.openshift.com/openshift-3-3-pipelines-deep-dive/)

## Demos

- [jenkinsci/pipeline-plugin Tutorial](https://github.com/jenkinsci/pipeline-plugin/blob/master/TUTORIAL.md)
- [Docker image for Pipeline demo](https://github.com/jenkinsci/workflow-aggregator-plugin/blob/master/demo/README.md)
- [CI / CD with Red Hat OpenShift and Jenkins](http://www.opensourcerers.org/ci-cd-red-hat-openshift-jenkins/)
- [Pipelines with Jenkins 2 on OpenShift](https://blog.openshift.com/pipelines-with-jenkins-2-on-openshift/)
    - [Creating a Jenkins Cluster in OpenShift](http://blog.andyserver.com/2016/01/jenkins-cluster-openshift/)
    - [Dynamic Jenkins Slave Provisioning on OpenShift](http://blog.andyserver.com/2016/01/dynamic-jenkins-slave-provisioning-on-openshift/)
    - [Jenkins Slaves in OpenShift Using an External Jenkins Environment](http://blog.andyserver.com/2016/02/jenkins-slaves-openshift-external-jenkins-environment/)
- [CI/CD with OpenShift](https://blog.openshift.com/cicd-with-openshift/)
    - [OpenShift 3 CI/CD Demo](https://github.com/OpenShiftDemos/openshift-cd-demo)
    - [OpenShift Tasks: JAX-RS, JPA quickstart](https://github.com/OpenShiftDemos/openshift-tasks/tree/eap-7)
- [Create Your Own Build Pipelines with OpenShift 3.3](https://blog.openshift.com/create-build-pipelines-openshift-3-3/)
- [OpenShift 3 Jenkins Example](https://github.com/openshift/origin/tree/master/examples/jenkins)
- [Using Jenkins Pipelines with OpenShift](https://github.com/openshift/origin/tree/master/examples/jenkins/pipeline)
- [Jenkins Master example](https://github.com/arilivigni/openshift-ci-pipeline)
- [OpenShift Enterprise 3.3: all-in-one Lab Environment with Jenkins Build Pipeline](https://keithtenzer.com/2016/11/21/openshift-enterprise-3-3-all-in-one-lab-environment-with-jenkins-build-pipeline/)
- [Create and explore Continuous Delivery Pipelines with Fabric8 and Jenkins on OpenShift](https://blog.fabric8.io/create-and-explore-continuous-delivery-pipelines-with-fabric8-and-jenkins-on-openshift-661aa82cb45a#.jmp5xdksp)
- [Continuous Delivery With Docker, Jenkins, JBoss Fuse and OpenShift PaaS](https://dzone.com/articles/continuous-delivery-docker)

## Images

- [OpenShift Jenkins Docker Image](https://github.com/openshift/jenkins)
- [Official Jenkins Docker image](https://hub.docker.com/_/jenkins/)

## Plugins

- [openshift-jenkins-sync](https://github.com/jenkinsci/openshift-sync-plugin) keeps OpenShift BuildConfig and Build objects in sync With Jenkins Jobs and Builds.
- [OpenShift V3 Plugin for Jenkins](https://github.com/jenkinsci/openshift-pipeline-plugin)
- [OpenShift Jenkins Pipeline (DSL) Plugin](https://github.com/jenkinsci/openshift-client-plugin) - Experimental
- [openshift-login](https://github.com/jenkinsci/openshift-login-plugin): The primary scenario is using this plugin when Jenkins is running in a OpenShift pod and the jobs with Jenkins operate against the same OpenShift cluster that Jenkins is running in. In this scenario, no additional configuration is required, but you must be running agaist v1.4 of OpenShift/Origin.
- [Kubernetes Plugin](https://wiki.jenkins-ci.org/display/JENKINS/Kubernetes+Plugin)
- [Kubernetes Pipeline Plugin](https://wiki.jenkins-ci.org/display/JENKINS/Kubernetes+Pipeline+Plugin)
- [Docker Pipeline Plugin](https://wiki.jenkins-ci.org/display/JENKINS/Docker+Pipeline+Plugin)
- [Docker Plugin](https://wiki.jenkins-ci.org/display/JENKINS/Docker+Plugin)
- [Yet Another Docker Plugin](https://wiki.jenkins-ci.org/display/JENKINS/Yet+Another+Docker+Plugin)
- [Docker Commons Plugin](https://wiki.jenkins-ci.org/display/JENKINS/Docker+Commons+Plugin)
- [Docker Slaves Plugin](https://wiki.jenkins-ci.org/display/JENKINS/Docker+Slaves+Plugin)
- [Promoted Builds Plugin](https://wiki.jenkins-ci.org/display/JENKINS/Promoted+Builds+Plugin)

## Pipelines

- [fabric8io/fabric8-pipeline-library](https://github.com/fabric8io/fabric8-pipeline-library)
- [fabric8io/fabric8-jenkinsfile-library](https://github.com/fabric8io/fabric8-jenkinsfile-library)
- [fabric8io/fabric8-jenkins-workflow-steps](https://github.com/fabric8io/fabric8-jenkins-workflow-steps)

# Steps

Must set the memory limit to 2 GB and instead of a randomly generated password must set 'admin' as the password for admin user.

## Using OpenShift Origin Templates

### Install Jenkins Ephemeral image

```bash
# OpenShift Origin
oc new-app --name=jenkins --template=jenkins-ephemeral --param=MEMORY_LIMIT=2Gi,JENKINS_PASSWORD=admin

# OpenShift Container Platform
oc new-app --name=jenkins --template=jenkins-ephemeral --param=MEMORY_LIMIT=2Gi
oc env dc/jenkins JENKINS_PASSWORD=admin
```

### Install Jenkins Persistent image

```bash
# OpenShift Origin
oc new-app --name=jenkins --template=jenkins-persistent --param=MEMORY_LIMIT=2Gi,JENKINS_PASSWORD=admin

# OpenShift Container Platform
oc new-app --name=jenkins --template=jenkins-persistent --param=MEMORY_LIMIT=2Gi
oc env dc/jenkins JENKINS_PASSWORD=admin
```

## Using Docker Images

### Install Jenkins 1.x image

```bash
oc new-app -e JENKINS_PASSWORD=[JENKINS_PASSWORD] openshift/jenkins-1-centos7
```

### Install Jenkins 2.x image

```bash
oc new-app -e JENKINS_PASSWORD=[JENKINS_PASSWORD] openshift/jenkins-2-centos7
```

## Configure Proxy

## Update Plugins

## Install Plugins

### Required Plugins

- Gradle Plugin;
- OpenShift Client Jenkins Plugin;
- OpenShift Deployer Plugin;
- OpenShift Login Plugin.

### Optional Plugins

- Checkstyle Plug-in;
- PMD Plug-in;
- FindBugs Plug-in;
- SonarQube Plugin;
- Sonar Gerrit Plugin.

## Add Tools

- Add JDK, as jdk-8u121;
- Add Maven, as maven-3.3.9;
- Add Gradle, as gradle-3.3;
- Set JAVA_HOME to /var/lib/jenkins/tools/hudson.model.JDK/jdk-8u121.

# Challenges

## Customise official OpenShift Jenkins image
