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

#### 3rd version

Change the web.xml to use CXFServlet and configure it in beans.xml:

##### beans.xml

```xml
<?xml version = "1.0" encoding = "UTF-8"?>
<beans xmlns              = "http://www.springframework.org/schema/beans"
       xmlns:xsi          = "http://www.w3.org/2001/XMLSchema-instance"
       xmlns:cxf          = "http://cxf.apache.org/core"
       xmlns:jaxrs        = "http://cxf.apache.org/jaxrs"
       xsi:schemaLocation = "
			http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
			http://cxf.apache.org/core                  http://cxf.apache.org/schemas/core.xsd
			http://cxf.apache.org/jaxrs                 http://cxf.apache.org/schemas/jaxrs.xsd
       "
>

    <import resource = "classpath:META-INF/cxf/cxf.xml"         />
    <import resource = "classpath:META-INF/cxf/cxf-servlet.xml" />

    <cxf:bus>
        <cxf:features>
            <cxf:logging />
        </cxf:features>
    </cxf:bus>

    <bean id = "greetingService" class = "${service.class}" />

    <jaxrs:server id = "GreetingService" address = "${service.path}">
        <jaxrs:serviceBeans>
            <ref bean = "greetingService" />
        </jaxrs:serviceBeans>
    </jaxrs:server>

</beans>
```

##### web.xml

Add context-param and listener sections and replace servlet-class:

```xml
    ...
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>/WEB-INF/beans.xml</param-value>
    </context-param>

    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>

    <servlet>
        <servlet-name>CXFServlet</servlet-name>
        <servlet-class>org.apache.cxf.transport.servlet.CXFServlet</servlet-class>
        <load-on-startup>1</load-on-startup>
    </servlet>

    ...
```

#### 4th version

To add **spring-boot-starter** and **spring-boot-starter-test** dependencies it is necessary to add them to the pom.xml file and there should be no **slf4j-simple** dependency, because it will clash with Spring Boot's logging dependencies at runtime.

```xml
        ...

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
            <version>${spring-boot.version}</version>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <version>${spring-boot.version}</version>
            <scope>test</scope>
        </dependency>

        ...
```

### Gradle

## Components

### Base / Foundation

### Server

The following error occurs when there's no Spring Boot annotated main class.

```
Failed to execute goal org.springframework.boot:spring-boot-maven-plugin:1.4.3.RELEASE:start (default-cli) on project rest-springboot: Spring application did not start before the configured timeout 
```

To fix it, after adding the missing dependencies to pom.xml (4th version), then change the **Server** class to:

```java
package com.github.straider.java.ws.cxf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Server {

    private static final String  DEFAULT_HOST = "localhost";
    private static final Integer DEFAULT_PORT = 10000;

    public static void main( final String[] arguments ) {
        SpringApplication.run( Server.class, arguments );
    }

}
```

### Client
