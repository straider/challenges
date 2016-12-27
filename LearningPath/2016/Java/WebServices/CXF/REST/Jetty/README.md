:: CXF :: REST :: Jetty ::
==========================

# Overview

Register the steps necessary, from scratch, to develop a simple REST service using CXF and running with Jetty.

## How to run a CXF REST service using Jetty?

# Steps

Copy [Standalone](../Standalone/README.md) project and change the buildfiles only.

## Buildfiles

### Maven

#### 1st version

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

#### 2nd version

Edit the profiles, changing Standalone profile to not be enabled by default and adding Jetty profile, enabled by default.

##### Jetty 6.x

```xml
<?xml version = "1.0" encoding = "UTF-8"?>
<project xmlns              = "http://maven.apache.org/POM/4.0.0"
         xmlns:xsi          = "http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation = "http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd"
>

    ...
    <properties>
        ...

        <jetty6-mortbay.version>6.1.26</jetty-mortbay.version>

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
                <service-stop.port>9999</service-stop.port>
                <service.port>10000</service.port>
                <service.path>/ws/rest</service.path>
            </properties>

            <build>

                <pluginManagement>
                    <plugins>
                        <plugin>
                            <groupId>org.mortbay.jetty</groupId>
                            <artifactId>maven-jetty-plugin</artifactId>
                            <version>${jetty6-mortbay.version}</version>
                        </plugin>
                    </plugins>
                </pluginManagement>

                <plugins>

                    <plugin>
                        <groupId>org.mortbay.jetty</groupId>
                        <artifactId>maven-jetty-plugin</artifactId>
                        <configuration>
                            <scanIntervalSeconds>10</scanIntervalSeconds>
                            <stopKey>STOP</stopKey>
                            <stopPort>${service-stop.port}</stopPort>
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

##### Jetty 7.x

Very similar to Jetty 6.x profile, although the plugin name is now jetty-maven-plugin instead of maven-jetty-plugin:

```xml
<?xml version = "1.0" encoding = "UTF-8"?>
<project xmlns              = "http://maven.apache.org/POM/4.0.0"
         xmlns:xsi          = "http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation = "http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd"
>

    ...
    <properties>
        ...

        <jetty7-mortbay.version>7.6.16.v20140903</jetty7-mortbay.version>

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
            <id>Jetty 7.x</id>
            <activation>
                <activeByDefault>false</activeByDefault>
            </activation>

            <properties>
                <service-stop.port>9999</service-stop.port>
                <service.port>10000</service.port>
                <service.path>/ws/rest</service.path>
            </properties>

            <build>

                <pluginManagement>
                    <plugins>
                        <plugin>
                            <groupId>org.mortbay.jetty</groupId>
                            <artifactId>jetty-maven-plugin</artifactId>
                            <version>${jetty7-mortbay.version}</version>
                        </plugin>
                    </plugins>
                </pluginManagement>

                <plugins>

                    <plugin>
                        <groupId>org.mortbay.jetty</groupId>
                        <artifactId>jetty-maven-plugin</artifactId>
                        <configuration>
                            <scanIntervalSeconds>10</scanIntervalSeconds>
                            <stopKey>STOP</stopKey>
                            <stopPort>${service-stop.port}</stopPort>
                            <webAppSourceDirectory>${project.build.directory}/classes</webAppSourceDirectory>
                            <connectors>
                                <connector implementation="org.eclipse.jetty.server.nio.SelectChannelConnector">
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

##### Jetty 8.x

Very similar to Jetty 7.x profile:

```xml
<?xml version = "1.0" encoding = "UTF-8"?>
<project xmlns              = "http://maven.apache.org/POM/4.0.0"
         xmlns:xsi          = "http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation = "http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd"
>

    ...
    <properties>
        ...

        <jetty8-mortbay.version>8.1.16.v20140903</jetty8-mortbay.version>

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
            <id>Jetty 8.x</id>
            <activation>
                <activeByDefault>false</activeByDefault>
            </activation>

            <properties>
                <service-stop.port>9999</service-stop.port>
                <service.port>10000</service.port>
                <service.path>/ws/rest</service.path>
            </properties>

            <build>

                <pluginManagement>
                    <plugins>
                        <plugin>
                            <groupId>org.mortbay.jetty</groupId>
                            <artifactId>jetty-maven-plugin</artifactId>
                            <version>${jetty8-mortbay.version}</version>
                        </plugin>
                    </plugins>
                </pluginManagement>

                <plugins>

                    <plugin>
                        <groupId>org.mortbay.jetty</groupId>
                        <artifactId>jetty-maven-plugin</artifactId>
                        <configuration>
                            <scanIntervalSeconds>10</scanIntervalSeconds>
                            <stopKey>STOP</stopKey>
                            <stopPort>${service-stop.port}</stopPort>
                            <webAppSourceDirectory>${project.build.directory}/classes</webAppSourceDirectory>
                            <connectors>
                                <connector implementation="org.eclipse.jetty.server.nio.SelectChannelConnector">
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

##### Jetty 9.x

Similar to Jetty 8.x profile, although the group ID is now **org.eclipse.jetty** and the connectors section has been superseeded by a simpler httpConnector section.

```xml
<?xml version = "1.0" encoding = "UTF-8"?>
<project xmlns              = "http://maven.apache.org/POM/4.0.0"
         xmlns:xsi          = "http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation = "http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd"
>

    ...
    <properties>
        ...

        <jetty9-eclipse.version>9.2.20.v20161216</jetty9-eclipse.version>

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
            <id>Jetty 9.x</id>
            <activation>
                <activeByDefault>true</activeByDefault>
            </activation>

            <properties>
                <service-stop.port>9999</service-stop.port>
                <service.port>10000</service.port>
                <service.path>/ws/rest</service.path>
            </properties>

            <build>

                <pluginManagement>
                    <plugins>
                        <plugin>
                            <groupId>org.eclipse.jetty</groupId>
                            <artifactId>jetty-maven-plugin</artifactId>
                            <version>${jetty9-eclipse.version}</version>
                        </plugin>
                    </plugins>
                </pluginManagement>

                <plugins>

                    <plugin>
                        <groupId>org.eclipse.jetty</groupId>
                        <artifactId>jetty-maven-plugin</artifactId>
                        <configuration>
                            <scanIntervalSeconds>10</scanIntervalSeconds>
                            <stopKey>STOP</stopKey>
                            <stopPort>${service-stop.port}</stopPort>
                            <webAppSourceDirectory>${project.build.directory}/classes</webAppSourceDirectory>
                            <httpConnector>
                                <port>${service.port}</port>
                            </httpConnector>
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

**Note**: version 9.2.x is the latest to support Java 7. The more recent versions require Java 8.

#### 3rd version

But it only works for goal ```jetty:run``` and not for goals ```jetty:run-war``` and ```jetty:run-exploded```. These depend on a WAR being packaged and without anything else the following error occurs:

```
Failed to execute goal org.apache.maven.plugins:maven-war-plugin:2.2:war (default-war) on project rest-jetty: Error assembling WAR: webxml attribute is required (or pre-existing WEB-INF/web.xml if executing in update mode)
```

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

### Gradle

## Components

### Base / Foundation

### Server

### Client
