:: EnterpriseIntegration :: Camel ::
====================================

# Overview

- What is Apache Camel?
- Why use Apache Camel?
- What distinct DSL routes does it support?
- If not Camel then what else?

https://www.manning.com/books/camel-in-action
> Apache Camel is a Java framework that lets you implement the standard enterprise integration patterns in a few lines of code. With a concise but sophisticated DSL you snap integration logic into your app, Lego-style, using Java, XML, or Scala. Camel supports over 80 common transports such as HTTP, REST, JMS, and Web Services.
> Apache Camel is an open source integration framework that aims to make integrating systems easier.
> At the core of the Camel framework is a routing engine, or more precisely a routing engine builder. It allows you to define your own routing rules, decide from which sources to accept messages, and determine how to process and send those messages to other destinations. Camel uses an integration language that allows you to define complex routing rules, akin to business processes.

https://www.packtpub.com/application-development/apache-camel-developers-cookbook
> Apache Camel is a de-facto standard for developing integrations in Java, and is based on well-understood Enterprise Integration Patterns. It is used within many commercial and open source integration products. Camel makes common integration tasks easy while still providing the developer with the means to customize the framework when the situation demands it. Tasks such as protocol mediation, message routing and transformation, and auditing are common usages of Camel.

https://dzone.com/articles/apache-camel-integration
> Apache Camel is an open source Java framework that focuses on making integration easier and more accessible to developers. It does this by providing:
- concrete implementations of all the widely used EIPs
- connectivity to a great variety of transports and APIs
- easy to use Domain Specific Language (DSL) to wire EIPs and transports together

## Objectives

- Learn Apache Camel - concepts and terminology:
    - Routing;
    - Endpoint;
    - CamelContext;
    - CamelTemplate;
    - Components:
        - Exchange;
        - Message;
        - Processor;
        - Routes and RouteBuilders.
- Deliver a Java router Camel-ready Maven project skeleton, prepared to hold Unit Tests and Integration Tests in Groovy. It may happen that several different Maven project are required to choose from when starting a project:
    - Camel only;
    - Camel with ActiveMQ;
    - Camel with ActiveMQ and CXF;
    - Camel with ActiveMQ, CXF and ORM.

## Scope

This learning path just focus on Camel standalone, although it also covers its use with ActiveMQ and CXF. It does not cover Camel and SpringBoot or Camel with OSGi Containers, such as Felix or Karaf. It also does not focus on running Camel inside a container, such as Docker, and does not give emphasis to Microservices.

The router is coded in Java and not using Spring or Blueprint XML files, which is more within the OSGi scope.

## Tutorials

- [Apache Camel - Tutorials](http://camel.apache.org/tutorials.html)
- [Apache Camel Hello World example](https://examples.javacodegeeks.com/enterprise-java/apache-camel/apache-camel-hello-world-example/)
- [Apache Camel Using Java DSL](http://www.javainuse.com/camel/camel_java)
- [Intro to Camel By Example](https://davidvaleri.wordpress.com/2013/03/28/intro-to-camel-by-example/)
- [Apache Camel – developing application from the scratch (part 1 / 2)](https://vrtoonjava.wordpress.com/2013/10/20/apache-camel-developing-application-from-the-scratch-part-1-2/)
- [Apache Camel – developing application from the scratch (part 2 / 2)](https://vrtoonjava.wordpress.com/2013/10/20/apache-camel-developing-application-from-the-scratch-part-2-2/)
- [Apache Camel Tutorial—EIP, Routes, Components, Testing, and More](https://dzone.com/articles/apache-camel-tutorial-eip)
- [Camel Introduction](http://www.mastertheintegration.com/camel/camel-introduction.html)
- [Transforming Data with Camel](http://www.mastertheintegration.com/camel/transforming-data-with-camel.html)
- [Camel and Web Services](http://www.mastertheintegration.com/camel/camel-and-web-services.html)
- [Camel and JMS](http://www.mastertheintegration.com/camel/camel-and-jms.html)
- [Using the Timer component with Camel](http://www.mastertheintegration.com/camel/timer-component/using-the-timer-component-with-camel.html)

## Articles

- [Apache Camel: Integration Nirvana](https://dzone.com/articles/apache-camel-integration)
- [Entreprise Integration Pattern with Apache Camel 2.0](http://onjavahell.blogspot.co.uk/2009/05/taking-apache-camel-for-ride.html)

## Books

- [Apache Camel Book In One Page](http://camel.apache.org/book-in-one-page.html)
- [Patterns and Best Practices for Enterprise Integration](http://www.enterpriseintegrationpatterns.com/)
- [Camel Design Patterns](https://leanpub.com/camel-design-patterns)
- [Camel in Action](https://www.manning.com/books/camel-in-action)
- [Camel in Action, Second Edition](https://www.manning.com/books/camel-in-action-second-edition)
- [Apache Camel Developer's Cookbook](https://www.packtpub.com/application-development/apache-camel-developers-cookbook)
- [Mastering Apache Camel](https://www.packtpub.com/application-development/mastering-apache-camel)
- [Instant Apache Camel Message Routing](https://www.packtpub.com/application-development/instant-apache-camel-message-routing)
- [Instant Apache Camel Messaging System](https://www.packtpub.com/application-development/instant-apache-camel-messaging-system)
- [Apache Camel Essentials](https://www.packtpub.com/application-development/apache-camel-essentials)

## Maven Plugins

- [Camel Maven Plugin](http://camel.apache.org/camel-maven-plugin.html) allows to run Enterprise Integration Patterns using Spring for Dependency Injection inside Maven;
- [hawtio Maven](http://hawt.io/plugins/camel/)

# Challenges

## Camel Archetypes for Maven

The following [Maven archetypes](Archetypes/README.md) exist to start Camel projects:

- camel-archetype-java: Java Router
- camel-archetype-groovy: Groovy Router
- camel-archetype-scala: Scala Router
- camel-archetype-activemq: Camel with ActiveMQ
- camel-archetype-blueprint: Blueprint (OSGi) Based Router

## Camel with Maven

### Steps

- Generate from Maven Archetype
- Execute Main Class
- Change route to copy files from tmp/in/ to tmp/out/
- Add plugin to build WAR file

```sh
mvn archetype:generate                             \
    -DarchetypeGroupId=org.apache.camel.archetypes \
    -DarchetypeArtifactId=camel-archetype-java     \
    -DarchetypeVersion=2.17.1                      \
    -DinteractiveMode=false                        \
    -DgroupId=net.kevinboone.mavencameltest        \
    -DartifactId=MavenCamelTest
```

```sh
mvn compile exec:java

mvn compile assembly:single
java -jar target/mavencameltest-1.0-SNAPSHOT-jar-with-dependencies.jar
```

## Camel in Action

## Examples

### [Apache Camel Hello World example](https://examples.javacodegeeks.com/enterprise-java/apache-camel/apache-camel-hello-world-example/)

#### Requirements

#### Steps

### [Apache Camel: Integration Nirvana](https://dzone.com/articles/apache-camel-integration)

#### Requirements

#### Steps

### [Cafe Example](http://camel.apache.org/cafe-example.html)

#### Requirements

#### Steps

### [Loan Broker Example](http://camel.apache.org/loan-broker-example.html)

#### Requirements

#### Steps

### [Tutorial-Example-ReportIncident](http://camel.apache.org/tutorial-example-reportincident.html)

#### Requirements

#### Steps
