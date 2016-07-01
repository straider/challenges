:: Fuse :: Camel ::
===================

# Challenges

## Camel with Maven

### Steps

#### Generate from Maven Archetype

```sh
mvn archetype:generate                             \
    -DarchetypeGroupId=org.apache.camel.archetypes \
    -DarchetypeArtifactId=camel-archetype-java     \
    -DarchetypeVersion=2.17.1                      \
    -DinteractiveMode=false                        \
    -DgroupId=net.kevinboone.mavencameltest        \
    -DartifactId=MavenCamelTest
```

##### Execute Main Class

```sh
mvn compile exec:java
```

## Camel in Action
