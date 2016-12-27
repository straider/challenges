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

### 2nd version

Edit the profiles, changing Standalone profile to not be enabled by default and adding Jetty profile, enabled by default.

#### Jetty 6.x

```xml
<?xml version = "1.0" encoding = "UTF-8"?>
<project xmlns              = "http://maven.apache.org/POM/4.0.0"
         xmlns:xsi          = "http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation = "http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd"
>

    ...
    <properties>
        ...

        <jetty-mortbay.version>6.1.26</jetty-mortbay.version>

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
            <id>Jetty 6.x</id>
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
                            <groupId>org.mortbay.jetty</groupId>
                            <artifactId>maven-jetty-plugin</artifactId>
                            <version>${jetty-mortbay.version}</version>
                        </plugin>
                    </plugins>
                </pluginManagement>

                <plugins>

                    <plugin>
                        <groupId>org.mortbay.jetty</groupId>
                        <artifactId>maven-jetty-plugin</artifactId>
                        <configuration>
                            <scanIntervalSeconds>10</scanIntervalSeconds>
                            <webAppSourceDirectory>${project.build.directory}/classes</webAppSourceDirectory>
                            <connectors>
                                <connector implementation="org.mortbay.jetty.nio.SelectChannelConnector">
                                    <port>${service.port}</port>
                                    <maxIdleTime>60000</maxIdleTime>
                                </connector>
                            </connectors>
                            <webAppConfig>
                                <contextPath>${service.path}</contextPath>
                            </webAppConfig>
                        </configuration>
                    </plugin>

                </plugins>

            </build>
        </profile>

    </profiles>

</project>
```

#### Maven WAR Plugin

But it only works for goal ```jetty:run``` and not for goals ```jetty:run-war``` and ```jetty:run-exploded```. These depend on a WAR being packaged and without anything else the following error occurs:

```
```

To enable the packaging of a proper WAR file it is necessary to configure the **maven-war-plugin**:

```xml
    ...
    
    <properties>
        ...
        
        <maven-war-plugin.version>3.0.0</maven-war-plugin.version>

        ...
    </properties>

    ...

    <build>

        <resources>
            <resource>
                <directory>src/main/resources</directory>
                <filtering>true</filtering>
            </resource>
        </resources>

        <pluginManagement>

            <plugins>

                ...

                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-war-plugin</artifactId>
                    <version>${maven-war-plugin.version}</version>
                    <configuration>
                        <warSourceDirectory>${project.build.directory}/classes</warSourceDirectory>
                    </configuration>
                </plugin>

            </plugins>

        </pluginManagement>

        <plugins>

            ...

            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-war-plugin</artifactId>
            </plugin>

        </plugins>

    </build>
    
    ...
```

#### WEB-INF/web.xml

This requires the **web.xml** in the src/main/resources/WEB-INF/ folder, which uses **CXFNonSpringJaxrsServlet** to avoid using Spring XML beans:

```xml
<?xml version = "1.0" encoding = "utf-8"?>
<web-app xmlns              = "http://java.sun.com/xml/ns/javaee"
         xmlns:xsi          = "http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation = "http://java.sun.com/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_0.xsd"
         version            = "3.0"
>

    <display-name>${project.name}</display-name>
    <description>${project.description}</description>

    <servlet>
        <servlet-name>CXFServlet</servlet-name>
        <servlet-class>
            org.apache.cxf.jaxrs.servlet.CXFNonSpringJaxrsServlet
        </servlet-class>
        <init-param>
            <param-name>jaxrs.serviceClasses</param-name>
            <param-value>${servlet.class}</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>

    <servlet-mapping>
        <servlet-name>CXFServlet</servlet-name>
        <url-pattern>/*</url-pattern>
    </servlet-mapping>

</web-app>
```

### Maven

### Gradle

## Components

### Base / Foundation

### Server

### Client
