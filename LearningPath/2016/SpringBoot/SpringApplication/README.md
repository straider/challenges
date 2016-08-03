:: Dojo :: Java :: Spring Boot ::
=================================

#  Spring Application

Start with Quick Start project, which contains Maven and Gradle build files and develop a simple command-line interface application.

## Maven

### pom.xml

```xml
```

### JavaSpringApplication

Running ```mvn clean package``` at this point will fail with the error message:

```
Failed to execute goal org.springframework.boot:spring-boot-maven-plugin:1.4.0.RELEASE:repackage (default)
Execution default of goal org.springframework.boot:spring-boot-maven-plugin:1.4.0.RELEASE:repackage failed:
Unable to find main class
```

The main class, in Java, that prevents the above error message is:

```java
package com.github.straider.spring.boot;

public class JavaSpringApplication {

    public static void main( final String[] arguments ) {
    }

}
```

Running ```mvn package``` at this point will succeeed.

The improved class from above that simply outputs the message "Hello, World!" is:

```java
package com.github.straider.spring.boot;

public class JavaSpringApplication {

    public static void main( final String[] arguments ) {
       System.out.println( "Hello, World!" );
     }

}
```

To run this main class just issue the command ``mvn spring-boot:run```.

## Gradle

### build.gradle

```groovy
```

### JavaSpringApplication

Running ```gradle clean build``` at this point will fail with the error message:

```
Execution failed for task ':bootRepackage'.
> Unable to find main class
```

The main class, in Java, that prevents the above error message is:

```java
package com.github.straider.spring.boot;

public class JavaSpringApplication {

    public static void main( final String[] arguments ) {
    }

}
```

Running ```gradle build``` at this point will succeeed.

The improved class from above that simply outputs the message "Hello, World!" is:

```java
package com.github.straider.spring.boot;

public class JavaSpringApplication {

    public static void main( final String[] arguments ) {
       System.out.println( "Hello, World!" );
     }

}
```

To run this main class just issue the command ``gradle bootRun```.
