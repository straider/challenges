:: CXF :: REST :: Tomcat ::
===========================

# Overview

Register the steps necessary, from scratch, to develop a simple REST service using CXF and running with Tomcat.

## How to run a CXF REST service using Tomcat?

# Steps

Copy [Standalone](../Standalone/README.md) project and change the buildfiles only.

## Buildfiles

### Maven

#### 1st version

Edit the project artifact, name, description and URL and replace **Standalone** with **Tomcat**. Also replace the packaging type from JAR to WAR.

```xml
    ...
    
    <artifactId>rest-tomcat</artifactId>
    <version>1.0.0</version>
    <name>Tomcat CXF Greeting Service</name>
    <description>REST Greeting Service running on Tomcat using CXF (JAX-RS implementation).</description>
    <url>https://github.com/straider/coding-dojo/tree/Java/WebServices/CXF/REST/Tomcat</url>

    <packaging>war</packaging>

    ...
```

### Gradle

## Components

### Base / Foundation

### Server

### Client
