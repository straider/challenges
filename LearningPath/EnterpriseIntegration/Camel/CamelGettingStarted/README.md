:: Camel :: Getting Started ::
==============================

# Overview

## Steps

- Create pom.xml;
- Add camel-core dependency to the project;
- Add Camel components dependencies:
    - slf4j-simple
- Build the route, using Java DSL (providing a route ID);
- Add the processor;
- Build the context;
- Add shutdown hook and thread block after context starts;
- Extend Camel Main;
- Add bean processors.

## Notes

- There are no Unit Tests;
- There are no Integration Tests;
- There is logging, using SLF4J Simple;
- Replaced the simple pom.xml with one that depends on parent-pom artifact, which enables Unit Tests and Integration Tests coded in Groovy;
- Replaced inner classes with Processors.

## Well Known Errors
