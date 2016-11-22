:: Enterprise Integration :: Camel ::
=====================================

# Overview

## Questions

### What is Apache Camel?

> [Apache Camel](https://en.wikipedia.org/wiki/Apache_Camel) is a rule-based routing and mediation engine that provides a Java object-based implementation of the [Enterprise Integration Patterns](https://en.wikipedia.org/wiki/Enterprise_Integration_Patterns) using an API or [DSL](http://camel.apache.org/dsl.html) to configure routing and mediation rules. The domain-specific language means that Apache Camel can support type-safe smart completion of routing rules in an integrated development environment using regular Java, Groovy or Scala code without large amounts of XML configuration files, though XML configuration using [Spring Framework](http://camel.apache.org/spring.html) or [OSGi Blueprint](http://camel.apache.org/using-osgi-blueprint-with-camel.html) is also supported.
>> Camel is often used with Apache ServiceMix, Apache ActiveMQ and Apache CXF in service-oriented architecture infrastructure projects.

### Why use Apache Camel?

> Apache Camel uses URIs to work directly with any kind of [Transport](http://camel.apache.org/transport.html) or messaging model such as HTTP, ActiveMQ, JMS, JBI, SCA, MINA or CXF, as well as pluggable [Components](http://camel.apache.org/components.html) and [Data Format](http://camel.apache.org/data-format.html) options. Apache Camel is a small library with minimal dependencies for easy embedding in any Java application. Apache Camel lets you work with the same API regardless which kind of Transport is used - so learn the API once and you can interact with all the Components provided out-of-box.

### Alternatives to Camel?

- [Spring Integration](http://projects.spring.io/spring-integration/) 
- [Mule ESB](https://www.mulesoft.com/platform/soa/mule-esb-open-source-esb)
- [Apache Synapse Enterprise Service Bus](http://synapse.apache.org/)

### What DSLs can be used?

> Camel uses a Java Domain Specific Language or DSL for creating Enterprise Integration Patterns or Routes in a variety of domain-specific languages:
- [Java](http://camel.apache.org/java-dsl.html);
- [Groovy](http://camel.apache.org/groovy-dsl.html);
- [Scala](http://camel.apache.org/scala-dsl.html);
- [Spring Framework XML](http://camel.apache.org/spring.html);
- [OSGi Blueprint XML](http://camel.apache.org/using-osgi-blueprint-with-camel.html);
- [Java Bean Annotations](http://camel.apache.org/bean-integration.html);
- [REST](http://camel.apache.org/rest-dsl.html);
- [Kotlin](https://github.com/koolio/kool/tree/master/kool-camel).

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

# Camel's Architecture

> Camel uses [Routing Domain Specific Language](http://camel.apache.org/dsl.html) (DSL) or an XML configuration to configure routing and mediation rules which are added to a [CamelContext](http://camel.apache.org/camelcontext.html) to implement the various Enterprise Integration Patterns.

> At a high level Camel consists of a CamelContext which contains a collection of Component instances. The CamelContext represents a single Camel routing rulebase.

> The DSL makes heavy use of pluggable [Languages](http://camel.apache.org/languages.html) to create an [Expression](http://camel.apache.org/expression.html) or [Predicate](http://camel.apache.org/predicate.html) to make a truly powerful DSL which is extensible to the most suitable language depending on your needs.

## Components

> A component is essentially a factory of endpoint instances. Component is confusing terminology; EndpointFactory would have been more appropriate because a Component is a factory for creating Endpoint instances.

From [Apache Camel: Integration Nirvana](https://dzone.com/articles/apache-camel-integration)
> Components are the extension point in Camel to add connectivity to other systems. Camel has a small core set of components included by default. The rest of the components exist as separate modules.

The camel-core provides the following components *out of the box*:
- [bean](http://camel.apache.org/bean.html)
- [direct](http://camel.apache.org/direct.html)
- [file](http://camel.apache.org/file2.html)
- [log](http://camel.apache.org/log.html)
- [properties](http://camel.apache.org/properties.html)
- [seda](http://camel.apache.org/seda.html)
- [timer](http://camel.apache.org/timer.html)
- [validator](http://camel.apache.org/validation.html)
- [vm](http://camel.apache.org/vm.html)
- [xslt](http://camel.apache.org/xslt.html)
- [browse](http://camel.apache.org/browse.html)
- [dataset](http://camel.apache.org/dataset.html)
- [mock](http://camel.apache.org/mock.html)
- [test](http://camel.apache.org/test.html)
- [stub](http://camel.apache.org/stub.html)

## Endpoints

> An [Endpoint](http://camel.apache.org/endpoint.html) acts rather like a URI or URL in a web application or a Destination in a JMS system. One can communicate with an endpoint by either sending messages to it or consuming messages from it. One can then create a [Producer](http://camel.apache.org/maven/current/camel-core/apidocs/org/apache/camel/Producer.html) or [Consumer](http://camel.apache.org/maven/current/camel-core/apidocs/org/apache/camel/Consumer.html) on an Endpoint to exchange messages with it.

> Camel supports the [Message Endpoint](http://camel.apache.org/message-endpoint.html) pattern using the Endpoint interface. Endpoints are usually created by a Component and Endpoints are usually referred to in the DSL via their URIs.

> From an Endpoint you can use the following methods:
- createProducer() will create a Producer for sending message exchanges to the endpoint;
- createConsumer() implements the Event Driven Consumer pattern for consuming message exchanges from the endpoint via a Processor when creating a Consumer;
- createPollingConsumer() implements the Polling Consumer pattern for consuming message exchanges from the endpoint via a PollingConsumer.

## Message and Exchange

> The Message interface provides an abstraction for a single message, such as a request, reply or exception message.

> The Exchange interface provides an abstraction for an exchange of messages, that is, a request message and its corresponding reply or exception message. In Camel terminology, the request, reply and exception messages are called in, out and fault messages.

## Processors

> The [Processor](http://camel.apache.org/processor.html) interface is used to implement consumers of message exchanges or to implement a [Event Driven Consumer](http://camel.apache.org/event-driven-consumer.html) or [Message Translator](http://camel.apache.org/message-translator.html) pattern.

From [Apache Camel: Integration Nirvana](https://dzone.com/articles/apache-camel-integration)
> Processors are used to manipulate and mediate messages in between Endpoints. All of the EIPs are defined as Processors or sets of Processors.

## Routes

> A [route](http://camel.apache.org/routes.html) is the step-by-step movement of a Message from an input queue, through arbitrary types of decision making (such as filters and routers) to a destination queue (if any).

> Camel provides two ways for an application developer to specify routes:
- One way is to specify route information in an XML file;
- The other way is through what Camel calls a DSL.

From [Apache Camel: Integration Nirvana](https://dzone.com/articles/apache-camel-integration)
> Routes wire Processors and Endpoints together. In Camel, DSL means a fluent API that contains methods named like terms from the EIP book.

# Resources

## Tutorials

- [Apache Camel - Tutorials](http://camel.apache.org/tutorials.html)
    - [tutorial-osgi-camel-part1](http://camel.apache.org/tutorial-osgi-camel-part1.html)
    - [tutorial-osgi-camel-part2](http://camel.apache.org/tutorial-osgi-camel-part2.html)
        - [tutorial-osgi-camel-part2a](http://camel.apache.org/tutorial-osgi-camel-part2a.html)
        - [tutorial-osgi-camel-part2b](http://camel.apache.org/tutorial-osgi-camel-part2b.html)
        - [tutorial-osgi-camel-part2c](http://camel.apache.org/tutorial-osgi-camel-part2c.html)
    - [Tutorial-Example-ReportIncident](http://camel.apache.org/tutorial-example-reportincident.html)
- [Apache Camel Hello World example](https://examples.javacodegeeks.com/enterprise-java/apache-camel/apache-camel-hello-world-example/)
- [Getting Started with Apache Camel using Groovy](http://saltnlight5.blogspot.co.uk/2012/08/getting-started-with-apache-camel-using.html)
- [Getting Started with Apache Camel using Java](http://saltnlight5.blogspot.co.uk/2013/08/getting-started-with-apache-camel-using.html)
- [Apache Camel Using Java DSL](http://www.javainuse.com/camel/camel_java)
- [Intro to Camel By Example](https://davidvaleri.wordpress.com/2013/03/28/intro-to-camel-by-example/)
    - [Intro to Camel By Example](https://github.com/DavidValeri/intro-to-camel-by-example)
- [Apache Camel Tutorial—EIP, Routes, Components, Testing, and More](https://dzone.com/articles/apache-camel-tutorial-eip)
- [Camel Introduction](http://www.mastertheintegration.com/camel/camel-introduction.html)
- [Transforming Data with Camel](http://www.mastertheintegration.com/camel/transforming-data-with-camel.html)
- [Camel and Web Services](http://www.mastertheintegration.com/camel/camel-and-web-services.html)
- [Camel and JMS](http://www.mastertheintegration.com/camel/camel-and-jms.html)
- [Using the Timer component with Camel](http://www.mastertheintegration.com/camel/timer-component/using-the-timer-component-with-camel.html)
- [Apache Camel: Integration Nirvana](https://dzone.com/articles/apache-camel-integration)
- [REST endpoint for integration using Apache Camel](http://blog.christianposta.com/camel/rest-endpoint-for-integration-using-apache-camel/)
- [Apache Camel: open source integration framework](http://www.jeroenreijn.com/2009/03/apache-camel-open-source-integration.html)
- [Apache Camel – developing application from the scratch (part 1 / 2)](https://vrtoonjava.wordpress.com/2013/10/20/apache-camel-developing-application-from-the-scratch-part-1-2/)
- [Apache Camel – developing application from the scratch (part 2 / 2)](https://vrtoonjava.wordpress.com/2013/10/20/apache-camel-developing-application-from-the-scratch-part-2-2/)

## Articles

- [Entreprise Integration Pattern with Apache Camel 2.0](http://onjavahell.blogspot.co.uk/2009/05/taking-apache-camel-for-ride.html)
- [Camellos - Discovering Apache Camel I](http://hillert.blogspot.co.uk/2009/09/camellos-discovering-apache-camel-i.html)
- [Camellos - Discovering Apache Camel II](http://hillert.blogspot.co.uk/2009/09/camellos-discovering-apache-camel-ii.html)
- [Camellos III - Zipping Files with Apache Camel Example](http://hillert.blogspot.co.uk/2009/10/camellos-iii-zipping-files-with-apache.html)
- [Open Source Integration with Apache Camel and How Fuse IDE Can Help](https://dzone.com/articles/open-source-integration-apache)
- [Camel Essential Components](https://dzone.com/refcardz/essential-camel-components)
- [When to Use Apache Camel?](https://dzone.com/articles/when-use-apache-camel)
- [Which Integration Framework Should You Use – Spring Integration, Mule ESB or Apache Camel?](https://dzone.com/articles/which-integration-framework)
- [Light-weight, open-source integration: Apache Camel or Spring Integration?](http://blog.christianposta.com/comparison/light-weight-open-source-integration-apache-camel-or-spring-integration/)
- [Java Tip: Write an SOA integration layer with Apache Camel](http://www.javaworld.com/article/2078883/open-source-tools/java-tip-write-an-soa-integration-layer-with-apache-camel.html)

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

# Examples

## Requirements

Common requirements to follow all examples:

- JDK 7
- [Maven 3.3.9](http://maven.apache.org/download.cgi)
- [Camel 2.17.3](http://camel.apache.org/download), which is the latest that works with Java 7 and does not require Java 8;
- [ActiveMQ 5.14.1](http://activemq.apache.org/download.html)
- [Eclipse Neon.1a](https://www.eclipse.org/downloads/packages/) / [IntelliJ IDEA 2016.2.4](https://www.jetbrains.com/idea/download/)

## Projects

- [Camel Archetypes for Maven](Archetypes/README.md)
    - camel-archetype-java: Java Router;
    - camel-archetype-groovy: Groovy Router;
    - camel-archetype-scala: Scala Router;
    - camel-archetype-activemq: Camel with ActiveMQ;
    - camel-archetype-spring: Spring Framework Based Router;
    - camel-archetype-blueprint: Blueprint (OSGi) Based Router;
- [Camel with Maven](MavenCamelTest/README.md)
- [Camel Getting Started](CamelGettingStarted/README.md)
- [Camel Hello World](CamelHelloWorld/README.md)
- [Camel Integration Nirvana](CamelIntegrationNirvana/README.md)
- [Camel REST](CamelREST/README.md)
- [Cafe Example](http://camel.apache.org/cafe-example.html)
- [Loan Broker Example](http://camel.apache.org/loan-broker-example.html)
- [Tutorial-Example-ReportIncident](http://camel.apache.org/tutorial-example-reportincident.html)
