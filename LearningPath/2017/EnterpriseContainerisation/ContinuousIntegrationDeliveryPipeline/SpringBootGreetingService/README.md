:: Spring Boot on OpenShift ::
==============================

# Overview

This project holds a simple example of a REST service that runs on SpringBoot and should be deployed into an OpenShift project.

# Steps

- Cloned from [:: CXF :: REST :: Spring Boot ::](https://github.com/straider/challenges/tree/master/LearningPath/2017/CXF/REST/SpringBoot) on GitHub;
- Replace package com.github.straider.java.ws.cxf with com.github.straider.openshift.springboot;
- Fix name, description and URL on pom.xml;
- Create Dockerfile;
- Include Jenkinsfile script for the pipeline.

## ToDos

- Add Swagger UI to pom.xml;
- Use Docker Maven Plugin to create the necessary Dockerfile;
- Launch it in a Docker container.

## Challenges

### SpringBoot

This CXF Greeting Service could run in standalone mode or deployed to a Servlet Container.
SpringBoot allows to easily switch between Tomcat, Jetty or Undertow and as such is a good candidate to run Java REST services in OpenShift.

### Docker

- Code Dockerfile by hand;
- Choose and use one of the many Docker Maven Plugins:
    - [alexec/docker-maven-plugin](https://github.com/alexec/docker-maven-plugin);
    - [wouterd/docker-maven-plugin](https://github.com/wouterd/docker-maven-plugin);
    - [spotify/docker-maven-plugin](https://github.com/spotify/docker-maven-plugin);
    - [fabric8io/docker-maven-plugin](https://github.com/fabric8io/docker-maven-plugin).

#### Environment Variables

Before running it on a Docker container and if not using Docker Quickstart Terminal then it's necessary to configure the environment with some Docker variables.

To configure the environment with Docker environment variables then choose one of the following ways:

With Windows Command Prompt then issue this command:
```bash
@FOR /f "tokens=*" %i IN ('docker-machine env --shell cmd default') DO @%i
```

With MinGW mintty then issue this command:
```bash
eval $( docker-machine env )
```

#### NO_PROXY Configuration

The Docker Machine IP Address needs to be excluded from going through the proxy.

To configure the NO_PROXY environment variable with the Docker Machine IP Address then choose one of the following ways:

With Windows Command Prompt then issue this command:
```bash
set NO_PROXY=%NO_PROXY%,'docker-machine ip'
```

With MinGW mintty then issue this command:
```bash
eval $( docker-machine env )
export NO_PROXY=$no_proxy
```

#### Launch Docker Container

To launch a Docker container with the SpringBoot application then issue the following commands:
```bash
docker rmi --force mo/springboot-on-openshift                     # Removes previous image.
docker build --force-rm --rm=true -t mo/springboot-on-openshift . # Builds new image.
docker run -p 10000:10000 -d mo/springboot-on-openshift           # Runs a Docker container that exposes port 10000.
```

### OpenShift

To enable the Technology Preview feature Jenkins Pipelines then issue the following commands inside the Vagrant box:

```bash
```

Before issuing the commands in the next sections please login to OpenShift Origin as openshift-dev:

```bash
oc login 10.2.2.2:8443 -u openshift-dev -p devel
```

#### Create "Environment" Projects

```bash
oc new-project greeter-dev --display-name="GreetingService - DEV" --description="Development Environment for CXF Greeting Service Demo"
oc new-project greeter-tst --display-name="GreetingService - TST" --description="Testing Environment for CXF Greeting Service Demo"
oc new-project greeter-stg --display-name="GreetingService - STG" --description="Staging Environment for CXF Greeting Service Demo"
oc new-project greeter-prd --display-name="GreetingService - PRD" --description="Production Environment for CXF Greeting Service Demo"
```

#### Create CI/CD Pipeline Project

```bash
oc new-project ci-cd-pipeline --display-name="CI/CD Pipeline" --description="Jenkins based CI/CD Pipeline"
```

#### Give Permissions to Service Account

```bash
oc policy add-role-to-user edit system:serviceaccount:ci-cd-pipeline:default -n greeter-dev
oc policy add-role-to-user edit system:serviceaccount:ci-cd-pipeline:default -n greeter-tst
oc policy add-role-to-user edit system:serviceaccount:ci-cd-pipeline:default -n greeter-stg
oc policy add-role-to-user edit system:serviceaccount:ci-cd-pipeline:default -n greeter-prd
```

#### Install Jenkins Persistent Image

```bash
oc new-app --name=jenkins-101 --template=jenkins-persistent
oc expose svc jenkins
oc env dc/jenkins JENKINS_PASSWORD=admin
```
