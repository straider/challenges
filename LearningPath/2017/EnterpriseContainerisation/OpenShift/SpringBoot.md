:: OpenShift :: SpringBoot ::
=============================

# Overview

This challenge is open to learn about building and deploying SpringBoot applications into OpenShift projects.

As a secondary challenge, the SpringBoot applications should be based on Spring Data that persists to a MongoDB instance.

# Resources

## Articles

- [A Guide to Effortless Spring on OpenShift](https://blog.openshift.com/a-guide-to-effortless-spring-on-openshift/)
- [Using Spring Boot on OpenShift](https://blog.openshift.com/using-spring-boot-on-openshift/)
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
- []()
- []()
- []()
- []()
- []()

## Tools

- [OpenShift S2I Builder for Java](https://github.com/jorgemoralespou/s2i-java)
- [OpenShift S2I Builder for Spring Boot](https://github.com/jorgemoralespou/osev3-examples/tree/master/spring-boot/springboot-sti)
- [codecentric/springboot-maven3-centos](https://github.com/codecentric/springboot-maven3-centos): Spring Boot - Maven 3 - CentOS Docker image.
- [Spring-Boot-Jar-Runner](https://bitbucket.org/markus_ebenhoeh/openshift-cartridge-spring-boot-jar-runner): OpenShift Cartridge to run binary JAR packaged Sping-Boot web applications.
- []()
- []()
- []()
- []()

## Examples

- [Starpark User Service](https://github.com/davgordo/starpark-users): Simple CRUD with Spring Boot and Mongo
- [kolorobot/openshift-diy-spring-boot-sample](https://github.com/kolorobot/openshift-diy-spring-boot-sample)
- [jorgemoralespou/springmlb-openshift3](https://github.com/jorgemoralespou/springmlb-openshift3): The Spring + MongoDB OpenShift 3 application
- []()
- []()
- []()
- []()
- []()

# Milestones

- MongoDB Instance;
- Spring Data Models;
- CXF REST / SOAP SpringBoot Aplication (running Tomcat).

# Challenges

Until there's an official SpringBoot S2I it seems that the alternative is to create custom S2I images (or DIY) for SpringBoot applications.

## Dockerise SpringBoot Application

## MondoDB Images

### Ephemeral

### Persistent
