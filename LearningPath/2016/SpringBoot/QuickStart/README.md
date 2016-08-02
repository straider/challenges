:: Dojo :: Java :: Spring Boot ::
=================================

#  Quick Start

To generate a basic project, follow the [Quick Start](http://projects.spring.io/spring-boot/#quick-start) example.

## Maven

> What is Archetype?

>> In short, [Archetype](http://maven.apache.org/archetype/index.html) is a Maven project templating toolkit.

>> An archetype is defined as an original pattern or model from which all other things of the same kind are made. The name fits as we are trying to provide a system that provides a consistent means of generating Maven projects. Archetype will help authors create Maven project templates for users, and provides users with the means to generate parameterized versions of those project templates.

Call ```mvn archetype:generate``` in order to create a new project:

```bash
mvn archetype:generate                             \
    -DarchetypeGroupId=org.apache.maven.archetypes \
    -DarchetypeArtifactId=maven-archetype-simple   \
    -DarchetypeVersion=1.0                         \
    -DinteractiveMode=false                        \
    -DgroupId=com.github.straider.spring.boot      \
    -Dpackage=com.github.straider.spring.boot      \
    -Dversion=1.0.0-SNAPSHOT                       \
    -DartifactId=QuickStart
```

It fails with error:

```
Failed to execute goal org.apache.maven.plugins:maven-archetype-plugin:2.4:generate (default-cli) on project standalone-pom:
The defined artifact is not an archetype
```

It's better to code a pom.xml by hand instead of using an archetype that just generates the simplest pom.xml and empty folder layout for a project.

### Initial pom.xml

```xml
<?xml version = "1.0" encoding = "UTF-8"?>
<project xmlns              = "http://maven.apache.org/POM/4.0.0"
         xmlns:xsi          = "http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation = "http://maven.apache.org/POM/4.0.0
                               http://maven.apache.org/xsd/maven-4.0.0.xsd"
>
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.github.straider.spring.boot</groupId>
  <artifactId>QuickStart</artifactId>
  <version>1.0.0</version>
</project>
```

### Add Dependency

```xml
  <parent>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-parent</artifactId>
      <version>1.4.0.RELEASE</version>
  </parent>

  <dependencies>
      <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-web</artifactId>
      </dependency>
  </dependencies>
```

### Update Local Repository

```bash
mvn initialize # compile works, but clean and validate or initialize should do the trick.
```

## Gradle

