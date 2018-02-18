:: Camel :: Integration Nirvana ::
==================================

# Overview

## Steps

- Create pom.xml;
- Add camel-core dependency to the project;
- Add Camel components dependencies:
    - activemq-core
    - activemq-camel
    - ~~camel-jms~~
    - camel-jaxb
    - camel-csv
    - camel-http
    - camel-jetty
- Add Spring dependencies:
    - spring-context
    - ~~xbean-spring~~
    - camel-spring
- Build the context, using Spring Beans;
- Build the route, using Java DSL (providing a route ID):
    - From inbound CSV file;
    - From inbound XML by HTTP;
    - From internal JMS queue;
    - To outbound JMS queue.
- Add the helper;
- Add the domain JAXB POJO;
- Add the CSV Normalizer.

## Notes

- There are no Unit Tests;
- There are no Integration Tests;
- There is no logging;
- Replaced the simple pom.xml with one that depends on parent-pom artifact, which enables Unit Tests and Integration Tests coded in Groovy and also gets rid of logging warnings;
- Add inbound JSON by HTTP? Requires Jackson dependencies;
- Should return HTTP Response Codes.

## Known Errors

### Spring NamespaceHandler for XML schema namespace activemq

The following error occurs because the activemq-core dependency is missing in the pom.xml file:

```
Exception in thread "main" org.springframework.beans.factory.parsing.BeanDefinitionParsingException: Configuration problem:
Unable to locate Spring NamespaceHandler for XML schema namespace [http://activemq.apache.org/schema/core]
```

### Data format 'csv' could not be created.

The following error occurs because the camel-csv dependency is missing in the pom.xml file:

```
java.lang.IllegalArgumentException: Data format 'csv' could not be created.
Ensure that the data format is valid and the associated Camel component is present on the classpath
```

### Does not contain ObjectFactory.class or jaxb.index

The following error occurs because the jaxb.index file is missing in folder with same name as the package:

```
javax.xml.bind.JAXBException: Provider com.sun.xml.bind.v2.ContextFactory could not be instantiated: javax.xml.bind.JAXBException: doesnt contain ObjectFactory.class or jaxb.index
```

### Localhost interface

The following warning message occurs because the host for the Jetty HTTP endpoint is set to localhost instead of 0.0.0.0:

```
You use localhost interface! It means that no external connections will be available. Don't you want to use 0.0.0.0 instead (all network interfaces)?
```

### Failed to resolve endpoint

The following error occurs because camel-jetty dependency is missing in the pom.xml file:

```
Failed to resolve endpoint: jetty://http://0.0.0.0:10000/placeorder due to: No component found with scheme: jetty
```

The following error occurs because camel-http dependency is missing in the pom.xml file:

```
Failed to resolve endpoint: http://0.0.0.0:10000/placeorder due to: No component found with scheme: http
```

### Cannot consume from http endpoint

The following error occurs because the HTTP inbound is not associated with Jetty Camel component:

```
org.apache.camel.RuntimeCamelException: java.lang.UnsupportedOperationException: Cannot consume from http endpoint
```
