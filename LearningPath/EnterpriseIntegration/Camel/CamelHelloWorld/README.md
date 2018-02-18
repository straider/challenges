:: Camel :: Hello World ::
==========================

# Overview

## Steps

- Create pom.xml;
- Add camel-core dependency to the project;
- Add Camel components dependencies:
    - camel-stream
    - camel-jms
    - activemq-camel
- Build the route, using Java DSL (providing a route ID);
- Add Spring dependencies:
    - spring-context
    - spring-beans
    - camel-spring
- Build the route, using Spring DSL;
- Build the route, using Java DSL and Timer component.

## Notes

- There are no Unit Tests;
- There are no Integration Tests;
- There is no logging;
- Replaced the simple pom.xml with one that depends on parent-pom artifact, which enables Unit Tests and Integration Tests coded in Groovy and also gets rid of logging warnings.

## Known Errors

### Unsupported major.minor version 52.0

This is because Java 8 is required when using latest Camel release, 2.18.0.

### Failed to load class "org.slf4j.impl.StaticLoggerBinder"

The following error occurs because there's no logger configured by Camel:
```
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
```

Please read [How to configure SLF4J with different logger implementations](http://saltnlight5.blogspot.co.uk/2013/08/how-to-configure-slf4j-with-different.html).

### Failed to load class "org.slf4j.impl.StaticMDCBinder".

The following error occurs because there's no logger configured by ActiveMQ:
```
SLF4J: Failed to load class "org.slf4j.impl.StaticMDCBinder".
SLF4J: Defaulting to no-operation MDCAdapter implementation.
SLF4J: See http://www.slf4j.org/codes.html#no_static_mdc_binder for further details.
```

### No appenders could be found for logger (org.apache.camel.impl.SharedProducerServicePool).

The following error occurs because there are no appenders configured for Log4J:
```
log4j:WARN No appenders could be found for logger (org.apache.camel.impl.SharedProducerServicePool).
log4j:WARN Please initialize the log4j system properly.
log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.
```

### java.lang.ClassNotFoundException: org.springframework.beans.factory.config.EmbeddedValueResolver

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

### Nested exception is java.lang.NoClassDefFoundError: org/slf4j/LoggerFactory

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

### Context stopped before handling JMS message

The following error occurs because the context stopped before ActiveMQ could handle the message:

```
Rejecting received message because of the listener container having been stopped in the meantime: ActiveMQTextMessage
```

A workaround is to add a ```Thread.sleep( 2500 )``` statement after the context starts, to give enough time for the route to process the message.
