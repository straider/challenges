:: Java :: Project Scaffolding ::
=================================

# Overview

Each time a new Java project starts then one has to choose between creating the initial version from an archetype or a template, copying from a previous project or start from scratch.

Starting from scratch is too time consuming and adds no value to any programmer that already knows how to do it. It's said that good programmers are "lazy" and usually they end up automating boring and repetitive tasks.

That's when one first starts by copying from a "good-enough" legacy project. The problem here is that "good-enough" may also bring deficiencies or bad habits, may have more than it's necessary (bloated) or may lack some of the new cool functionalities learnt in the meantime.

So, the end result is usually to create an archetype or template, with the bare minimals that suit either a general purpose or is tailored for a specific purpose.

This learning path started out from the need to have a simple project layout that could quickly and easily do the scaffolding for most of my projects in Java.

## Goal and Objectives

- Maven based, without using archetypes;
- Gradle based, without using Lazybones templates;
- Unit Tests in Groovy using JUnit (and Spock);
- Integration Tests in Groovy using Spock or Cucumber;
- May provide different sub/projects for each packaging type:
    - Library or component JAR;
    - Runnable application JAR;
    - WAR;
    - Multiple modules application.

## Project Layout

```
+- README.md
+- .gitignore          - Git configuration of folders and files to ignore.
+- src/
   +- main/
      +- java/         - Java production code.
      +- groovy/       - Optional Groovy production code.
      +- resources/    - Production ready resources (which should be filtered before copied to the output folder).
   +- test/
      +- integration/
         +- groovy/    - Groovy integration testing code.
         +- resources/ - Integration testing resources (should contain Cucumber .feature files).
      +- unit/
         +- groovy/    - Groovy unit testing code.
+- build/              - Gradle output folder, which must be ignored by the version control system.
+- target/             - Maven output folder, which must be ignored by the version control system.
```

## Constraints

- Sources and resources are encoded in UTF-8;
- Production code is in Java 7, which is imposed;
- Testing code is in Groovy 2.4;
- Unit Testing Framework is JUnit 4 and test cases must exist and pass;
- Integration Testing Frameworks are Spock and Cucumber and test cases / features must exist but may fail;
- It does not provide any code coverage tool support.

## History

- [challenges / Groovy / ProjectLayout](https://github.com/straider/challenges/tree/master/LearningPath/2016/Groovy/ProjectLayout)
- [coding-dojo / Builders / ProjectLayout](https://github.com/straider/coding-dojo/tree/Java/Builders/ProjectLayout)
- Maven:
    - [Sample Project Layout](https://github.com/straider/coding-dojo/tree/Java/Builders/Maven/SampleProjectLayout)
    - [Multiple Modules Project Object Model](https://github.com/straider/coding-dojo/tree/Java/Builders/Maven/ModulesProjectLayout)
    - [Parent Project Object Model](https://github.com/straider/coding-dojo/tree/Java/Builders/Maven/ParentProjectObjectModel)

# Path

## Maven

### Component

### Offline Application

### Online Application

### Parent for Multiple Modules

### Re-usuable Parent

## Gradle

### Component

### Offline Application

### Online Application

### Parent for Multiple Modules

### Re-usuable Parent

# Challenges

- How to track and quickly replace placeholders?
- How to allow for JUnit or TestNG?
- How to keep plugins and dependencies versions up to date?
- Compare with:
    - Maven Archetypes;
    - Lazybones.
