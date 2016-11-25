:: Camel :: Maven Archetypes ::
===============================

# Maven Archetypes

## Java Router

To create a new Camel project using Java DSL:

```sh
mvn archetype:generate                             \
    -DarchetypeGroupId=org.apache.camel.archetypes \
    -DarchetypeArtifactId=camel-archetype-java     \
    -DarchetypeVersion=2.17.1                      \
    -DinteractiveMode=false                        \
    -DgroupId=com.github.straider.camel            \
    -DartifactId=CamelJava
```

## Groovy Router

To create a new Camel project using Groovy  DSL:

```sh
mvn archetype:generate                             \
    -DarchetypeGroupId=org.apache.camel.archetypes \
    -DarchetypeArtifactId=camel-archetype-groovy   \
    -DarchetypeVersion=2.17.1                      \
    -DinteractiveMode=false                        \
    -DgroupId=com.github.straider.camel            \
    -DartifactId=CamelGroovy
```

## Scala Router

To create a new Camel project using Scala DSL:

```sh
mvn archetype:generate                             \
    -DarchetypeGroupId=org.apache.camel.archetypes \
    -DarchetypeArtifactId=camel-archetype-scala    \
    -DarchetypeVersion=2.17.1                      \
    -DinteractiveMode=false                        \
    -DgroupId=com.github.straider.camel            \
    -DartifactId=CamelScala
```

## Spring Router

To create a new Camel project using Spring Framework Context:

```sh
mvn archetype:generate                             \
    -DarchetypeGroupId=org.apache.camel.archetypes \
    -DarchetypeArtifactId=camel-archetype-spring   \
    -DarchetypeVersion=2.17.1                      \
    -DinteractiveMode=false                        \
    -DgroupId=com.github.straider.camel            \
    -DartifactId=CamelSpring
```

## Blueprint (OSGi) Based Router

To create a new Camel project with OSGi blueprint support, ready to be deployed in OSGi:

```sh
mvn archetype:generate                              \
    -DarchetypeGroupId=org.apache.camel.archetypes  \
    -DarchetypeArtifactId=camel-archetype-blueprint \
    -DarchetypeVersion=2.17.1                       \
    -DinteractiveMode=false                         \
    -DgroupId=com.github.straider.camel             \
    -DartifactId=CamelBlueprint
```

## ActiveMQ

To create a new Camel project that configures and interacts with ActiveMQ:

```sh
mvn archetype:generate                             \
    -DarchetypeGroupId=org.apache.camel.archetypes \
    -DarchetypeArtifactId=camel-archetype-activemq \
    -DarchetypeVersion=2.17.1                      \
    -DinteractiveMode=false                        \
    -DgroupId=com.github.straider.camel            \
    -DartifactId=CamelActiveMQ
```

## Web

To create a new Camel web project that deploys the Camel routes as a WAR:

```sh
mvn archetype:generate                             \
    -DarchetypeGroupId=org.apache.camel.archetypes \
    -DarchetypeArtifactId=camel-archetype-web      \
    -DarchetypeVersion=2.17.1                      \
    -DinteractiveMode=false                        \
    -DgroupId=com.github.straider.camel            \
    -DartifactId=CamelWeb
```

## WAR

To create a new Camel project that deploys the Camel Web Console, REST API, and your routes as a WAR:

```sh
mvn archetype:generate                             \
    -DarchetypeGroupId=org.apache.camel.archetypes \
    -DarchetypeArtifactId=camel-archetype-war      \
    -DarchetypeVersion=2.17.1                      \
    -DinteractiveMode=false                        \
    -DgroupId=com.github.straider.camel            \
    -DartifactId=CamelWAR
```

## Web Console

To create a new Camel project that deploys the Camel Web Console, REST API, and your routes as a WAR:

```sh
mvn archetype:generate                               \
    -DarchetypeGroupId=org.apache.camel.archetypes   \
    -DarchetypeArtifactId=camel-archetype-webconsole \
    -DarchetypeVersion=2.17.1                        \
    -DinteractiveMode=false                          \
    -DgroupId=com.github.straider.camel              \
    -DartifactId=CamelWebConsole
```
