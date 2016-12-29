:: Apache CXF ::
================

# Overview

## Goal and Objectives

### What's the purpose of WEB-INF/web.xml?

[http://tutorials.jenkov.com/java-servlets/web-xml.html](web.xml Servlet Configuration)

https://cloud.google.com/appengine/docs/java/config/webxml:
> Java web applications use a deployment descriptor file to determine how URLs map to servlets, which URLs require authentication, and other information. This file is named web.xml , and resides in the app's WAR under the WEB-INF/ directory. web.xml is part of the servlet standard for web applications.

> [Servlet mapping](javapapers.com/servlet/what-is-servlet-mapping/) specifies the web container of which java servlet should be invoked for a url given by client. It maps url patterns to servlets. When there is a request from a client, servlet container decides to which application it should forward to. Then context path of url is matched for mapping servlets.

## Audience

## Scope

# Resources

- [Apache CXF](http://cxf.apache.org/)
- [Apache CXF](https://github.com/apache/cxf) @ GitHub
- [Apache CXF](https://en.wikipedia.org/wiki/Apache_CXF) @ Wikipedia

## Tutorials

### REST

- [Simple JAX-RS Web Service in Java with Spring and CXF](http://www.dreamsyssoft.com/blog/blog.php?/archives/7-Simple-REST-Web-Service-in-Java-with-Spring-and-CXF.html)
    - Without tests.
- [Restful Webservice using CXF and Maven](http://java-hub.blogspot.co.uk/2015/01/restful-webservice-using-cxf-and-maven.html)
    - Using Maven archetype: org.apache.cxf.archetype:cxf-jaxrs-service
    - No code, good for getting started.
- [Restful WebService using CXF](http://www.learninjava.com/pages/restful-webservice-using-cxf.php)
    - Using Maven archetype: org.apache.cxf.archetype:cxf-jaxrs-service
- [REST Web Service Using CXF - Beginner's Tutorial](https://dzone.com/articles/rest-web-service-using-cxf)
- [Creating JAX-RS web service using Apache CXF Example](https://examples.javacodegeeks.com/enterprise-java/rest/creating-jax-rs-web-service-using-apache-cxf/)
- ~~[Developing RESTful Services using Apache CXF](https://www.javacodegeeks.com/2013/07/developing-restful-services-using-apache-cxf.html)~~
    - Without source code, incomplete code;
    - Without tests.
- [Developing RESTful Services using Apache CXF](http://weblog4j.com/2012/03/15/developing-restful-services-using-apache-cxf/)
- [How to Easily Build REST Web-Services With Java, Spring and Apache CXF](https://www.appdirect.com/blog/how-to-easily-build-rest-web-services-with-java-spring-and-apache-cxf)
- [Apache CXF to create rest web service](https://sushantworld.wordpress.com/2011/01/23/apache-cxf-restful-web-service/)
- [Create a REST API using CXF and Spring](http://fandry.blogspot.co.uk/2012/05/rest-api-with-cxf-and-spring.html)
- [How to create a simple CXF based JAX-RS Client](http://fandry.blogspot.co.uk/2012/06/how-to-create-simple-cxf-based-jax-rs.html)
- [CXF REST Without Spring](http://www.javatips.net/blog/cxf-rest-without-spring)
- [CXF Restful Client Example](http://www.javatips.net/blog/cxf-restful-client)
- [RESTful Services using Apache CXF](http://javajeedevelopment.blogspot.co.uk/2014/07/restful-services-using-apache-cxf.html)
- Develop a simple RESTful Webservices using Apache CXF and Spring Framework:
    - [Part 1](https://idodevjobs.wordpress.com/2014/08/30/develop-a-simple-restful-webservices-using-apache-cxf-and-spring-framework/)
    - [Part 2](https://idodevjobs.wordpress.com/2014/09/25/develop-a-simple-restful-webservices-using-apache-cxf-and-spring-framework-part-ii/)
    - [Part 3](https://idodevjobs.wordpress.com/2014/10/10/develop-a-simple-restful-webservices-using-apache-cxf-and-spring-framework-part-iii-exceptionerror-handling-using-exceptionmapper/)
    - [Part 4](https://idodevjobs.wordpress.com/2015/04/04/develop-a-simple-restful-webservices-using-apache-cxf-and-spring-framework-part-iv-jax-rs-beanparam-example)
- [Apache CXF: JAX-RS Restful web service using JAXB + JSON example](http://www.benchresources.net/apache-cxf-jax-rs-restful-web-service-using-jaxb-json-example/)
- [Going REST: embedding Jetty with Spring and JAX-RS (Apache CXF)](https://aredko.blogspot.co.uk/2013/01/going-rest-embedding-jetty-with-spring.html)
- [Going REST: embedding Tomcat with Spring and JAX-RS (Apache CXF)](https://aredko.blogspot.co.uk/2013/01/going-rest-embedding-tomcat-with-spring.html)
- [Laziness at extreme: developing JAX-RS services with Spring Boot](https://aredko.blogspot.co.uk/2016/04/laziness-at-extreme-developing-jax-rs.html)

### SOAP

- [Developing a Service](http://cxf.apache.org/docs/developing-a-service.html)
- [Developing a Consumer](http://cxf.apache.org/docs/developing-a-consumer.html)
- [Writing a service with Spring](http://cxf.apache.org/docs/writing-a-service-with-spring.html)
- [Spring Boot & Apache CXF – How to SOAP in 2016](https://blog.codecentric.de/en/2016/02/spring-boot-apache-cxf/)
- Roy Tutorials: CXF + Spring + Maven
    - [Create SOAP Webservice using Apache CXF, Spring, Maven](http://www.roytuts.com/create-soap-webservice-using-apache-cxf-spring-maven/)
    - [Consume SOAP Webservice using Apache CXF, Spring, Maven](http://www.roytuts.com/consume-soap-webservice-using-apache-cxf-spring-maven/)
- [Develop a CXF Web Service with Maven and Spring](http://ekivanc.blogspot.co.uk/2012/01/develop-cxf-web-service-with-maven-and.html)
- [Helloworld web service in Eclipse using Tomcat, Apache CXF and Spring](http://sandyiit.blogspot.co.uk/2012/03/helloworld-web-service-in-eclipse-using.html)
- [Developing Web services using Apache CXF and Maven](http://www.ctrl-alt-dev.nl/Articles/CXF-Maven/CXF-Maven.html)
- [JAX-WS SOAP WebService using CXF](http://www.learninjava.com/pages/jaxws-soap-webservice-using-cxf.php)
- [Example of minimal Apache CXF2 web services deployment](https://tpinet.wordpress.com/2013/02/01/example-of-minimal-apache-cxf2-web-services-deployment/)
- [Developing SOAP Web service using Apache CXF](https://www.javacodegeeks.com/2013/06/developing-soap-web-service-using-apache-cxf.html)
- [Apache CXF – JAX-WS – Simple Tutorial](https://alvinjayreyes.com/2013/05/05/apache-cxf-jax-ws-simple-tutorial/)
- [How to create a WSDL-first SOAP client in Java with CXF and Maven](http://www.logicsector.com/java/how-to-create-a-wsdl-first-soap-client-in-java-with-cxf-and-maven/)
- [Creating a WSDL-first web service with Apache CXF or GlassFish Metro](https://web-gmazza.rhcloud.com/blog/entry/web-service-tutorial)
- [Creating a Java-first web service using CXF or Metro](http://web-gmazza.rhcloud.com/blog/entry/java-first-web-service)
- [Creating a SOAP client with either Apache CXF or GlassFish Metro](http://web-gmazza.rhcloud.com/blog/entry/soap-client-tutorial)
- [Creating a Web Service from scratch using Spring + Maven + Apache CXF](https://aldavblog.wordpress.com/2015/01/22/creating-a-web-service-from-scratch-using-spring-maven-apache-cxf/)

## Articles

- [JSR 311 Final: Java API for RESTful Web Services](https://www.infoq.com/news/2008/09/jsr311-approved)
- [A Comparison of JAX-RS Implementations](https://www.infoq.com/news/2008/10/jaxrs-comparison)
- [JAX-RS Vendor Comparisons - Part I](http://www.jroller.com/Solomon/entry/jax_rs_vendor_comparisons_part)
- [JAX-RS Spring Integration](http://www.jroller.com/Solomon/entry/jax_rs_spring_integration)
- [Apache CXF vs. Apache AXIS vs. Spring WS](https://dzone.com/articles/apache-cxf-vs-apache-axis-vs)
- [Difference between JAX-RS Specification Implementation tools](http://nagesh625.blogspot.co.uk/2014/01/difference-between-jax-rs-specification.html)

## Books

- [RESTful Web Services Cookbook](http://shop.oreilly.com/product/9780596801694.do)
- [RESTful Java with JAX-RS](http://shop.oreilly.com/product/9780596158057.do)
- [RESTful Web Services](http://shop.oreilly.com/product/9780596529260.do)
- [Java Web Services: Up and Running](http://shop.oreilly.com/product/9780596521134.do)

## Tools

- [Java to WS](http://cxf.apache.org/docs/java-to-ws.html)
- [WSDL to Java](http://cxf.apache.org/docs/wsdl-to-java.html)
- [WSDL Validator](http://cxf.apache.org/docs/wsdlvalidator.html)
- [XSD to WSDL](http://cxf.apache.org/docs/xsd-to-wsdl.html)
- [WSDL to SOAP](http://cxf.apache.org/docs/wsdl-to-soap.html)
- [RESTUtils](https://github.com/taimos/RESTUtils): Utility classes for JAX-RS

### Maven Plugins

- [Maven POM Information](http://cxf.apache.org/docs/using-cxf-with-maven.html)
- [CXF Maven Archetypes](https://github.com/apache/cxf/tree/master/maven-plugins/archetypes)
- [java2wadl Maven plugin](http://cxf.apache.org/docs/jaxrs-services-description.html#JAXRSServicesDescription-java2wadlMavenplugin)
- [cxf-codegen-plugin](http://cxf.apache.org/docs/maven-cxf-codegen-plugin-wsdl-to-java.html)
- [cxf-java2ws-plugin](http://cxf.apache.org/docs/maven-java2ws-plugin.html)
- [cxf-xjc-plugin](http://cxf.apache.org/cxf-xjc-plugin.html)
- [Apache Tomcat Maven Plugin](http://tomcat.apache.org/maven-plugin.html)
- [Jetty Maven Plugin](https://www.eclipse.org/jetty/documentation/9.4.x/jetty-maven-plugin.html)

### Gradle Plugins

# Milestones

## Parent pom.xml

Create pom.xml with project properties, dependencies and plugins used by all modules.

## Greeter Module

Simple object that really performs the greeting: returns a greeting message.

## REST Server Module

- [Swagger2Feature](http://cxf.apache.org/docs/swagger2feature.html)

This module holds specific CXF REST properties and dependencies and defines profiles for each "infrastructure":
- Standalone?
- Tomcat
- Jetty
- Undertow?
- SpringBoot
- Karaf?

### Java First

- [WADL Auto Generation at Runtime](http://cxf.apache.org/docs/jaxrs-services-description.html#JAXRSServicesDescription-WADLAutoGenerationatRuntime)

### WADL First

- [WADL-first Development](http://cxf.apache.org/docs/jaxrs-services-description.html#JAXRSServicesDescription-WADL-firstDevelopment)

## REST Client Module

## SOAP Server Module

### Java-first

### WSDL-first

## SOAP Client Module

# Challenges

- Use Tomcat 7 / Tomcat 8
- Replace with Jetty
- How to do Unit Testing?
- How to do Integration Testing?
- How to produce WADL?
