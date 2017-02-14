:: Spring Boot Swagger Greeting Service ::
==========================================

# Overview

This project holds a simple example of a REST service that runs on SpringBoot and documents its API using Swagger.

# Steps

- Cloned from [:: CXF :: REST :: Spring Boot ::](https://github.com/straider/challenges/tree/master/LearningPath/2017/CXF/REST/SpringBoot) on GitHub;
- Replace package com.github.straider.java.ws.cxf with com.github.straider.springboot.swagger;
- Fix name, description and URL on pom.xml;
- Add Swagger dependencies;
- Enable Swagger by selection of the following options:
    - Create SwaggerConfig class;
    - Add Docket api() and apiInfo() methods to main Application.

## ToDos

- Improve API documentation with @Api annotations;
- Add static index file, with links for:
    - CXF Services;
    - Swagger API documentation.

## Challenges

### Swagger / Swagger UI
