:: Groovy :: IDEs :: NetBeans ::
================================

# Steps

## Using Java Project

- Create HelloWorld using Java Application Project;
- Set main class to com.github.straider.HelloWorld;
- Create test class, using JUnit;
- Clean up unnecessary comments;
- Create HelloWorld Groovy class and remove HelloWorld Java class;
- Create HelloWorldTest Groovy class and remove HelloWorldTest Java class;
- Check that default greeting test is RED;
- Add missing method and check that default greeting test is GREEN.

**Note**: there's no Test Class generator given a Groovy class.

## Using Maven Project

## Using Gradle Project

**Note**: Add Gradle plugin.

- Create HelloWorld using Gradle Single Gradle Project;
- Set main class to com.github.straider.HelloWorld;
- Create test class, using JUnit;
- Clean up unnecessary comments;
- Commit changes;
- Edit build.gradle to [compile Groovy before Java](https://coderwall.com/p/wuqopq/compile-groovy-before-java-in-gradle-build);
- Create HelloWorld Groovy class and remove HelloWorld Java class;
- Create HelloWorldTest Groovy class and remove HelloWorldTest Java class;
- Check that default greeting test is RED;
- Add missing method and check that default greeting test is GREEN.

# Notes

- NetBeans 8.1 does not offer support to create Groovy projects, without Grails;
- It's not possible to run a method of a test class, it only allows to run the file;
