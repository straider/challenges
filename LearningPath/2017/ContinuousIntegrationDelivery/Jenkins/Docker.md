:: CI/CD :: Jenkins on Docker ::
================================

# Overview

This document describes the steps necessary to run Jenkins on Docker in Windows.

## Why running Jenkins on Docker?

The main reason is that instead of having to deal with Windows vs. Linux when using a "dockerised" Jenkins then one only has to deal with Linux configuration.

It also means that one can take the image to another platform and still have the same configuration to deal with. Although similar to have it inside a Vagrant box it has a distinct "advantage": it's immutable and always works the same way while if inside a Vagrant box it would persist not only the configuration but also undesirable side-effects.

## Alternatives

- Running natively on Windows (as a service);
- Running on a Vagrant box;
- Running on a PaaS (such as OpenShift).

# Resources

## Tutorials

## Articles

- [Installing Jenkins with Docker](https://wiki.jenkins-ci.org/display/JENKINS/Installing+Jenkins+with+Docker)
- [Get Started with Jenkins 2.0 with Docker](https://www.cloudbees.com/blog/get-started-jenkins-20-docker)
- [Continuous Integration, Delivery or Deployment with Jenkins, Docker and Ansible](https://technologyconversations.com/2015/02/11/continuous-integration-delivery-or-deployment-with-jenkins-docker-and-ansible/)
- [Putting Jenkins in a Docker Container](https://engineering.riotgames.com/news/putting-jenkins-docker-container)

## Docker Images

- [jenkins](https://hub.docker.com/_/jenkins/): Official Jenkins Docker image.
- [Jenkins Continuous Integration and Delivery server](https://hub.docker.com/r/jenkinsci/jenkins/)
- [Docker image for Pipeline demo](https://github.com/jenkinsci/workflow-aggregator-plugin/tree/master/demo)
- [cloudbees/workflow-demo](https://hub.docker.com/r/cloudbees/workflow-demo/): Demo for Jenkins Pipeline with the CloudBees Jenkins Enterprise proprietary checkpoint extension.
- [jenkinsci/workflow-demo](https://hub.docker.com/r/jenkinsci/workflow-demo/): Demo of Jenkins Workflow feature.
- [Docker image for Docker Pipeline demo](https://github.com/jenkinsci/docker-workflow-plugin/tree/master/demo)
- [jenkinsci/docker-workflow-demo](https://hub.docker.com/r/jenkinsci/docker-workflow-demo/): Demonstrating use of the CloudBees Docker Workflow plugin.
- [jenkinsci/pipeline-as-code-github-demo](https://hub.docker.com/r/jenkinsci/pipeline-as-code-github-demo/): Demonstration of Jenkins 2.0 “Pipeline-as-Code” using GitHub.
- [lionelve/pipeline-demo](https://hub.docker.com/r/lionelve/pipeline-demo/): Jenkins Pipeline Demo.
- [Jotschi/maven-release-workflow-test](https://github.com/Jotschi/maven-release-workflow-test): Dummy Jenkins Pipeline/Workflow Example.
- [evarga/jenkins-slave](https://hub.docker.com/r/evarga/jenkins-slave/): basic container to be used as a Jenkins slave build node.
- [jenkinsci/jnlp-slave](https://hub.docker.com/r/jenkinsci/jnlp-slave/): a Jenkins slave using JNLP to establish connection.
- [jenkinsci/blueocean](https://hub.docker.com/r/jenkinsci/blueocean/)

## Plugins

- [Docker Plugin](https://wiki.jenkins-ci.org/display/JENKINS/Docker+Plugin): to be able to use a docker host to dynamically provision a slave, run a single build, then tear-down that slave.

# Steps

The version to use should be 2.0, since it one of its highlights is the ["built in support for delivery pipelines"](https://jenkins.io/2.0/#pipelines), while still being backwards compatible with 1.0.

## Install Docker

- Docker Toolbox
- Docker on Windows

## Pull Latest Image

```bash
docker pull jenkins:2.32.1-alpine
docker pull jenkinsci/jenkins:2.43
docker pull jenkinsci/jenkins:1.658
docker pull jenkinsci/blueocean:1.0.0-b20

docker pull jenkinsci/workflow-demo:2.4
docker pull jenkinsci/docker-workflow-demo:1.9
docker pull jenkinsci/pipeline-as-code-github-demo:1.10

docker pull jenkinsci/jnlp-slave

docker pull fabric8/jenkins-docker
```

## Run Docker Image

```bash
docker run -p 8080:8080 -p 50000:50000 jenkins
docker run -p 8080:8080 -p 50000:50000 -v [LOCAL_JENKINS_HOME]:/var/jenkins_home jenkins

docker run jenkinsci/jnlp-slave -url http://jenkins-server:port <secret> <slave name>

docker run -it -p 8080:8080 --name jenkins -e SEED_GIT_URL=https://github.com/fabric8io/default-jenkins-dsl.git -e NEXUS_SERVICE_HOST=dockerhost -e NEXUS_SERVICE_PORT=8081 fabric8/jenkins
```

Where [LOCAL_JENKINS_HOME] is to be replaced by the local folder to hold Jenkins data (configuration and plugins).

## Configure Jenkins Master

## Configure Jenkins Slaves

## Configure Jenkins Pipeline

## Proxy

- [JenkinsBehindProxy](https://wiki.jenkins-ci.org/display/JENKINS/JenkinsBehindProxy)
- [Jenkins: Configuring a Proxy](http://blogs.wandisco.com/2012/08/15/jenkins-configuring-proxy/)
- [How do you configure Jenkins to work with a proxy server?](https://jazz.net/forum/questions/214230/how-do-you-configure-jenkins-to-work-with-a-proxy-server)
- [Jenkins meets the corporate proxy](http://blog.alexellis.io/jenkins-meets-the-proxy/)
