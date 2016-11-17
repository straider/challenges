:: EnterpriseIntegration :: Karaf :: Maven Archetypes ::
========================================================

# Overview

## Objectives

## Scope

http://kevinboone.net/camelosgimaventest.html
http://www.hascode.com/2012/04/wiring-made-easy-using-osgi-blueprint-and-apache-karaf/
http://blog.nanthrax.net/2011/12/overview-on-apache-karaf-pax-web-and-camel-archetypes/

# Maven Archetypes

## Spring OSGi Bundle

```sh
mvn archetype:generate                                 \
    -DarchetypeGroupId=org.springframework.osgi        \
    -DarchetypeArtifactId=spring-osgi-bundle-archetype \
    -DarchetypeVersion=1.2.1                           \
    -DinteractiveMode=false                            \
    -DgroupId=com.github.straider.fuse.karaf           \
    -Dpackage=com.github.straider.fuse.karaf           \
    -Dversion=1.0.0-SNAPSHOT                           \
    -DartifactId=SpringBundle
```

## Karaf OSGi Bundle

```sh
mvn archetype:generate                             \
    -DarchetypeGroupId=org.apache.karaf.archetypes \
    -DarchetypeArtifactId=karaf-bundle-archetype   \
    -DarchetypeVersion=4.0.5                       \
    -DinteractiveMode=false                        \
    -DgroupId=com.github.straider.fuse.karaf       \
    -Dpackage=com.github.straider.fuse.karaf       \
    -Dversion=1.0.0-SNAPSHOT                       \
    -DartifactId=KarafBundle
```

## Karaf OSGi Blueprint

```sh
mvn archetype:generate                              \
    -DarchetypeGroupId=org.apache.karaf.archetypes  \
    -DarchetypeArtifactId=karaf-blueprint-archetype \
    -DarchetypeVersion=4.0.5                        \
    -DinteractiveMode=false                         \
    -DgroupId=com.github.straider.fuse.karaf        \
    -Dpackage=com.github.straider.fuse.karaf        \
    -Dversion=1.0.0-SNAPSHOT                        \
    -DartifactId=KarafBlueprint
```

## Camel Blueprint

To create a new Camel project with OSGi blueprint support, ready to be deployed in OSGi:

```sh
mvn archetype:generate                              \
    -DarchetypeGroupId=org.apache.camel.archetypes  \
    -DarchetypeArtifactId=camel-archetype-blueprint \
    -DarchetypeVersion=2.17.1                       \
    -DinteractiveMode=false                         \
    -DgroupId=com.github.straider.fuse.camel        \
    -DartifactId=CamelBlueprint
```
