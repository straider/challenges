:: OSGi :: Felix ::
===================

# Overview

## What is it?

> [Apache Felix](http://felix.apache.org/) is a community effort to implement the OSGi Framework and Service platform and other interesting OSGi-related technologies under the Apache license. The OSGi specifications originally targeted embedded devices and home services gateways, but they are ideally suited for any project interested in the principles of modularity, component-orientation, and/or service-orientation.

> [Apache Felix](https://en.wikipedia.org/wiki/Apache_Felix) is an open source implementation of the OSGi Release 5 core framework specification. The initial codebase was donated from the Oscar project at ObjectWeb. The developers worked on Felix for a full year and have made various improvements while retaining the original footprint and performance. On June 21, 2007, the project graduated from incubation as a top level project and is considered the smallest size software at Apache Software Foundation.

## Why use it?

## How to use it?

Issue on the following commands:

```bash
java -jar bin/felix.jar            # Uses felix-cache/ and bundle/.
java -jar bin/felix.jar cache      # Creates and uses cache/ with bundle/.
java -jar bin/felix.jar -b bundles # Uses felix-cache/ and creates and uses bundles/.
```

Most common shell commands:
- install [URL]: to install a bundle at location pointed by given URL;
- uninstall [BUNDLE_ID]: to uninstall a bundle give its BUNDLE_ID;
- bundles: to list installed bundles;
- start [BUNDLE_ID]: to start a bundle given its BUNDLE_ID;
- stop [BUNDLE_ID]: to stop a bundle given its BUNDLE_ID;

## Are there any alternatives?

## History

| Version | OSGi Specification | Release date       |
|---------|--------------------|--------------------|
| 5.2.0   | R6                 | September 25, 2015 |
| 5.0.1   | R6                 | June 21, 2015      |
| 5.0.0   | R4                 | April 24, 2015     |
| 4.6.1   | R4                 | March 08, 2015     |

# Resources

- [Apache Felix](https://github.com/apache/felix) @ GitHub
- [pojosr](https://code.google.com/archive/p/pojosr/) is service registry that enables OSGi style service registry programs without using an OSGi framework. The current implementation is based in parts on Apache Felix and is a work in progress.
    - [PojoSR](https://github.com/lefou/pojosr) @ GitHub
    - [PojoSR brings Service Registry to Java](https://www.infoq.com/news/2011/10/pojosr)
    - [Using PojoSR for unit testing OSGi bundles](https://kgilmersden.wordpress.com/2011/12/15/using-pojosr-for-unit-testing-osgi-bundles/)
- [felix-maven-plugin](https://github.com/sn3d/felix-maven-plugin) is used to run concrete Apache Felix configuration with installed OSGi bundles.

## Tutorials

- [Apache Felix OSGi Tutorial](http://felix.apache.org/documentation/tutorials-examples-and-presentations/apache-felix-osgi-tutorial.html)
- [OSGi - Simple Hello World with services](http://baptiste-wicht.com/posts/2010/07/osgi-hello-world-services.html)
- [OSGi and Spring Dynamic Modules - Simple Hello World](http://baptiste-wicht.com/posts/2010/07/osgi-spring-dynamic-modules-hello-world.html)

## Articles

- [How To Embed OSGi](http://njbartlett.name/2011/07/03/embedding-osgi.html)
- [OSGi and Apache Felix 3.0](http://javabeat.net/osgi-and-apache-felix-3-0/)
- [Apache Felix – OSGi Service Platform](https://eureka.ykyuen.info/2010/03/11/apache-felix-osgi-service-platform/)
- [Apache Felix – Register OSGi Service](https://eureka.ykyuen.info/2010/03/13/apache-felix-register-osgi-service/)
- [Maven – Create a OSGi bundle using maven-bundle-plugin](https://eureka.ykyuen.info/2010/03/12/maven-create-a-osgi-bundle-using-maven-bundle-plugin/)

## Books

# Examples

# Projects

## Felix Subprojects

- [Apache Felix Framework](http://felix.apache.org/documentation/subprojects/apache-felix-framework.html) is an implementation of the OSGi R6 core framework specification;
- [Apache Felix File Install](http://felix.apache.org/documentation/subprojects/apache-felix-file-install.html)
- [Apache Felix HTTP Service](http://felix.apache.org/documentation/subprojects/apache-felix-http-service.html) is an implementation of the HTTP Whiteboard Service as described in chapter 140 of the OSGi Compendium (R6) in combination with an implementation of the HTTP Service Specification as described in chapter 102 of the OSGi Compendium;
- [iPOJO](http://felix.apache.org/documentation/subprojects/apache-felix-ipojo.html) is a service component runtime aiming to simplify OSGi application development. It natively supports ALL the dynamism of OSGi;
- [Apache Felix Log](http://felix.apache.org/documentation/subprojects/apache-felix-log.html)
- [Apache Felix Shell](http://felix.apache.org/documentation/subprojects/apache-felix-shell.html)
- [Apache Felix Remote Shell](http://felix.apache.org/documentation/subprojects/apache-felix-remote-shell.html)
- [Apache Felix Gogo](http://felix.apache.org/documentation/subprojects/apache-felix-gogo.html) is a subproject of Apache Felix implementing the OSGi RFC 147, which describes a standard shell for OSGi-based environments;
- [Apache Felix Web Console](http://felix.apache.org/documentation/subprojects/apache-felix-web-console.html)
- [Apache Felix Service Component Runtime (SCR)](http://felix.apache.org/documentation/subprojects/apache-felix-service-component-runtime.html)
- [Apache Felix OSGi Bundle Repository (OBR)](http://felix.apache.org/documentation/subprojects/apache-felix-osgi-bundle-repository.html)
- [Apache Felix Maven Bundle Plugin (BND)](http://felix.apache.org/documentation/subprojects/apache-felix-maven-bundle-plugin-bnd.html)

# Caveats & Pitfalls

- Current distribution does not come with a bundle that allows installing other bundles from local repository;
- There's not an easy to follow guide on how to setup a local or an internal OSGi Bundle Repository (OBR);
- Spring seems to have abandoned support for OSGi and it's hard to setup Felix with Spring DM bundles.
    - [SpringFramework Removes OSGi Metadata in Move to Gradle](https://www.infoq.com/news/2012/10/spring-osgi-gradle/)
    - [SpringSource Bundle Repository](http://ebr.springsource.com/repository/app/)
        - [SpringSource Enterprise Bundle Repository FAQ](http://ebr.springsource.com/repository/app/faq)
    - [Where can I find Spring 4 OSGi bundles](http://stackoverflow.com/questions/21181154/where-can-i-find-spring-4-osgi-bundles)
    - [Spring OSGi bundles no longer being released](http://karaf.922171.n3.nabble.com/Spring-OSGi-bundles-no-longer-being-released-td4031212.html)
    - [Users of the SpringSource EBR need Spring framework bundles to continue to be published there for Spring 3.2](https://jira.spring.io/browse/SPR-8903)
    - Bundles:
        - spring-osgi-core
        - spring-osgi-extender
        - spring-osgi-io
        - spring-osgi-mock
        - spring-osgi-test
        - spring-osgi-annotation
        - spring-aop
        - spring-context
        - spring-core
        - spring-beans
        - cglib
        - aopalliance
        - slf4j-api
        - slf4j-log4j
        - slf4j-org.apache.commons.logging
        - log4j.osgi

## Spring DM Installation

The required bundles have been added to Felix, in bundle/ folder.

To install them manually on a clean Felix then issue the following commands inside Gogo Shell, after starting Felix with the command ```java -jar bin/felix.jar```:

```bash
install ./spring-dm/dependencies/com.springsource.slf4j.org.apache.commons.logging-1.5.0.jar
install ./spring-dm/dependencies/com.springsource.slf4j.log4j-1.5.0.jar
install ./spring-dm/dependencies/com.springsource.slf4j.api-1.5.0.jar
install ./spring-dm/dependencies/log4j.osgi-1.2.15-SNAPSHOT.jar
install ./spring-dm/dependencies/com.springsource.net.sf.cglib-2.1.3.jar
install ./spring-dm/dependencies/com.springsource.org.aopalliance-1.0.0.jar
install ./spring-dm/dependencies/org.springframework.core-2.5.6.SEC01.jar
install ./spring-dm/dependencies/org.springframework.context-2.5.6.SEC01.jar
install ./spring-dm/dependencies/org.springframework.beans-2.5.6.SEC01.jar
install ./spring-dm/dependencies/org.springframework.aop-2.5.6.SEC01.jar
install ./spring-dm/osgi/spring-osgi-extender-1.2.1.jar
install ./spring-dm/osgi/spring-osgi-core-1.2.1.jar
install ./spring-dm/osgi/spring-osgi-io-1.2.1.jar

start 5 7 8 9 10 11 12 13 14 15 16 17
```

**Note**: although the installation order is not relevant the same is not true for the starting order, which needs to be exactly as stated. Also bare in mind that com.springsource.slf4j.log4j-1.5.0.jar is a fragmented bundle and therefor is not to be started.
