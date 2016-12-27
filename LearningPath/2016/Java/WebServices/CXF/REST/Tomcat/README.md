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

#### 2nd version

Edit the profiles, changing Standalone profile to not be enabled by default and adding Tomcat profile, enabled by default.

##### Tomcat

```xml
    ...

    <properties>
        ...

        <tomcat.version>2.2</tomcat.version>

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
            <id>Tomcat</id>
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
                            <groupId>org.apache.tomcat.maven</groupId>
                            <artifactId>tomcat6-maven-plugin</artifactId>
                            <version>${tomcat.version}</version>
                            <configuration>
                                <port>${service.port}</port>
                                <path>${service.path}</path>
                                <useSeparateTomcatClassLoader>true</useSeparateTomcatClassLoader>
                                <warSourceDirectory>${project.build.directory}/classes</warSourceDirectory>
                            </configuration>
                        </plugin>
                        <plugin>
                            <groupId>org.apache.tomcat.maven</groupId>
                            <artifactId>tomcat7-maven-plugin</artifactId>
                            <version>${tomcat.version}</version>
                            <configuration>
                                <port>${service.port}</port>
                                <path>${service.path}</path>
                                <useSeparateTomcatClassLoader>true</useSeparateTomcatClassLoader>
                                <warSourceDirectory>${project.build.directory}/classes</warSourceDirectory>
                            </configuration>
                        </plugin>
                    </plugins>
                </pluginManagement>

                <plugins>
                    <plugin>
                        <groupId>org.apache.tomcat.maven</groupId>
                        <artifactId>tomcat6-maven-plugin</artifactId>
                    </plugin>
                    <plugin>
                        <groupId>org.apache.tomcat.maven</groupId>
                        <artifactId>tomcat7-maven-plugin</artifactId>
                    </plugin>
                </plugins>

            </build>
        </profile>

    </profiles>

    ...
```

#### 3rd version

Although Tomcat Maven Pkugin builds a WAR file it does with default settings. And it also requires a web.xml file.

##### Maven WAR Plugin

To enable the packaging of a proper WAR file it is necessary to configure the **[maven-war-plugin](https://maven.apache.org/plugins/maven-war-plugin/)**:

```xml
    ...
    
    <properties>
        ...
        
        <maven-war-plugin.version>3.0.0</maven-war-plugin.version>

        ...
    </properties>

    ...

    <build>

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

##### WEB-INF/web.xml

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

And it also requires the file content to be filtered when copied as a resource:

```xml
    ...
    
    <build>

        <resources>
            <resource>
                <directory>src/main/resources</directory>
                <filtering>true</filtering>
            </resource>
        </resources>

        ...

    </build>
    
    ...
```

### Gradle

## Components

### Base / Foundation

### Server

### Client
