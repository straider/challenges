:: CXF :: REST :: Jetty ::
==========================

# Overview

Register the steps necessary, from scratch, to develop a simple REST service using CXF and running with Jetty.

## How to run a CXF REST service using Jetty?

# Steps

Copy [Standalone](../Standalone/README.md) project and change the buildfiles only.

## Buildfiles

### 1st version

Edit the project artifact, name, description and URL and replace **Standalone** with **Jetty**. Also replace the packaging type from JAR to WAR.

```xml
    ...
    
    <artifactId>rest-jetty</artifactId>
    <version>1.0.0</version>
    <name>Jetty CXF Greeting Service</name>
    <description>REST Greeting Service running on Jetty using CXF (JAX-RS implementation).</description>
    <url>https://github.com/straider/coding-dojo/tree/Java/WebServices/CXF/REST/Jetty</url>

    <packaging>war</packaging>

    ...
```

### Maven

### Gradle

## Components

### Base / Foundation

### Server

### Client
