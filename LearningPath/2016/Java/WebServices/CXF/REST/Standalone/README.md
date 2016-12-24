:: CXF :: REST :: Standalone ::
===============================

# Overview

- How to run a CXF REST service in standalone mode?
- Register the steps necessary, from scratch, to develop a REST service using CXF.

# Steps

## Buildfiles

### Maven

#### 1st version

A normal and usual pom.xml.

```xml
<?xml version = "1.0" encoding = "UTF-8"?>
<project xmlns              = "http://maven.apache.org/POM/4.0.0"
         xmlns:xsi          = "http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation = "http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd"
>

    <modelVersion>4.0.0</modelVersion>

    <groupId>com.github.straider.java.ws.cxf</groupId>
    <artifactId>rest-standalone</artifactId>
    <version>1.0.0</version>
    <name>Apache CXF Greeting Service</name>
    <description>REST Greeting Service using CXF (JAX-RS implementation).</description>
    <url>https://github.com/straider/coding-dojo/tree/Java/WebServices/CXF/REST/Standalone</url>

</project>
```

#### 2nd version

Add compile properties, that fix the warning message:

```
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ rest-standalone ---
[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
```

```xml
...

    <properties>
        <java.version>1.7</java.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>
```

### Gradle

## Components

### Base / Foundation

Simple class with method _speak()_:

```java
package com.github.straider.java.ws.cxf;

public class Greeter {

    private static final String DEFAULT_GREETING = "Hello";
    private static final String DEFAULT_NAME     = "World";
    private static final String MESSAGE_FORMAT   = "%s, %s!";

    private String greeting;

    public Greeter() {
        greeting = DEFAULT_GREETING;
    }

    public String speak( final String name ) {
        final String nameOrWorld = ( name == null || name.length() == 0 ) ? DEFAULT_NAME : name ;

        return String.format( MESSAGE_FORMAT, greeting, nameOrWorld );
    }

    public String speak() {
        return speak( DEFAULT_NAME );
    }

    public void setGreeting( final String greeting ) {
        this.greeting = ( greeting == null || greeting.length() == 0 ) ? DEFAULT_GREETING : greeting;
    }

}
```

### Server

### Client
