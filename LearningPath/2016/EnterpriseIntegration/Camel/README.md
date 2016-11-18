:: EnterpriseIntegration :: Camel ::
====================================

# Overview

## Objectives

## Scope

## Tutorials

- [Apache Camel - Tutorials](http://camel.apache.org/tutorials.html)
- [Apache Camel Using Java DSL](http://www.javainuse.com/camel/camel_java)
- [Intro to Camel By Example](https://davidvaleri.wordpress.com/2013/03/28/intro-to-camel-by-example/)
- [Apache Camel – developing application from the scratch (part 1 / 2)](https://vrtoonjava.wordpress.com/2013/10/20/apache-camel-developing-application-from-the-scratch-part-1-2/)
- [Apache Camel – developing application from the scratch (part 2 / 2)](https://vrtoonjava.wordpress.com/2013/10/20/apache-camel-developing-application-from-the-scratch-part-2-2/)
- [Apache Camel Tutorial—EIP, Routes, Components, Testing, and More](https://dzone.com/articles/apache-camel-tutorial-eip)
- [Camel Introduction](http://www.mastertheintegration.com/camel/camel-introduction.html)
- [Transforming Data with Camel](http://www.mastertheintegration.com/camel/transforming-data-with-camel.html)
- [Camel and Web Services](http://www.mastertheintegration.com/camel/camel-and-web-services.html)
- [Camel and JMS](http://www.mastertheintegration.com/camel/camel-and-jms.html)
- [Using the Timer component with Camel](http://www.mastertheintegration.com/camel/timer-component/using-the-timer-component-with-camel.html)

## Articles

## Challenges

### Camel Archetypes for Maven

The following Maven archetypes exist to start Camel projects:

- camel-archetype-java: Java Router
- camel-archetype-groovy: Groovy Router
- camel-archetype-scala: Scala Router
- camel-archetype-activemq: Camel with ActiveMQ
- camel-archetype-blueprint: Blueprint (OSGi) Based Router

### Camel with Maven

#### Steps

- Generate from Maven Archetype
- Execute Main Class
- Change route to copy files from tmp/in/ to tmp/out/
- Add plugin to build WAR file

```sh
mvn archetype:generate                             \
    -DarchetypeGroupId=org.apache.camel.archetypes \
    -DarchetypeArtifactId=camel-archetype-java     \
    -DarchetypeVersion=2.17.1                      \
    -DinteractiveMode=false                        \
    -DgroupId=net.kevinboone.mavencameltest        \
    -DartifactId=MavenCamelTest
```

```sh
mvn compile exec:java

mvn compile assembly:single
java -jar target/mavencameltest-1.0-SNAPSHOT-jar-with-dependencies.jar
```

### Camel in Action
