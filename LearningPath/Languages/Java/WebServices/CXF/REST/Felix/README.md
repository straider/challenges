﻿:: CXF :: REST :: Felix ::
==========================

# Overview

Register the steps necessary, from scratch, to develop a simple REST OSGi bundle service using CXF and running with Felix.

## How to create an OSGi bundle?

Simplest and most commonly used way is to use [Maven Bundle Plugin](http://felix.apache.org/components/bundle-plugin/). There are 2 ways:

### Generating MANIFEST.INF

This way requires the Maven Bundle Plugin to first generate the MANIFEST.INF for the project, using its [bundle:manifest](http://felix.apache.org/components/bundle-plugin/manifest-mojo.html) goal during the process-classes phase, and then configure the [Maven JAR Plugin](https://maven.apache.org/plugins/maven-jar-plugin/) or [Maven WAR Plugin](http://maven.apache.org/plugins/maven-war-plugin/) to use this generated MANIFEST.INF file.

### Creating the bundle

This way generates the MANIFEST.INF and adds it to the artifact, without needing to use Maven JAR/WAR Plugins.

## How to run a CXF REST OSGi bundle service using Felix?

- Start Felix;
- Use Gogo Shell to:
    - Add the OBR that contains the generated bundles;
    - Install the bundle and its required dependencies;
    - Start the bundle.

**Note**: bare Felix knows how to install bundles through one of two protocols - file or http. Only the http protocol requires an OBR, with the usual repository.xml, while file protocol requires a bundle JAR. There are extra bundles that augment Felix ways of installing bundles:
- [Felix File Install](http://felix.apache.org/documentation/subprojects/apache-felix-file-install.html) is a directory based OSGi management agent. It uses a directory in the file system to install and start a bundle when it is first placed there;
- [Pax-URL](https://github.com/ops4j/org.ops4j.pax.url) adds Custom URL stream handlers for OSGi.

## How to launch Felix from Maven?

- [Exec Maven Plugin](http://www.mojohaus.org/exec-maven-plugin/): launch Felix from its JAR file and set the [workingDirectory](http://www.mojohaus.org/exec-maven-plugin/exec-mojo.html#workingDirectory);
- [felix-maven-plugin](https://github.com/sn3d/felix-maven-plugin) provides felix:run goal that can be configured to start a Felix instance with bundles and configuration and felix:assembly goal that creates a Felix distribution with bundles and configuration;
- [Pax Runner](https://ops4j1.jira.com/wiki/display/paxrunner/Pax+Runner) is a tool to provision OSGi bundles in all major open source OSGi framework implementations (Felix, Equinox, Knopflerfish, Concierge).
- [eosgi-maven-plugin](http://www.everit.org/eosgi-maven-plugin/)

# Steps

Copy [Standalone](../Standalone/README.md) project and change the buildfiles only.

## Buildfiles

### Maven

#### 1st version

Edit the project artifact, name, description and URL and replace **Standalone** with **Felix**.

```xml
    ...

    <artifactId>rest-felix</artifactId>
    <version>1.0.0</version>
    <name>Felix CXF Greeting Service</name>
    <description>REST Greeting Service running on Felix using CXF (JAX-RS implementation).</description>
    <url>https://github.com/straider/challenges/tree/master/LearningPath/2017/CXF/REST/Felix</url>

    <packaging>jar</packaging>

    ...
```

Also clear the profiles - these will be added later on.

#### 2nd version

Add org.osgi.core 6.0.0 dependency and remove slf4j-simple dependency:

```xml
    ...

    <properties>
        ...

        <osgi.version>6.0.0</osgi.version>
        ...
    </properties>

    <dependencies>

        <dependency>
            <groupId>org.osgi</groupId>
            <artifactId>org.osgi.core</artifactId>
            <version>${osgi.version}</version>
        </dependency>

        ...
    </dependencies>

    ...
```

#### 3rd version

To build a proper bundle JAR it's necessary to use the Maven Bundle Plugin and change the packaging to bundle:

```xml
    ....

    <properties>
        ...
        <maven-bundle-plugin.version>3.2.0</maven-bundle-plugin.version>

        ...
    </properties>

    ...

    <build>

        <pluginManagement>

            <plugins>

                <plugin>
                    <groupId>org.apache.felix</groupId>
                    <artifactId>maven-bundle-plugin</artifactId>
                    <version>${maven-bundle-plugin.version}</version>
                </plugin>

            </plugins>

        </pluginManagement>

        <plugins>

            <plugin>
                <groupId>org.apache.felix</groupId>
                <artifactId>maven-bundle-plugin</artifactId>
                <extensions>true</extensions>
                <configuration>
                    <instructions>
                        <Bundle-Activator>${project.groupId}.ProducerActivator</Bundle-Activator>
                        <Bundle-Vendor>straider</Bundle-Vendor>
                    </instructions>
                </configuration>
            </plugin>

        </plugins>

    </build>

```

**Note**: it's not necessary to use maven-dependency-plugin and maven-jar-plugin.

### Gradle

## Components

### Base / Foundation

### BundleActivator

Replace the Server class with a GreeterActivator:

```java
package com.github.straider.java.ws.cxf;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class GreeterActivator implements BundleActivator {

    private ServiceRegistration registration;

    @Override
    public void start( final BundleContext bundleContext ) throws Exception {
        final GreetingService service = new GreetingService();

        registration = bundleContext.registerService( GreetingService.class.getName(), service, null );
    }

    @Override
    public void stop( final BundleContext bundleContext ) throws Exception {
        registration.unregister();
    }

}
```

### Client

# Challenges
