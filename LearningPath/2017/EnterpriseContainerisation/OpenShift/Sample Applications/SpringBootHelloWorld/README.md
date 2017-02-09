:: Spring Boot on OpenShift ::
==============================

# Overview

This project holds a simple example of a REST service that runs on SpringBoot and should be deployed into an OpenShift project.

# Steps

- Cloned from [:: CXF :: REST :: Spring Boot ::](https://github.com/straider/challenges/tree/master/LearningPath/2017/CXF/REST/SpringBoot) on GitHub;
- Replace package com.github.straider.java.ws.cxf with com.github.straider.openshift.springboot;
- Fix name, description and URL on pom.xml;
- Create Dockerfile.

## ToDos

- Add "environment" configuration properties, to be used before executing a deployment;
- Add Gradle build files;
- Add Swagger UI;
- Use Docker Plugins to create the Docker Image using the Dockerfile;
- Launch it in a Docker container;
- Add OpenShift health checks?

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

After login in to OpenShift with a user such as openshift-dev then issue the following commands:

#### Create Project

```bash
oc new-project springboot-helloworld --display-name="SpringBoot CXF HelloWorld on OpenShift" --description="Learning project about building and deploying using OpenShift Client Tool."
```

#### Create Build Configuration

```bash
oc new-build --binary --name=springboot-helloworld --labels=app=springboot-helloworld -n springboot-helloworld
```

**Note**: this only needs to be done once, for the first time, since there's no build configuration after a project is created.

#### Start Build Image

```bash
oc start-build springboot-helloworld --from-dir=. --follow -n springboot-helloworld
```

**Note**: this will spin up a build POD that will create the Docker image and push it into the internal Docker registry.

#### Create Application

```bash
oc new-app springboot-helloworld --labels=app=springboot-helloworld -n springboot-helloworld
```

**Note**: this only needs to be done once, for the first time, since an application is created only once (if not deleted). It will create a deployment configuration and a service.

#### Deploy Application

```bash
oc deploy springboot-helloworld -n springboot-helloworld
```

**Note**: this is to done after the first time, when the application is created together with a deployment configuration and a service.

#### Expose Service with a Route

```bash
oc expose svc/springboot-helloworld -n springboot-helloworld
```
