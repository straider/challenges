:: OpenShift :: SpringBoot ::
=============================

# Overview

This challenge is open to learn about building and deploying SpringBoot applications into OpenShift projects.

As a secondary challenge, the SpringBoot applications should be based on Spring Data that persists to a MongoDB instance.

# Resources

## Articles

- [A Guide to Effortless Spring on OpenShift](https://blog.openshift.com/a-guide-to-effortless-spring-on-openshift/)
- [Using Spring Boot on OpenShift](https://blog.openshift.com/using-spring-boot-on-openshift/)
- [Spring Boot on OpenShift](http://kim.saabye-pedersen.org/2014/04/spring-boot-on-openshift.html)
- [Deploy a Java 8 Spring Boot application on a DIY Openshift cartridge](http://fabiomaffioletti.me/blog/2015/12/09/openshift-diy-java-8-spring-boot/)
- [Part 1: From App to OpenShift (Runtimes and Templates)](https://blog.openshift.com/part-1-from-app-to-openshift-runtimes-and-templates/)
- [Part 2: Creating a Template – A Technical Walkthrough](https://blog.openshift.com/part-2-creating-a-template-a-technical-walkthrough/)
- [Using OpenShift for Enterprise Grade Spring Boot Deployments](https://blog.openshift.com/using-openshift-enterprise-grade-spring-boot-deployments/)
    - [osev3-examples/spring-boot/springboot-sti/Dockerfile](https://github.com/jorgemoralespou/osev3-examples/blob/master/spring-boot/springboot-sti/Dockerfile)
    - [osev3-examples/spring-boot/springboot-sti/.sti/bin/assemble](https://github.com/jorgemoralespou/osev3-examples/blob/master/spring-boot/springboot-sti/.sti/bin/assemble)
- [Spring Boot Microservice Development on Kubernetes: The Easy Way](http://blog.christianposta.com/microservices/spring-boot-microservice-development-on-kubernetes-the-easy-way/)
- [How to deploy Spring Boot applications to OpenShift](https://blog.codecentric.de/en/2016/03/deploy-spring-boot-applications-openshift/)
- [Continuous integration for Spring Boot app using Codeship + Openshift](http://not4j.com/continius-integratio-of-spring-boot-app-using-codeship-openshift-2/)
- [Spring Cloud Deployer OpenShift](https://blog.switchbit.io/spring-cloud-deployer-openshift/)
- [Performance Metrics (APM) for Spring Boot Microservices on OpenShift](https://blog.openshift.com/performance-metrics-apm-spring-boot-microservices-openshift/)

## Tools

- [OpenShift S2I Builder for Java](https://github.com/jorgemoralespou/s2i-java)
- [OpenShift S2I Builder for Spring Boot](https://github.com/jorgemoralespou/osev3-examples/tree/master/spring-boot/springboot-sti)
- [codecentric/springboot-maven3-centos](https://github.com/codecentric/springboot-maven3-centos): Spring Boot - Maven 3 - CentOS Docker image.
- [Spring-Boot-Jar-Runner](https://bitbucket.org/markus_ebenhoeh/openshift-cartridge-spring-boot-jar-runner): OpenShift Cartridge to run binary JAR packaged Sping-Boot web applications.

## Examples

- [jirkapinkas/spring-boot-openshift](https://github.com/jirkapinkas/spring-boot-openshift)
- [marcelmaatkamp/openshift-spring-boot-example](https://github.com/marcelmaatkamp/openshift-spring-boot-example)
- [kolorobot/openshift-diy-spring-boot-sample](https://github.com/kolorobot/openshift-diy-spring-boot-sample)
- [kolorobot/openshift-diy-spring-boot-gradle](https://github.com/kolorobot/openshift-diy-spring-boot-gradle)
- [kolorobot/openshift-wildfly-spring-boot](https://github.com/kolorobot/openshift-wildfly-spring-boot)
- [gshipley/bootwildfly](https://github.com/gshipley/bootwildfly): starter Spring Boot application for deploying to WildFly.
- [lbroudoux/spring-boot-hello](https://github.com/lbroudoux/spring-boot-hello)
- [jorgemoralespou/springmlb-openshift3](https://github.com/jorgemoralespou/springmlb-openshift3): The Spring + MongoDB OpenShift 3 application
- [Starpark User Service](https://github.com/davgordo/starpark-users): Simple CRUD with Spring Boot and Mongo

# Milestones

- MongoDB Instance;
- Spring Data Models;
- CXF REST / SOAP SpringBoot Aplication (running Tomcat).

# Challenges

Until there's an official SpringBoot S2I it seems that the alternative is to create custom S2I images (or DIY) for SpringBoot applications or manually build Docker images with ```oc start-build``` command.

## Dockerise SpringBoot Application

The following simple Dockerfile example will result in a Docker image with a runnable SpringBoot application:

```
FROM openjdk:8-jre-alpine

EXPOSE 10000

RUN adduser -D -g '' app-user
USER app-user
WORKDIR /home/app-user

COPY target/[SPRINGBOOT_APPLICATION_JAR] .
COPY target/lib/ ./lib

ENTRYPOINT [ "sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -jar [SPRINGBOOT_APPLICATION_JAR]" ]
```
Where [SPRINGBOOT_APPLICATION_JAR] must be replaced by the SpringBoot application JAR that was built previously, usually by Maven or Gradle.

## MondoDB Images

### Ephemeral

### Persistent
