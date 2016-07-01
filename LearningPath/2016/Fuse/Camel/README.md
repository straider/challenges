:: Fuse :: Camel ::
===================

# Challenges

## Camel with Maven

### Steps

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

## Camel in Action
