:: Camel ::
===========

# Overview

## What is Apache Camel?

> [Apache Camel](https://en.wikipedia.org/wiki/Apache_Camel) is a rule-based routing and mediation engine that provides a Java object-based implementation of the [Enterprise Integration Patterns](https://en.wikipedia.org/wiki/Enterprise_Integration_Patterns) using an API or [DSL](http://camel.apache.org/dsl.html) to configure routing and mediation rules. The domain-specific language means that Apache Camel can support type-safe smart completion of routing rules in an integrated development environment using regular Java, Groovy or Scala code without large amounts of XML configuration files, though XML configuration using [Spring Framework](http://camel.apache.org/spring.html) or [OSGi Blueprint](http://camel.apache.org/using-osgi-blueprint-with-camel.html) is also supported.
>> Camel is often used with Apache ServiceMix, Apache ActiveMQ and Apache CXF in service-oriented architecture infrastructure projects.

## Why use Apache Camel?

> Apache Camel uses URIs to work directly with any kind of [Transport](http://camel.apache.org/transport.html) or messaging model such as HTTP, ActiveMQ, JMS, JBI, SCA, MINA or CXF, as well as pluggable [Components](http://camel.apache.org/components.html) and [Data Format](http://camel.apache.org/data-format.html) options. Apache Camel is a small library with minimal dependencies for easy embedding in any Java application. Apache Camel lets you work with the same API regardless which kind of Transport is used - so learn the API once and you can interact with all the Components provided out-of-box.

## Alternatives to Camel?

- [Spring Integration](http://projects.spring.io/spring-integration/) 
- [Mule ESB](https://www.mulesoft.com/platform/soa/mule-esb-open-source-esb)
- [Apache Synapse Enterprise Service Bus](http://synapse.apache.org/)

## What DSLs can be used?

> Camel uses a Java Domain Specific Language or DSL for creating Enterprise Integration Patterns or Routes in a variety of domain-specific languages:
- [Java](http://camel.apache.org/java-dsl.html);
- [Groovy](http://camel.apache.org/groovy-dsl.html);
- [Scala](http://camel.apache.org/scala-dsl.html);
- [Spring Framework XML](http://camel.apache.org/spring.html);
- [OSGi Blueprint XML](http://camel.apache.org/using-osgi-blueprint-with-camel.html);
- [Java Bean Annotations](http://camel.apache.org/bean-integration.html);
- [REST](http://camel.apache.org/rest-dsl.html);
- [Kotlin](https://github.com/koolio/kool/tree/master/kool-camel).

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
