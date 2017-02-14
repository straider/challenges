:: Spring Boot Swagger Greeting Service ::
==========================================

# Overview

This project holds a simple example of a CXF REST service that runs on SpringBoot and documents its API using Swagger.

# Steps

- Cloned from [:: CXF :: REST :: Spring Boot ::](https://github.com/straider/challenges/tree/master/LearningPath/2017/CXF/REST/SpringBoot) on GitHub;
- Replace package com.github.straider.java.ws.cxf with com.github.straider.springboot.cxf.swagger;
- Fix name, description and URL on pom.xml;
- Add Swagger dependencies;
- Enable Swagger by selection of the following options:
    - Create SwaggerConfig class;
    - Add Docket api() and apiInfo() methods to main Application.

## ToDos

- Implement proper Integration Tests;
- Add Gradle buildfiles;
- Improve API documentation with @Api annotations;
- Add static index file, with links for:
    - CXF Services;
    - Swagger API documentation.

## Challenges

### Swagger / Swagger UI

The resources one can find online are for Swagger 1.x or Swagger 2.x, and they're different from one another.

### SpringBoot and Swagger

The usual examples of SpringBoot with Swagger / Swagger UI usually rely on an application which is just a RESTful SpringBoot application or using Spring MVC. It seems that using CXF or even Spring Data RESTful application require more than just adding the SpringFox dependencies.

### CXF and Swagger

Must use [SwaggerFeature / Swagger2Feature](http://cxf.apache.org/docs/swaggerfeature-swagger2feature.html) of Apache CXF.

To make this project work the usual dependencies on springfox-swagger2 and springfox-swagger-ui have to be replaced with cxf-rt-rs-service-description-swagger and WebJARs swagger-ui. By doing this then the usual way of enabling Swagger 2 also changes and instead of creating a SwaggerConfig class one has to add the Swagger2Feature instance as a feature of the JAXRSServerFactoryBean.

**Note**: other options, instead of programmatically add the Swagger 2 feature, would be to use Spring or Blueprint contexts.

Also, replacing spring-boot-starter-web with cxf-spring-boot-starter-jaxrs works and makes more sense, but also requires the spring-boot-dependencies to be imported.

#### CXF Services

The URL for CXF services page is http://localhost:10000/ws/rest/services (or http://localhost:10000/ws/rest/cxf/services). This page now includes a link to the Swagger UI page.

#### CXF Swagger UI

The URL for Swagger UI page is http://localhost:10000/ws/rest/api-docs?url=/ws/rest/swagger.json, but it doesn't document any of the service methods.
