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
