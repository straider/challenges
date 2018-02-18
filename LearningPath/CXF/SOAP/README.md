:: CXF :: SOAP ::
=================

# Overview

Learning Path followed to learn the basic of SOAP with CXF.

## Goal and Objectives

The goal is to learn how to develop a SOAP service using Apache CXF, using Maven / Gradle based Java projects developed from scratch, with no archetypes.

A secondary objective is to develop the service following TDD / BDD, using JUnit for Unit Testing and Spock / Cucumber for Integration Testing. The language for testing sources should be Groovy.

## Service

The service offers two methods:
- _speak()_: a POST method that returns a greeting message, given a request with an optional name element;
- _setGreeting()_: a POST method that sets the greeting of the message, given a request with a mandatory path element.

**Note**: by default, the greeting message format is "Hello, [NAME]!", where [NAME] if not given defaults to "World".

# Milestones

## Standalone

## Tomcat

Use Maven / Gradle plugins to launch a Tomcat instance that runs the service.

## Jetty

Use Maven / Gradle plugins to launch a Jetty instance that runs the service.

## Undertow

Use Maven / Gradle plugins to launch a Undertow instance that runs the service.

## Spring Boot

Use Maven / Gradle plugins to launch a Spring Boot instance that runs the service.

- [Spring Boot Maven Plugin](http://docs.spring.io/spring-boot/docs/1.4.3.RELEASE/maven-plugin/)
- [Spring Boot Maven plugin](http://docs.spring.io/spring-boot/docs/1.4.3.RELEASE/reference/html/build-tool-plugins-maven-plugin.html)
- [Spring Boot Gradle plugin](http://docs.spring.io/spring-boot/docs/1.4.3.RELEASE/reference/html/build-tool-plugins-gradle-plugin.html)
- [Spring Boot Parent]()
- [Spring Boot Test]()
- [Spring Boot Test Starter]()
- [Spring Boot Gradle Integration Tests]()
- [Spring Boot Starter Parent](https://github.com/spring-projects/spring-boot/tree/master/spring-boot-starters/spring-boot-starter-parent)
- [Spring Boot Starter](https://github.com/spring-projects/spring-boot/tree/master/spring-boot-starters/spring-boot-starter)
- [Spring Boot Tomcat Starter](https://github.com/spring-projects/spring-boot/tree/master/spring-boot-starters/spring-boot-starter-tomcat)
- [Spring Boot Jetty Starter](https://github.com/spring-projects/spring-boot/tree/master/spring-boot-starters/spring-boot-starter-jetty)
- [Spring Boot Undertow Starter](https://github.com/spring-projects/spring-boot/tree/master/spring-boot-starters/spring-boot-starter-undertow)
- [Spring Boot Web Starter](https://github.com/spring-projects/spring-boot/tree/master/spring-boot-starters/spring-boot-starter-web)
- [Spring Boot Web Services Starter](https://github.com/spring-projects/spring-boot/tree/master/spring-boot-starters/spring-boot-starter-web-services)
- [Apache CXF Spring Boot Starter JAX WS](http://cxf.apache.org/docs/springboot.html#SpringBoot-SpringBootCXFJAX-WSStarter)

## Karaf

Use Maven / Gradle plugins to launch a Karaf instance that runs the service.

# Challenges

- Use Embedded Jetty as the standalone container;
- Fix logging issues, using SLF4J Simple;
- How to enable XML and JSON support / mapping?
    - Using Jettison (follows JAXB more closely than Jackson);
    - Using Jackson (allows YAML, XML and other formats, but outputs dates as timestamps).
- How to do integration testing?
- How to enable cxf/services/?
    - It's enabled when using CXFNonSpringJaxrsServlet or CXFServlet.
- How to enable WADL?
- How to register multiple services on same endpoint?
- What's the difference between Standalone, CXFNonSpringServlet and CXFSpringServlet?
