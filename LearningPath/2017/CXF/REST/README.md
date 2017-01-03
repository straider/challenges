:: CXF :: REST ::
=================

# Overview

Learning Path followed to learn the basic of REST with CXF.

## Goal and Objectives

The goal is to learn how to develop a REST service using Apache CXF, using Maven / Gradle based Java projects developed from scratch, with no archetypes.

A secondary objective is to develop the service following TDD / BDD, using JUnit for Unit Testing and Spock / Cucumber for Integration Testing. The language for testing sources should be Groovy.

## Service

The service offers two methods:
- _speak()_: a GET method that returns a greeting message, accessible by path ```/speak?name=[NAME]```, where **name** query parameter is optional;
- _setGreeting()_: a PUT method that sets the greeting of the message, accessible by path ```/greeting/{GREETING}```, where the path parameter is mandatory.

**Note**:
- by default, the greeting message format is "Hello, [NAME]!", where [NAME] if not given defaults to "World";
- The GET method always returns HTTP code 200 - OK - even if [NAME] is empty;
- The PUT method returns HTTP code 205 - Accepted - to signal that request was accepted;
- The PUT method will return HTTP code 404 - Not Found - if no path parameter is provided;
- Any of the methods will return HTTP code 405 - Method Not Allowed - if the requested method does not match the right GET or PUT methods.

Follow one of the these resources for more information on HTTP return codes:
- [W3C Status Code Definitions](https://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html)
- [List of HTTP status codes](https://en.wikipedia.org/wiki/List_of_HTTP_status_codes)
- [HTTP Status Codes](http://www.restapitutorial.com/httpstatuscodes.html)
- [HTTP Status Codes](https://httpstatuses.com/)

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
- [Spring Boot Jersey Starter](https://github.com/spring-projects/spring-boot/tree/master/spring-boot-starters/spring-boot-starter-jersey)
- [Apache CXF Spring Boot Starter JAX RS](http://cxf.apache.org/docs/springboot.html#SpringBoot-SpringBootCXFJAX-RSStarter)

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
