:: Felix :: SimpleHelloWorldServicesPart1 ::
============================================

# Overview

This example is based on [OSGi - Simple Hello World with services](http://baptiste-wicht.com/posts/2010/07/osgi-hello-world-services.html), from Baptiste Wicht.

It's a simple enough project, with 3 modules - common, producer and consumer - that is useful to getting started with Felix and OSGi bundles.

# Steps

## Maven

### parent

- With packaging type set to **pom**;
- Declare common dependencies, such as OSGi Core, inside Dependencies node;
- Declare Maven Bundle Plugin inside Plugin Management node;

```xml
    ...
    <packaging>pom</packaging>

    <modules>
        <module>common</module>
        <module>producer</module>
        <module>consumer</module>
    </modules>

    <properties>
        ...

        <osgi.version>6.0.0</osgi.version>

        <maven-bundle-plugin.version>3.2.0</maven-bundle-plugin.version>
    </properties>

    <dependencies>

        <dependency>
            <groupId>org.osgi</groupId>
            <artifactId>org.osgi.framework</artifactId>
            <version>${osgi.version}</version>
        </dependency>

    </dependencies>

    <build>

        <pluginManagement>

            <plugins>

                <plugin>
                    <groupId>org.apache.felix</groupId>
                    <artifactId>maven-bundle-plugin</artifactId>
                    <version>${maven-bundle-plugin.version}</version>
                    <extensions>true</extensions>
                </plugin>

            </plugins>

        </pluginManagement>

    </build>
    ...
```

### common

- With packaging type set to **bundle**, provided by Maven Bundle Plugin;
- Inheriting from parent pom.xml;
- Declaring Bundle Export Package.

```xml
    ...
    <parent>
        <groupId>com.github.straider.osgi.felix</groupId>
        <artifactId>simple-helloworld-services1</artifactId>
        <version>1.0.0</version>
    </parent>

    ...
    <packaging>bundle</packaging>

    <build>

        <plugins>

            <plugin>
                <groupId>org.apache.felix</groupId>
                <artifactId>maven-bundle-plugin</artifactId>
                <extensions>true</extensions>
                <configuration>
                    <instructions>
                        <Export-Package>${project.groupId}</Export-Package>
                        <Bundle-Vendor>straider</Bundle-Vendor>
                    </instructions>
                </configuration>
            </plugin>

        </plugins>

    </build>
    ...
```

### producer

- With packaging type set to **bundle**, provided by Maven Bundle Plugin;
- Inheriting from parent pom.xml;
- Depending on Common Module;
- Declaring Bundle Activator Class.

```xml
    ...
    <parent>
        <groupId>com.github.straider.osgi.felix</groupId>
        <artifactId>simple-helloworld-services1</artifactId>
        <version>1.0.0</version>
    </parent>

    ...
    <packaging>bundle</packaging>

    <dependencies>

        <dependency>
            <groupId>${project.parent.groupId}.common</groupId>
            <artifactId>simple-helloworld-services-common1</artifactId>
            <version>1.0.0</version>
        </dependency>

    </dependencies>

    <build>

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
    ...
```

### consumer

- With packaging type set to **bundle**, provided by Maven Bundle Plugin;
- Inheriting from parent pom.xml;
- Depending on Common Module;
- Declaring Bundle Activator Class.

```xml
    ...
    <parent>
        <groupId>com.github.straider.osgi.felix</groupId>
        <artifactId>simple-helloworld-services1</artifactId>
        <version>1.0.0</version>
    </parent>

    ...
    <packaging>bundle</packaging>

    <dependencies>

        <dependency>
            <groupId>${project.parent.groupId}.common</groupId>
            <artifactId>simple-helloworld-services-common1</artifactId>
            <version>1.0.0</version>
        </dependency>

    </dependencies>

    <build>

        <plugins>

            <plugin>
                <groupId>org.apache.felix</groupId>
                <artifactId>maven-bundle-plugin</artifactId>
                <extensions>true</extensions>
                <configuration>
                    <instructions>
                        <Bundle-Activator>${project.groupId}.ConsumerActivator</Bundle-Activator>
                        <Bundle-Vendor>straider</Bundle-Vendor>
                    </instructions>
                </configuration>
            </plugin>

        </plugins>

    </build>
    ...
```

## Modules

### Common

This module simply contains the common service interface:

```java
package com.github.straider.osgi.felix.common;

public interface HelloWorldService {

    String INTERFACE_NAME = HelloWorldService.class.getName();

    void say();

}
```

### Producer

This module contains the service implementation (producer) and its activactor:

```java
package com.github.straider.osgi.felix.producer;

import com.github.straider.osgi.felix.common.HelloWorldService;

public class HelloWorldServiceProducer implements HelloWorldService {

    public void say() {
        System.out.println( "Hello, World!" );
    }

}
```

```java
package com.github.straider.osgi.felix.producer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import static com.github.straider.osgi.felix.common.HelloWorldService.INTERFACE_NAME;

public class ProducerActivator implements BundleActivator {

    private ServiceRegistration registration;

    @Override
    public void start( final BundleContext bundleContext ) throws Exception {
        final HelloWorldServiceProducer service = new HelloWorldServiceProducer();

        registration = bundleContext.registerService( INTERFACE_NAME, service, null );
    }

    @Override
    public void stop( final BundleContext bundleContext ) throws Exception {
        registration.unregister();
    }

}
```

### Consumer

This module contains the service client (consumer) and its activator:

```java
package com.github.straider.osgi.felix.consumer;

import com.github.straider.osgi.felix.common.HelloWorldService;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloWorldServiceConsumer implements ActionListener {

    private final HelloWorldService service;
    private final Timer             timer;

    public HelloWorldServiceConsumer( final HelloWorldService service ) {
        super();

        this.service = service;
        this.timer   = new Timer( 1000, this );
    }

    @Override
    public void actionPerformed( final ActionEvent actionEvent ) {
        service.say();
    }

    public void startTimer() {
        timer.start();
    }

    public void stopTimer() {
        timer.stop();
    }

}
```

```java
package com.github.straider.osgi.felix.consumer;

import com.github.straider.osgi.felix.common.HelloWorldService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import static com.github.straider.osgi.felix.common.HelloWorldService.INTERFACE_NAME;

public class ConsumerActivator implements BundleActivator {

    private HelloWorldServiceConsumer consumer;

    @Override
    public void start( final BundleContext bundleContext ) throws Exception {
        final ServiceReference service = bundleContext.getServiceReference( INTERFACE_NAME );

        consumer = new HelloWorldServiceConsumer( ( HelloWorldService ) bundleContext.getService( service ) );
        consumer.startTimer();
    }

    @Override
    public void stop( final BundleContext bundleContext ) throws Exception {
        consumer.stopTimer();
    }

}
```

## Build

To package the entire project into OSGi bundles (JAR) issue the following command from the project top-folder:

```bash
mvn clean package
```

## Deploy

To deploy on Felix issue the following commands inside its Gogo Shell, after starting it from the felix-5.6.1/ folder:

```bash
install ../SimpleHelloWorldServicesPart1/common/target/simple-helloworld-services-common1-1.0.0.jar
install ../SimpleHelloWorldServicesPart1/producer/target/simple-helloworld-services-producer1-1.0.0.jar
install ../SimpleHelloWorldServicesPart1/consumer/target/simple-helloworld-services-consumer1-1.0.0.jar
```

## Launch

To start the bundles issue the following command inside Felix Gogo Shell:

```bash
start 6 7
```

The output should be:

```
Hello, World!
Hello, World!
Hello, World!
Hello, World!
Hello, World!
Hello, World!
Hello, World!
Hello, World!
Hello, World!
Hello, World!
Hello, World!
...
```

**Note**: bare in mind that bundle simple-helloworld-services-common1-1.0.0.jar is a fragmented bundle and is not startable;

# Challenges

- Understand OSGi bare minimal dependencies;
- Getting started with Maven Bundle Plugin;
- Getting started with OSGi Bundle Activator;
- Getting started with Felix Gogo Shell;
- Learn how to work with Pax Runner;
- Should learn how to follow TDD with OSGi, using Pax Exam?
