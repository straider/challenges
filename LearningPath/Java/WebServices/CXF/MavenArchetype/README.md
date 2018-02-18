:: Apache CXF :: Maven Archetype ::
===================================

# Steps

## Generate from Archetype

```bash
mvn archetype:generate                              \
        -DarchetypeGroupId=org.apache.cxf.archetype \
        -DarchetypeArtifactId=cxf-jaxrs-service     \
        -DDarchetypeVersion=3.1.8                   \
        -DgroupId=com.github.straider.java.cxf      \
        -DartifactId=MavenArchetype                 \
        -Dversion=1.0.0                             \
        -DinteractiveMode=false

cd MavenArchetype
```

## Start Service

```bash
# mvn clean install -DskipTests=true tomcat7:run
mvn package -DskipTests=true tomcat7:run
```

To validate then point a browser to http://localhost:9090/jaxrs-service/hello/echo/Greetings

## Test with Client

```bash
# mvn test
mvn verify
```

