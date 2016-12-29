:: CXF :: REST :: Spring Boot ::
================================

# Overview

Register the steps necessary, from scratch, to develop a simple REST service using CXF and running with Spring Boot.

## How to run a CXF REST service using Spring Boot?

There are several Spring Boot Starters to bootstrap a CXF Standalone Spring Boot application:
- spring-boot-starter-web, which includes Tomcat 7 by default;
- spring-boot-starter-jersey
- spring-boot-starter-tomcat
- spring-boot-starter-jetty
- spring-boot-starter-undertow

Because of this it is best to have several profiles:
- Spring Boot with Tomcat
- Spring Boot with Jetty
- Spring Boot with Undertow

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

To add **spring-boot-starter-web** and **spring-boot-starter-test** dependencies it is necessary to add them to the pom.xml file and there should be no **slf4j-simple** dependency, because it will clash with Spring Boot's logging dependencies at runtime.

```xml
        ...

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
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

**Note**: using just **spring-boot-starter** is not enough, because Spring Boot will start and stop whhat it thinks is a simple command line application instead of a Servlet Container, which is required to run CXF.

**Note**: there's no need for a main.class property neither it needs to be explicitly configure in the Spring Boot Maven Plugin after the main class gets to be annotated with @SpringBootApplication.

### Gradle

## Components

### Base / Foundation

### Service

For Spring Boot to automatically find the service class it must be annotated with @Component:

```java
package com.github.straider.java.ws.cxf;

import org.springframework.stereotype.Component;

...

@Path( "/" )
@Component
public class GreetingService {
    ...
}
```

**Note**: it seems that the @Component annotation is not necessary when using **cxf-spring-boot-starter-jaxrs**.

### Server

The following error occurs when there's no Spring Boot annotated main class.

```
Failed to execute goal org.springframework.boot:spring-boot-maven-plugin:1.4.3.RELEASE:start (default-cli) on project rest-springboot: Spring application did not start before the configured timeout 
```

To fix it, after adding the missing dependencies to pom.xml (3rd version), then change the **Server** class to an **Application** class:

```java
package com.github.straider.java.ws.cxf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main( final String[] arguments ) {
        SpringApplication.run( Application.class, arguments );
    }

}
```

It's also necessary to have an **ApplicationConfiguration** class, which will have the legacy Server class code, with a few changes:

```java
package com.github.straider.java.ws.cxf;

import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.provider.AbstractConfigurableProvider;
import org.apache.cxf.jaxrs.provider.json.JSONProvider;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.ArrayList;
import java.util.List;

@ComponentScan
@Configuration
public class ApplicationConfiguration {

    @Autowired
    private GreetingService greetingService;

    @Bean( destroyMethod = "shutdown" )
    public SpringBus cxf() {
        return new SpringBus();
    }

    @Bean( destroyMethod = "destroy" ) @DependsOn( "cxf" )
    public Server jaxRsServer() {
        final JAXRSServerFactoryBean serverFactory = new JAXRSServerFactoryBean();
        serverFactory.setServiceBean( greetingService );
        serverFactory.setBus( cxf() );
        serverFactory.setAddress( "/" );

        final JSONProvider                         jsonProvider = new JSONProvider();
        final List< AbstractConfigurableProvider > providers    = new ArrayList< AbstractConfigurableProvider >();
        providers.add( jsonProvider );
        serverFactory.setProviders( providers );

        return serverFactory.create();
    }

    @Bean
    public ServletRegistrationBean cxfServlet() {
        final ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean( new CXFServlet(), "/*" );

        servletRegistrationBean.setLoadOnStartup( 1 );

        return servletRegistrationBean;
    }

}
```

### Client
