[PROJECT_NAME]
==============

# Overview

[[PROJECT_NAME]]()

# Build Instructions

## Local

Please read the [BUILD.md](BUILD.md) file.

## Docker

Please read the [BUILD.md](BUILD.md) file.

## OpenShift

# Deploy Instructions

## Local

Please read the [DEPLOY.md](DEPLOY.md) file.

## CI / CD Pipeline

Execute the continuous delivery [OpenShift Pipeline](.../browse/pipelines/[SERVICE_ARTIFACT_ID]), which triggers Jenkins' [Build Job](.../job/mo-pipelines-[SERVICE_ARTIFACT_ID]/).

**Note**: The pipeline also performs quality checks, which are stored in [SonarQube](http://sonarqube5-.../).

# Spring Boot Configuration

::FIXME:: Add instructions on how to configure Spring Boot Application.

# How to Test

## Unit Testing

::FIXME:: Add instructions on how to test.

## Integration Testing

::FIXME:: Add instructions on how to test.

## Contract Testing

::FIXME:: Add instructions on how to test.

## Vulnerabilities Checks

::FIXME:: Add instructions on how to test.

## OWASP Dependency Checks

::FIXME:: Add instructions on how to test.

## Functional Tests

::FIXME:: Add instructions on how to execute functional tests.

## Sanity Checks

::FIXME:: Add instructions on how to test.

## Smoke Tests

::FIXME:: Add instructions on how to test.

## Performance Tests

::FIXME:: Add instructions on how to execute functional tests.
