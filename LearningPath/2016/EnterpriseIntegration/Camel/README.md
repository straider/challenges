:: EnterpriseIntegration :: Camel ::
====================================

# Overview

**What is Apache Camel?**
> [Apache Camel](https://en.wikipedia.org/wiki/Apache_Camel) is a rule-based routing and mediation engine that provides a Java object-based implementation of the [Enterprise Integration Patterns](https://en.wikipedia.org/wiki/Enterprise_Integration_Patterns) using an API or [DSL](http://camel.apache.org/dsl.html) to configure routing and mediation rules. The domain-specific language means that Apache Camel can support type-safe smart completion of routing rules in an integrated development environment using regular Java, Groovy or Scala code without large amounts of XML configuration files, though XML configuration using [Spring Framework](http://camel.apache.org/spring.html) or [OSGi Blueprint](http://camel.apache.org/using-osgi-blueprint-with-camel.html) is also supported.
>> Camel is often used with Apache ServiceMix, Apache ActiveMQ and Apache CXF in service-oriented architecture infrastructure projects.

**Why use Apache Camel?**
> Apache Camel uses URIs to work directly with any kind of [Transport](http://camel.apache.org/transport.html) or messaging model such as HTTP, ActiveMQ, JMS, JBI, SCA, MINA or CXF, as well as pluggable [Components](http://camel.apache.org/components.html) and [Data Format](http://camel.apache.org/data-format.html) options. Apache Camel is a small library with minimal dependencies for easy embedding in any Java application. Apache Camel lets you work with the same API regardless which kind of Transport is used - so learn the API once and you can interact with all the Components provided out-of-box.

**What DSLs can be used?**
> Camel uses a Java Domain Specific Language or DSL for creating Enterprise Integration Patterns or Routes in a variety of domain-specific languages:
- [Java](http://camel.apache.org/java-dsl.html);
- [Groovy](http://camel.apache.org/groovy-dsl.html);
- [Scala](http://camel.apache.org/scala-dsl.html);
- [Spring Framework XML](http://camel.apache.org/spring.html);
- [OSGi Blueprint XML](http://camel.apache.org/using-osgi-blueprint-with-camel.html);
- [Java Bean Annotations](http://camel.apache.org/bean-integration.html);
- [REST](http://camel.apache.org/rest-dsl.html);
- [Kotlin](https://github.com/koolio/kool/tree/master/kool-camel).

**Alternatives to Camel?**
- [Spring Integration](http://projects.spring.io/spring-integration/) 
- [Mule ESB](https://www.mulesoft.com/platform/soa/mule-esb-open-source-esb)
- [Apache Synapse Enterprise Service Bus](http://synapse.apache.org/)

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

# Resources

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
- [Apache Camel: Integration Nirvana](https://dzone.com/articles/apache-camel-integration)

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

# Challenges

## Camel Archetypes for Maven

The following [Maven archetypes](Archetypes/README.md) exist to start Camel projects:

- camel-archetype-java: Java Router
- camel-archetype-groovy: Groovy Router
- camel-archetype-scala: Scala Router
- camel-archetype-activemq: Camel with ActiveMQ
- camel-archetype-blueprint: Blueprint (OSGi) Based Router
- camel-archetype-spring: Spring Framework Based Router

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

Common requirements to follow all examples:

- JDK 7
- [Maven 3.3.9](http://maven.apache.org/download.cgi)
- [Camel 2.17.3](http://camel.apache.org/download), which is the latest that works with Java 7 and does not require Java 8;
- [ActiveMQ 5.14.1](http://activemq.apache.org/download.html)
- [Eclipse Neon.1a](https://www.eclipse.org/downloads/packages/) / [IntelliJ IDEA 2016.2.4](https://www.jetbrains.com/idea/download/)

### [Apache Camel Hello World example](https://examples.javacodegeeks.com/enterprise-java/apache-camel/apache-camel-hello-world-example/)

#### Steps

- Create pom.xml;
- Add camel-core dependency to the project;
- Add Camel components dependencies:
    - camel-stream
    - camel-jms
    - activemq-camel
- Build the route, using Java DSL (providing a route ID);
- Add Spring dependencies:
    - spring-context
    - camel-spring
- Build the route, using Spring DSL;
- Build the route, using Java DSL and Timer component.

#### Notes

- There are no Unit Tests;
- There are no Integration Tests;
- There is no logging;
- Replaced the simple pom.xml with one that depends on parent-pom artifact, which enables Unit Tests and Integration Tests coded in Groovy and also gets rid of logging warnings.

#### Known Errors

##### Unsupported major.minor version 52.0

This is because Java 8 is required when using latest Camel release, 2.18.0.

##### Failed to load class "org.slf4j.impl.StaticLoggerBinder"

The following error occurs because there's no logger configured by Camel:
```
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
```

##### Failed to load class "org.slf4j.impl.StaticMDCBinder".

The following error occurs because there's no logger configured by ActiveMQ:
```
SLF4J: Failed to load class "org.slf4j.impl.StaticMDCBinder".
SLF4J: Defaulting to no-operation MDCAdapter implementation.
SLF4J: See http://www.slf4j.org/codes.html#no_static_mdc_binder for further details.
```

##### No appenders could be found for logger (org.apache.camel.impl.SharedProducerServicePool).

The following error occurs because there are no appenders configured for Log4J:
```
log4j:WARN No appenders could be found for logger (org.apache.camel.impl.SharedProducerServicePool).
log4j:WARN Please initialize the log4j system properly.
log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.
```

##### java.lang.ClassNotFoundException: org.springframework.beans.factory.config.EmbeddedValueResolver

The following error occurs because the spring-beans dependency is missing in the pom.xml file:
```
Exception in thread "main" java.lang.NoClassDefFoundError: org/springframework/beans/factory/config/EmbeddedValueResolver
	at org.springframework.context.support.ApplicationContextAwareProcessor.<init>(ApplicationContextAwareProcessor.java:72)
	at org.springframework.context.support.AbstractApplicationContext.prepareBeanFactory(AbstractApplicationContext.java:633)
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:517)
	at org.springframework.context.support.ClassPathXmlApplicationContext.<init>(ClassPathXmlApplicationContext.java:139)
	at org.springframework.context.support.ClassPathXmlApplicationContext.<init>(ClassPathXmlApplicationContext.java:83)
	at com.github.straider.camel.MainSpring.main(MainSpring.java:16)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at com.intellij.rt.execution.application.AppMain.main(AppMain.java:147)
Caused by: java.lang.ClassNotFoundException: org.springframework.beans.factory.config.EmbeddedValueResolver
...
```

##### Nested exception is java.lang.NoClassDefFoundError: org/slf4j/LoggerFactory

The following error occurs because the spring-beans dependency also requires slf4j-api ans this is missing in the pom.xml file:
```
Exception in thread "main" org.springframework.beans.factory.BeanDefinitionStoreException: Unexpected exception parsing XML document from class path resource [springRoute.xml]; nested exception is org.springframework.beans.FatalBeanException: Invalid NamespaceHandler class [org.apache.camel.spring.handler.CamelNamespaceHandler] for namespace [http://camel.apache.org/schema/spring]: problem with handler class file or dependent class; nested exception is java.lang.NoClassDefFoundError: org/slf4j/LoggerFactory
	at org.springframework.beans.factory.xml.XmlBeanDefinitionReader.doLoadBeanDefinitions(XmlBeanDefinitionReader.java:414)
	at org.springframework.beans.factory.xml.XmlBeanDefinitionReader.loadBeanDefinitions(XmlBeanDefinitionReader.java:336)
	at org.springframework.beans.factory.xml.XmlBeanDefinitionReader.loadBeanDefinitions(XmlBeanDefinitionReader.java:304)
	at org.springframework.beans.factory.support.AbstractBeanDefinitionReader.loadBeanDefinitions(AbstractBeanDefinitionReader.java:181)
	at org.springframework.beans.factory.support.AbstractBeanDefinitionReader.loadBeanDefinitions(AbstractBeanDefinitionReader.java:217)
	at org.springframework.beans.factory.support.AbstractBeanDefinitionReader.loadBeanDefinitions(AbstractBeanDefinitionReader.java:188)
	at org.springframework.beans.factory.support.AbstractBeanDefinitionReader.loadBeanDefinitions(AbstractBeanDefinitionReader.java:252)
	at org.springframework.context.support.AbstractXmlApplicationContext.loadBeanDefinitions(AbstractXmlApplicationContext.java:127)
	at org.springframework.context.support.AbstractXmlApplicationContext.loadBeanDefinitions(AbstractXmlApplicationContext.java:93)
	at org.springframework.context.support.AbstractRefreshableApplicationContext.refreshBeanFactory(AbstractRefreshableApplicationContext.java:129)
	at org.springframework.context.support.AbstractApplicationContext.obtainFreshBeanFactory(AbstractApplicationContext.java:613)
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:514)
	at org.springframework.context.support.ClassPathXmlApplicationContext.<init>(ClassPathXmlApplicationContext.java:139)
	at org.springframework.context.support.ClassPathXmlApplicationContext.<init>(ClassPathXmlApplicationContext.java:83)
	at com.github.straider.camel.MainSpring.main(MainSpring.java:16)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at com.intellij.rt.execution.application.AppMain.main(AppMain.java:147)
Caused by: org.springframework.beans.FatalBeanException: Invalid NamespaceHandler class [org.apache.camel.spring.handler.CamelNamespaceHandler] for namespace [http://camel.apache.org/schema/spring]: problem with handler class file or dependent class; nested exception is java.lang.NoClassDefFoundError: org/slf4j/LoggerFactory
...
```

### [Apache Camel: Integration Nirvana](https://dzone.com/articles/apache-camel-integration)

### [Cafe Example](http://camel.apache.org/cafe-example.html)

### [Loan Broker Example](http://camel.apache.org/loan-broker-example.html)

### [Tutorial-Example-ReportIncident](http://camel.apache.org/tutorial-example-reportincident.html)
