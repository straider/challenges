:: Maven :: Java and Groovy :: Dummy Integration Tests
======================================================

# Overview

## Objectives

- pom.xml suitable for projects with production sources in Java and testing sources in Groovy;
- there's actually no Java code, just tests coded in Groovy with Spock;
- Unit Tests are in Groovy with JUnit 4;
- Integration Tests are in Groovy with Spock.

## Scope

Only suitable for projects with unit and integration tests that have following folder structure:

- src/
    - main/java/ - with production sources
    - main/resources/ - with production resources
    - test/unit/groovy/ - with unit testing sources
    - test/integration/groovy/ - with integration testing sources
    - test/integration/resources/ - with integration testing resources

**Note**: it uses [Maven SureFire Plugin](http://maven.apache.org/components/surefire/maven-surefire-plugin/) for Unit Tests and [Maven FailSafe Plugin](http://maven.apache.org/surefire/maven-failsafe-plugin/) for Integration Tests. But since there are two distinct test sub-folders it is also necessary to use [Build Helper Maven Plugin](http://www.mojohaus.org/build-helper-maven-plugin/) to add the testing sources and resources.
