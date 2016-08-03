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
  <dependencies>
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter</artifactId>
      <version>1.4.0.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-test</artifactId>
      <version>1.4.0.RELEASE</version>
      <scope>test</scope>
    </dependency>
  </dependencies>

  <build>
    <plugins>
      <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
        <version>1.4.0.RELEASE</version>
      </plugin>
    </plugins>
  </build>
```

### Update Local Repository

```bash
mvn validate
```

## Gradle

Although it's possible to generate a simple build.gradle file and initialize a sample Java project with the following command it's best to do it by hand:

```bash
gradle init --type java-library
```

### Initial build.gradle

```groovy
apply plugin: 'java'

version = '1.0.0'

sourceCompatibility = 1.7
targetCompatibility = 1.7

repositories {
  mavenCentral()
}
```

Command to add the Graddle Wrapper to the project:

```bash
gradle wrapper
```

### Add Dependency

```groovy
apply plugin: 'spring-boot'

repositories {
  mavenLocal()
  mavenCentral()
  maven { url 'http://repo.spring.io/release'   }
  maven { url 'http://repo.spring.io/milestone' }
  maven { url 'http://repo.spring.io/snapshot'  }
}

dependencies {
  compile( 'org.springframework.boot:spring-boot-starter' )
  testCompile( 'org.springframework.boot:spring-boot-starter-test' )
}
```

### Update Local Repository

```bash
gradle check
```
