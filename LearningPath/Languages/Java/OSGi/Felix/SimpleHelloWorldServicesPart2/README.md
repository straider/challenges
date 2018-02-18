:: Felix :: SimpleHelloWorldServicesPart1 ::
============================================

# Overview

This example is based on [OSGI and Spring Dynamic Modules - Simple Hello World](http://baptiste-wicht.com/posts/2010/07/osgi-spring-dynamic-modules-hello-world.html), from Baptiste Wicht.

It's a simple project, with 3 modules - common, producer and consumer - that is useful to getting started with Felix and OSGi bundles, and that uses Spring Dynamic Modules.

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
        <artifactId>simple-helloworld-services2</artifactId>
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
- Do not declare Bundle Activator Class.

```xml
    ...
    <parent>
        <groupId>com.github.straider.osgi.felix</groupId>
        <artifactId>simple-helloworld-services2</artifactId>
        <version>1.0.0</version>
    </parent>

    ...
    <packaging>bundle</packaging>

    <dependencies>

        <dependency>
            <groupId>${project.parent.groupId}.common</groupId>
            <artifactId>simple-helloworld-services-common2</artifactId>
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
- Do not declare Bundle Activator Class.

```xml
    ...
    <parent>
        <groupId>com.github.straider.osgi.felix</groupId>
        <artifactId>simple-helloworld-services2</artifactId>
        <version>1.0.0</version>
    </parent>

    ...
    <packaging>bundle</packaging>

    <dependencies>

        <dependency>
            <groupId>${project.parent.groupId}.common</groupId>
            <artifactId>simple-helloworld-services-common2</artifactId>
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

This module simply contains the common service interface, same as it was in Part 1:

```java
package com.github.straider.osgi.felix.common;

public interface HelloWorldService {

    String INTERFACE_NAME = HelloWorldService.class.getName();

    void say();

}
```

### Producer

This module contains the service implementation (producer), same as it was in Part 1, and instead of its activactor it now holds a Spring Bean XML definition:

```java
package com.github.straider.osgi.felix.producer;

import com.github.straider.osgi.felix.common.HelloWorldService;

public class HelloWorldServiceProducer implements HelloWorldService {

    public void say() {
        System.out.println( "Hello, World!" );
    }

}
```

```xml
<?xml version = "1.0" encoding = "UTF-8"?>
<beans xmlns              = "http://www.springframework.org/schema/beans"
       xmlns:xsi          = "http://www.w3.org/2001/XMLSchema-instance"
       xmlns:osgi         = "http://www.springframework.org/schema/osgi"
       xmlns:context      = "http://www.springframework.org/schema/context"
       xsi:schemaLocation = "http://www.springframework.org/schema/beans   http://www.springframework.org/schema/beans/spring-beans.xsd
                             http://www.springframework.org/schema/osgi    http://www.springframework.org/schema/osgi/spring-osgi.xsd
                             http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd"
>

    <bean id = "producer" class = "com.github.straider.osgi.felix.producer.HelloWorldServiceProducer" />

    <osgi:service ref = "producer" interface = "com.github.straider.osgi.felix.common.HelloWorldService" />

</beans>
```

### Consumer

This module contains the service client (consumer), same as it was in Part 1, and instead of its activactor it now holds a Spring Bean XML definition:

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

```xml
<?xml version = "1.0" encoding = "UTF-8"?>
<beans xmlns              = "http://www.springframework.org/schema/beans"
       xmlns:xsi          = "http://www.w3.org/2001/XMLSchema-instance"
       xmlns:osgi         = "http://www.springframework.org/schema/osgi"
       xmlns:context      = "http://www.springframework.org/schema/context"
       xsi:schemaLocation = "http://www.springframework.org/schema/beans   http://www.springframework.org/schema/beans/spring-beans.xsd
                             http://www.springframework.org/schema/osgi    http://www.springframework.org/schema/osgi/spring-osgi.xsd
                             http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd"
>

    <bean id             = "consumer"
          class          = "com.github.straider.osgi.felix.consumer.HelloWorldServiceConsumer"
          init-method    = "startTimer"
          destroy-method = "stopTimer"
          lazy-init      = "false"
    >
        <constructor-arg ref = "service" />
    </bean>

    <osgi:reference id = "service" interface = "com.github.straider.osgi.felix.common.HelloWorldService" />

</beans>
```

## Build

To package the entire project into OSGi bundles (JAR) issue the following command from the project top-folder:

```bash
mvn clean package
```

## Deploy

To deploy on Felix issue the following commands inside its Gogo Shell, after starting it from the felix-5.6.1/ folder:

```bash
install ../SimpleHelloWorldServicesPart2/common/target/simple-helloworld-services-common2-1.0.0.jar
install ../SimpleHelloWorldServicesPart2/producer/target/simple-helloworld-services-producer2-1.0.0.jar
install ../SimpleHelloWorldServicesPart2/consumer/target/simple-helloworld-services-consumer2-1.0.0.jar
```

## Launch

To start the bundles issue the following command inside Felix Gogo Shell:

```bash
start 18 19
```

**Note**: it was necessary to add Spring Dynamic Module bundles to Felix and that's why the bundle IDs no longer start at 5 and start instead at 17.

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

**Note**: bare in mind that bundle simple-helloworld-services-common2-1.0.0.jar is a fragmented bundle and is not startable;

# Challenges

- Understand OSGi bare minimal dependencies;
- Getting started with Maven Bundle Plugin;
- Getting started with OSGi Bundle Activator;
- Getting started with Felix Gogo Shell;
- Learn how to work with Pax Runner;
- Should learn how to follow TDD with OSGi, using Pax Exam?
