:: Spring Boot Swagger Greeting Service ::
==========================================

# Overview

This project holds a simple example of a Spring MVC REST service that runs on SpringBoot and documents its API using Swagger.

# Steps

- Cloned from [:: CXF :: REST :: Spring Boot ::](https://github.com/straider/challenges/tree/master/LearningPath/2017/CXF/REST/SpringBoot) on GitHub;
- Replace package com.github.straider.java.ws.cxf with com.github.straider.springboot.springmvc.swagger;
- Fix name, description and URL on pom.xml;
- Add Swagger dependencies;
- Enable Swagger by selection of the following options:
    - Create SwaggerConfig class;
    - Add Docket api() and apiInfo() methods to main Application.

## ToDos

- Implement proper Integration Tests;
- Add Gradle buildfiles;
- Improve API documentation with @Api annotations;
- Add static index file, with links to the Swagger API documentation.

## Challenges

### SpringBoot and JSON

Unable to have the code consuming or producing JSON.

### Spring MVC Consumes

A good thing about Spring MVC is that it really enforces the Consume media type, while CXF seems not to take it in consideration. This means that requests to Spring MVC must have the Accept Type key on the request header or that the consume key in the @RequestMapping must include MediaType.ALL_VALUE.

### Spring MVC Static Content

To add static content to a SpringBoot application is just as easy as adding HTML files to either resources/static/ or resources/public/ folders.

### Swagger / Swagger UI

The resources one can find online are for Swagger 1.x or Swagger 2.x, and they're different from one another.

To enable Swagger then just add the missing dependencies for springfox-swagger2 and springfox-swagger-ui and add the @EnableSwagger2 annotation to the class than contains the Docket API method.

### Spring MVC and Swagger

The URL to Swagger UI is http://localhost:10000/ws/rest/swagger-ui.html and the API documentation in JSON format is available at http://localhost:10000/ws/rest/v2/api-docs, and provides basic / default documentation of Greeting Service methods as well as SpringBoot Actuator methods. To prevent other APIs to be documented then restrict the path selection done by Docket with ```paths( PathSelectors.regex( "/ws/rest/.*" ) )```.

**Note**: SpringBoot offers SpringBooot Actuator, which besides health reports it also reports on existing mappings.
