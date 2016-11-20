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
- Build the REST service;
- Build the route, using Java DSL (providing a route ID), without using beans;
- Add Spring dependencies:
    - spring-context
    - spring-beans
    - camel-spring
- Build the route, using Java DSL (providing a route ID), with beans;
- Add the processor;
- Build the Spring application context with Camel context.

## Notes

- There are no Unit Tests;
- There are no Integration Tests;
- There is no logging;
- Replaced the simple pom.xml with one that depends on parent-pom artifact, which enables Unit Tests and Integration Tests coded in Groovy.

## Well Known Errors
