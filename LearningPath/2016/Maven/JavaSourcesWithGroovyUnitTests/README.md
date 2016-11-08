:: Maven :: Java and Groovy :: Dummy Unit Tests
===============================================

# Overview

## Objectives

- pom.xml suitable for projects with production sources in Java and testing sources in Groovy;
- there's actually no Java code, only tests coded in Groovy.

## Scope

Only suitable for projects with unit tests that have following folder structure:

- src/
    - main/java/ - with production sources
    - main/resources/ - with production resources
    - test/groovy/ - with testing sources

*Note*: unit tests are in Groovy and it only uses Maven SureFire Plugin.
