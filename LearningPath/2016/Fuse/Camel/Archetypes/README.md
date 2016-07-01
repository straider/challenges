:: Fuse :: Camel :: Maven Archetypes ::
=======================================

# Maven Archetypes

## Java Router

To create a new Camel project using Java DSL:

```sh
mvn archetype:generate                             \
    -DarchetypeGroupId=org.apache.camel.archetypes \
    -DarchetypeArtifactId=camel-archetype-java     \
    -DarchetypeVersion=2.17.1                      \
    -DinteractiveMode=false                        \
    -DgroupId=com.github.straider.fuse.camel       \
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
    -DgroupId=com.github.straider.fuse.camel       \
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
    -DgroupId=com.github.straider.fuse.camel       \
    -DartifactId=CamelScala
```

## ActiveMQ

To create a new Camel project that configures and interacts with ActiveMQ:

```sh
mvn archetype:generate                             \
    -DarchetypeGroupId=org.apache.camel.archetypes \
    -DarchetypeArtifactId=camel-archetype-activemq \
    -DarchetypeVersion=2.17.1                      \
    -DinteractiveMode=false                        \
    -DgroupId=com.github.straider.fuse.camel       \
    -DartifactId=CamelActiveMQ
```

## Blueprint (OSGi) Based Router

To create a new Camel project with OSGi blueprint support. Ready to be deployed in OSGi.:

```sh
mvn archetype:generate                              \
    -DarchetypeGroupId=org.apache.camel.archetypes  \
    -DarchetypeArtifactId=camel-archetype-blueprint \
    -DarchetypeVersion=2.17.1                       \
    -DinteractiveMode=false                         \
    -DgroupId=com.github.straider.fuse.camel        \
    -DartifactId=CamelBlueprint
```
