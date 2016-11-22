:: Enterprise Integration :: Spring Integration ::
==================================================

# Overview

[Spring](https://spring.io/), by Pivotal

> The [Spring Framework](https://en.wikipedia.org/wiki/Spring_Framework) is an application framework and inversion of control container for the Java platform. The framework's core features can be used by any Java application, but there are extensions for building web applications on top of the Java EE platform. Although the framework does not impose any specific programming model, it has become popular in the Java community as an alternative to, replacement for, or even addition to the Enterprise JavaBeans (EJB) model. The Spring Framework is open source.

> Extends the Spring programming model to support the well-known Enterprise Integration Patterns. [Spring Integration](https://projects.spring.io/spring-integration/) enables lightweight messaging within Spring-based applications and supports integration with external systems via declarative adapters. Those adapters provide a higher-level of abstraction over Spring's support for remoting, messaging, and scheduling.

> [Spring Cloud Stream](http://cloud.spring.io/spring-cloud-stream/) is a framework for building message-driven microservices. Spring Cloud Stream builds upon Spring Boot to create DevOps friendly microservice applications and Spring Integration to provide connectivity to message brokers. Spring Cloud Stream provides an opinionated configuration of message brokers, introducing the concepts of persistent pub/sub semantics, consumer groups and partitions across several middleware vendors.

## Questions

### What is Spring Integration?

> Spring Integration is a framework for Enterprise application integration that provides reusable functions that are essential in messaging, or event-driven architectures:
- Routers: routes a message to a message channel based on conditions;
- Transformers: converts/transforms/changes the message payload and creates a new message with transformed payload;
- Adapters: to integrate with other technologies and systems (HTTP, AMQP, JMS, XMPP, SMTP, IMAP, FTP (as well as FTPS/SFTP), file systems, etc.);
- Filters: filters message based on criteria. If the criteria are not met, message is dropped;
- Service Activators: invoke an operation on a service object;
- Management and Auditing.

> Spring Integration supports pipe-and-filter based architectures.

http://docs.spring.io/spring-integration/reference/html/overview.html
> Spring Integration is motivated by the following goals:
- Provide a simple model for implementing complex enterprise integration solutions;
- Facilitate asynchronous, message-driven behavior within a Spring-based application;
- Promote intuitive, incremental adoption for existing Spring users.

> Spring Integration is guided by the following principles:
- Components should be loosely coupled for modularity and testability;
- The framework should enforce separation of concerns between business logic and integration logic;
- Extension points should be abstract in nature but within well-defined boundaries to promote reuse and portability.

### Why use Spring Integration?

### Alternatives to Spring Integration?

- [Apache Camel](http://camel.apache.org/)
- [Mule ESB](https://www.mulesoft.com/platform/soa/mule-esb-open-source-esb)
- [Apache Synapse Enterprise Service Bus](http://synapse.apache.org/)
- [Apache ServiceMix](http://servicemix.apache.org/index.html)
- [JBoss ESB](http://jbossesb.jboss.org/)

## Objectives

- Learn Spring Integration - concepts and terminology;
- Deliver a Java router Spring Integration-ready Maven project skeleton, prepared to hold Unit Tests and Integration Tests in Groovy. It may happen that several different Maven project are required to choose from when starting a project:
    - Spring Integration only;
    - Spring Integration with ActiveMQ;
    - Spring Integration with ActiveMQ and Spring WebServices or Spring REST;
    - Spring Integration with ActiveMQ, Spring WebServices or Spring REST and Spring Data.

## Scope

This learning path just focus on Spring Integration standalone, although it also covers its use with ActiveMQ, Spring WebServices or Spring REST and Spring Data. It does not cover SpringBoot or Spring Integration with OSGi Containers, such as Felix or Karaf. It also does not focus on running Spring Integration inside a container, such as Docker, and does not give emphasis to Microservices.

## History

# Architecture

## Main Components

### Message

> In Spring Integration, a Message is a generic wrapper for any Java object combined with metadata used by the framework while handling that object. It consists of a payload and headers. The payload can be of any type and the headers hold commonly required information such as id, timestamp, correlation id, and return address. Headers are also used for passing values to and from connected transports.

### Message Channel

> A Message Channel represents the "pipe" of a pipes-and-filters architecture. Producers send Messages to a channel, and consumers receive Messages from a channel. The Message Channel therefore decouples the messaging components, and also provides a convenient point for interception and monitoring of Messages. A Message Channel may follow either Point-to-Point or Publish/Subscribe semantics. With a Point-to-Point channel, at most one consumer can receive each Message sent to the channel. Publish/Subscribe channels, on the other hand, will attempt to broadcast each Message to all of its subscribers.

## Message Endpoint

> You should not have to implement consumers and producers directly, and you should not even have to build Messages and invoke send or receive operations on a Message Channel. Instead, you should be able to focus on your specific domain model with an implementation based on plain Objects. Then, by providing declarative configuration, you can "connect" your domain-specific code to the messaging infrastructure provided by Spring Integration. The components responsible for these connections are Message Endpoints

### Message Transformer

> A Message Transformer is responsible for converting a Message’s content or structure and returning the modified Message. Probably the most common type of transformer is one that converts the payload of the Message from one format to another (e.g. from XML Document to java.lang.String). Similarly, a transformer may be used to add, remove, or modify the Message’s header values.

### Message Filter

> A Message Filter determines whether a Message should be passed to an output channel at all. This simply requires a boolean test method that may check for a particular payload content type, a property value, the presence of a header, etc. If the Message is accepted, it is sent to the output channel, but if not it will be dropped (or for a more severe implementation, an Exception could be thrown). Message Filters are often used in conjunction with a Publish Subscribe channel, where multiple consumers may receive the same Message and use the filter to narrow down the set of Messages to be processed based on some criteria.

### Message Router

> A Message Router is responsible for deciding what channel or channels should receive the Message next (if any). Typically the decision is based upon the Message’s content and/or metadata available in the Message Headers. A Message Router is often used as a dynamic alternative to a statically configured output channel on a Service Activator or other endpoint capable of sending reply Messages. Likewise, a Message Router provides a proactive alternative to the reactive Message Filters used by multiple subscribers as described above.

### Splitter

> A Splitter is another type of Message Endpoint whose responsibility is to accept a Message from its input channel, split that Message into multiple Messages, and then send each of those to its output channel. This is typically used for dividing a "composite" payload object into a group of Messages containing the sub-divided payloads.

### Aggregator

> Basically a mirror-image of the Splitter, the Aggregator is a type of Message Endpoint that receives multiple Messages and combines them into a single Message. In fact, Aggregators are often downstream consumers in a pipeline that includes a Splitter.

### Service Activator

> A Service Activator is a generic endpoint for connecting a service instance to the messaging system. The input Message Channel must be configured, and if the service method to be invoked is capable of returning a value, an output Message Channel may also be provided. The Service Activator invokes an operation on some service object to process the request Message, extracting the request Message’s payload and converting if necessary (if the method does not expect a Message-typed parameter). Whenever the service object’s method returns a value, that return value will likewise be converted to a reply Message if necessary (if it’s not already a Message). That reply Message is sent to the output channel. If no output channel has been configured, then the reply will be sent to the channel specified in the Message’s "return address" if available.

### Channel Adapter

> A Channel Adapter is an endpoint that connects a Message Channel to some other system or transport. Channel Adapters may be either inbound or outbound. Typically, the Channel Adapter will do some mapping between the Message and whatever object or resource is received-from or sent-to the other system (File, HTTP Request, JMS Message, etc). Depending on the transport, the Channel Adapter may also populate or extract Message header values.

# Resources

- [Spring Framework](https://github.com/spring-projects/spring-framework) @ GitHub
- [Spring Integration](https://github.com/spring-projects/spring-integration) @ GitHub
- [Spring Integration Samples](https://github.com/spring-projects/spring-integration-samples)
- [Spring Integration Extensions](https://github.com/spring-projects/spring-integration-extensions)
- [Spring Integration STS Templates](https://github.com/spring-projects/spring-integration-templates/tree/master/si-sts-templates)
- [Spring Integration Java DSL](https://github.com/spring-projects/spring-integration-java-dsl)
- [Spring Integration Scala DSL](https://github.com/spring-projects/spring-integration-dsl-scala)
- [Groovy DSL For Spring Integration](https://github.com/spring-projects/spring-integration-dsl-groovy)
- [spring-integration-pattern-catalog](https://github.com/spring-projects/spring-integration-pattern-catalog)

## Tutorials

### Spring Framework

- [Spring Framework Tutorial](https://www.tutorialspoint.com/spring/) @ TutorialsPoint
- [Spring Tutorial for Java Beginners](http://www.simplecodestuffs.com/spring-tutorial-2/)
- [Spring 3 Tutorial for Java Beginners](http://javabeginnerstutorial.com/spring/)
- [Spring Tutorial](http://www.javatpoint.com/spring-tutorial)
- [spring tutorial for beginners](http://www.java2blog.com/2012/08/introduction-to-spring-framework.html)
- [Spring Tutorials for Beginners](http://www.java4s.com/spring/)
- [Spring by Example](http://www.springbyexample.org/)
- [Spring Tutorial](http://www.mkyong.com/tutorials/spring-tutorials/)
- [Spring WS](http://memorynotfound.com/category/spring-framework/spring-ws/)
- [Spring Data](http://memorynotfound.com/category/spring-framework/spring-data/)

### Spring Integration

- [Spring Integration Java DSL: Line by line tutorial](https://spring.io/blog/2014/11/25/spring-integration-java-dsl-line-by-line-tutorial)
- [Spring Integration Java DSL (pre Java 8): Line by line tutorial](https://spring.io/blog/2014/12/01/spring-integration-java-dsl-pre-java-8-line-by-line-tutorial)
- [Open source Java projects: Spring Integration](http://www.javaworld.com/article/2142107/spring-framework/open-source-java-projects-spring-integration.html)
- [Spring Integration Hello World tutorial](http://javaee.ch/2013/04/20/spring-integration-hello-world-tutorial/)
- [Spring Integration – Session 1 – Hello World](https://www.javacodegeeks.com/2012/07/spring-integration-session-1-hello.html)
- [Spring Integration: A lightweight integration Approach](https://www.javacodegeeks.com/2013/09/spring-integration-a-lightweight-integration-approach.html)
- [Spring Integration - Getting Started Tutorial](https://chandanpandey.com/2012/10/29/spring-integration-getting-started-tutorial/)
- [Introduction to Spring Integration Framework](http://www.jcombat.com/jms-tutorials/introduction-to-spring-integration-framework)
- [Basics of Spring Integration](http://techieme.in/basics-of-spring-integration/)
- [Spring Integration - Building a Sample Application](https://dzone.com/articles/spring-integration-building)
- [Spring Integration: A Hands-On Tutorial, Part 1](https://dzone.com/articles/spring-integration-hands)
- [Spring Integration: A Hands-On Tutorial, Part 2](https://dzone.com/articles/spring-integration-hands-0)
- [Spring Integration – developing application from the scratch (part 1 / 2)](https://vrtoonjava.wordpress.com/2013/03/03/spring-integration-developing-application-from-the-scratch-part-1-2/)
- [Spring Integration – developing application from the scratch (part 2 / 2)](https://vrtoonjava.wordpress.com/2013/03/03/spring-integration-developing-application-from-the-scratch-part-2-2/)
- [Spring Integration - Enterprise Integration Veg-O-Matic](https://www.intertech.com/Blog/spring-integration-enterprise-integration-veg-o-matic/)
- [Spring Integration Tutorial for EAI](https://www.javacodegeeks.com/2015/09/spring-integration-for-eai.html)
- [Simple Spring Integration](http://www.springbyexample.org/examples/simple-spring-integration.html)

## Articles

- [Getting Started With Spring Integration](https://www.infoq.com/articles/Spring-Integration-Joshua-Long)
- [What is Spring Integration?](http://blog.christianposta.com/spring-integration/what-is-spring-integration/)
- [Spring Integration Java DSL sample](https://dzone.com/articles/spring-integration-java-dsl)

## Books

## Maven Plugins

# Examples

## Requirements

Common requirements to follow all examples:

- JDK 7
- [Maven 3.3.9](http://maven.apache.org/download.cgi)
- [Spring Framework 4.3.4.RELEASE](https://projects.spring.io/spring-framework/), which is the latest that works with Java 7 and does not require Java 8;
- [ActiveMQ 5.14.1](http://activemq.apache.org/download.html)
- [Eclipse Neon.1a](https://www.eclipse.org/downloads/packages/) / [IntelliJ IDEA 2016.2.4](https://www.jetbrains.com/idea/download/)

## Projects

- [Spring Integration Invoices](SpringIntegrationInvoices/README.md)
