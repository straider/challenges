:: Camel :: REST ::
===================

# Overview

> There are some great tutorials to follow along that help to understand JAX-RS:
>> Java API for RESTful Web Services (JAX-RS), is a set if APIs to developer REST service. JAX-RS is part of the Java EE6, and make developers to develop REST web application easily. The [JAX-RS Tutorial](http://www.mkyong.com/tutorials/jax-rs-tutorials/) uses both Jersey and RESTEasy, popular JAX-RS implementation.

## Steps

- Create pom.xml;
- Add camel-core dependency to the project;
- Add Camel components dependencies:
    - camel-cxfrs
    - ~~camel-file~~
    - cxf-rt-transports-http-jetty (runtime)
    - slf4j-simple (runtime)
- Build the REST service;
- Build the route, using Java DSL (providing a route ID), without using beans;
- Add Camel Maven Plugin, to execute Spring Camel Context;
- Build the route, using Java DSL (providing a route ID), with beans;
- Add the processor;
- Build the Spring application context with Camel context.

## Notes

- There are no Unit Tests;
- There are no Integration Tests;
- There is no logging;
- Replaced the simple pom.xml with one that depends on parent-pom artifact, which enables Unit Tests and Integration Tests coded in Groovy;
- Example is not complete:
    - PUT method does nothing;
    - pollEnrich is throwing NPE.

## Well Known Errors

### Cannot find HttpDestinationFactory

The following error occurs because cxf-rt-transports-http-jetty dependency is missing in the pom.xml file:

```
SEVERE: Cannot find any registered HttpDestinationFactory from the Bus.
```

### Unable to locate Spring NamespaceHandler

The following error occurs when Camel Maven plugin is unable to find any Spring Application Context, usually defined in META-INF/spring/*.xml:

```
MojoExecutionException:
    InvocationTargetException:
        Configuration problem: Unable to locate Spring NamespaceHandler
```

### org/osgi/framework/InvalidSyntaxException

The following error occurs when Camel Maven plugin is unable to find any OSGi Blueprint Context, usually defined in OSGI-INF/blueprint/*.xml:

```
MojoExecutionException:
    InvocationTargetException:
        org/osgi/framework/InvalidSyntaxException:
```

### org/apache/camel/test/junit4/TestSupport

The following error occurs because camel:run with OSGi Blueprint runs CamelBlueprintTest, which requires camel-test-blueprint dependency in pom.xml file:

```
MojoExecutionException:
    InvocationTargetException:
        org/apache/camel/test/junit4/TestSupport
```

### org/junit/Assert

The following error occurs because camel:run with OSGi Blueprint runs CamelBlueprintTest, which requires JUnit in the same scope (not just test but also runtime):

```
MojoExecutionException:
    InvocationTargetException:
        org/junit/Assert
```

If so then add junit dependency with runtime scope, same as camel-test-blueprint.

### Gave up waiting for service

The following error occurs because camel:run with OSGi Blueprint runs CamelBlueprintTest, which requires Maven Bundle plugin to be configured:

```
...
MojoExecutionException:
    InvocationTargetException:
        Gave up waiting for service (objectClass=org.apache.camel.CamelContext)
```

### objectweb.asm

The following error occurs because asm dependency, with scope runtime, is missing in the pom.xml file:

```
Unable to start bundle: org.apache.cxf.cxf-rt-transports-http
org.osgi.framework.BundleException: Unable to start bundle
...
Service factory exception: org/objectweb/asm/commons/AdviceAdapter
...
```

### osgi

### org.apache.cxf.cxf-rt-transports-http