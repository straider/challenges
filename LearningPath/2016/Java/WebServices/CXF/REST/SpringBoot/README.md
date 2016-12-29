:: CXF :: REST :: Spring Boot ::
================================

# Overview

Register the steps necessary, from scratch, to develop a simple REST service using CXF and running with Spring Boot.

## How to run a CXF REST service using Spring Boot?

# Steps

## Buildfiles

### Maven

#### 1st version

Edit the project artifact, name, description and URL and replace **Standalone** with **SpringBoot**.

```xml
    ...
    
    <artifactId>rest-springboot</artifactId>
    <version>1.0.0</version>
    <name>Spring Boot CXF Greeting Service</name>
    <description>REST Greeting Service running on Spring Boot using CXF (JAX-RS implementation).</description>
    <url>https://github.com/straider/coding-dojo/tree/Java/WebServices/CXF/REST/SpringBoot</url>

    <packaging>war</packaging>

    ...
```

#### 2nd version

Edit the profiles, changing Standalone profile to not be enabled by default and adding Spring Boot profile, enabled by default, and using the [Spring Boot Maven Plugin](http://docs.spring.io/spring-boot/docs/1.4.3.RELEASE/maven-plugin/).

```xml
<?xml version = "1.0" encoding = "UTF-8"?>
<project xmlns              = "http://maven.apache.org/POM/4.0.0"
         xmlns:xsi          = "http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation = "http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd"
>

    ...
    <properties>
        ...

        <spring-boot.version>1.4.3.RELEASE</spring-boot.version>

        ...
    </properties>

    ...
    
    <profiles>

        <profile>
            <id>Standalone</id>
            <activation>
                <activeByDefault>false</activeByDefault>
            </activation>

            ...
        </profile>

        <profile>
            <id>Spring Boot</id>
            <activation>
                <activeByDefault>true</activeByDefault>
            </activation>

            <properties>
                <service.port>10000</service.port>
                <service.path>/ws/rest</service.path>
            </properties>

            <build>

                <pluginManagement>
                    <plugins>
                        <plugin>
                            <groupId>org.springframework.boot</groupId>
                            <artifactId>spring-boot-maven-plugin</artifactId>
                            <version>${spring-boot.version}</version>
                        </plugin>
                    </plugins>
                </pluginManagement>

                <plugins>
                    <plugin>
                        <groupId>org.springframework.boot</groupId>
                        <artifactId>spring-boot-maven-plugin</artifactId>
                        <configuration>
                            <mainClass>${main.class}</mainClass>
                        </configuration>
                    </plugin>
                </plugins>

            </build>
        </profile>

    </profiles>

</project>
```

### Gradle

## Components

### Base / Foundation

### Server

### Client
