:: REST :: APIs ::
==================

# Overview

## Why document REST APIs?

## How to document REST APIs?

## Why test REST APIs?

## How to test REST APIs?

## What are the differences between Integration Testing and Contract Testing?

# Concepts

## REST API Design / Specification

There are [3 well known REST API Specification formats](http://nordicapis.com/top-specification-formats-for-rest-apis/):

- [Swagger](http://swagger.io/), also known now as [OpenAPI Specification](https://www.openapis.org/), is designed as a bottom-up specification (in JSON or YAML);
- [RAML](http://raml.org/) is a top-down specification, in YAML, meaning that it breaks down the system and explains the behavior of the various sub-components.
- [API Blueprint](https://apiblueprint.org/) is a top-down specification, in Markdown.

There are other options, although not so widely used or with such big companies / communities, such as:

- [Spring REST Docs](http://projects.spring.io/spring-restdocs/)
- [APIDoc](http://www.apidoc.me/doc/)
- [Miredot](http://www.miredot.com/)
- [Slate](https://github.com/lord/slate)

## Documentation Driven Contracts

[Documentation-Driven Contracts](http://thoughtworks.github.io/pacto/patterns/documentation_driven/):
> Documentation-Driven Contracts are another service evolution pattern that may be more appropriate for public APIs or other providers that many consumers. Since establishing a separate contract for each consumer is not practical, the next best thing is to have ensure the documentation accurate reflects the promises made by the service.

## Consumer Driven Contracts

[Consumer-Driven Contracts](http://thoughtworks.github.io/pacto/patterns/cdc/):
> Consumer-Driven Contracts are a pattern for evolving services. In Consumer-Driven Contracts, each consumer captures their expectations of the provider in a separate contract. All of these contracts are shared with the provider so they gain insight into the obligations they must fulfill for each individual client. The provider can create a test suite to validate these obligations. This lets them stay agile and make changes that do not affect any consumer, and pinpoint consumers that will be affected by a required change for deeper planning and discussion.

[What are Consumer Driven Contracts?](http://dius.com.au/2016/02/03/microservices-pact/):
> Consumer Driven Contracts is a pattern or methodology where contracts between inter-dependent services are designed from the perspective of a service consumer. The main article for it is [Consumer-Driven Contracts: A Service Evolution Pattern](http://martinfowler.com/articles/consumerDrivenContracts.html).

## Contract Testing

[Contract Testing](https://martinfowler.com/articles/microservice-testing/#testing-contract-introduction)
> Integration contract tests provide a mechanism to explicitly verify that a component meets a contract. These tests are not component tests. They do not test the behaviour of the service deeply but that the inputs and outputs of service calls contain required attributes and that response latency and throughput are within acceptable limits.

[Consumer-driven contract testing](https://www.thoughtworks.com/radar/techniques/consumer-driven-contract-testing)
> The concept isn’t new, but with the mainstream acceptance of microservices, we need to remind people that consumer-driven contracts are an essential part of a mature microservice testing portfolio, enabling independent service deployments.

[3 reasons for thoroughly testing your APIs](http://www.infoworld.com/article/3030703/apis/3-reasons-for-thoroughly-testing-your-apis.html):
> You can't afford your APIs to not work: your business is relying on them.
- APIs are a behind the scenes story
- It's not even that hard: use the API contract
- Make it part of your software delivery toolchain

## Contract Broker

# Resources

## Books

- [Documenting APIs: A guide for technical writers](http://idratherbewriting.com/learnapidoc/)

## Tutorials

- [Writing OpenAPI (fka Swagger) Specification tutorial](https://apihandyman.io/writing-openapi-swagger-specification-tutorial-part-1-introduction/)
- [Swagger tutorial](https://help.apiary.io/api_101/swagger-tutorial/)
- [RAML 100 Tutorial](http://raml.org/developers/raml-100-tutorial)
- [RAML 200 Tutorial](http://raml.org/developers/raml-200-tutorial)
- [API Blueprint tutorial](https://help.apiary.io/api_101/api_blueprint_tutorial/)

## Examples / Articles

- [Accelerating APIs with continuous delivery](https://www.oreilly.com/ideas/accelerating-apis-with-continuous-delivery)
- [Microservices testing](http://testdetective.com/microservices-testing/)
- [Rest API tooling review](https://opencredo.com/rest-api-tooling-review/)
- [Ultimate Guide to 30+ API Documentation Solutions](http://nordicapis.com/ultimate-guide-to-30-api-documentation-solutions/)
- [Hello World Product API With Blueprint, RAML And Swagger](http://apievangelist.com/2014/03/08/hello-world-product-api-with-blueprint-raml-and-swagger/)

### Swagger

- [Simple workflow for building web service APIs](https://yahooeng.tumblr.com/post/142418165386/simple-workflow-for-building-web-service-apis)
- [Use Swagger to document and define RESTful APIs](https://www.ibm.com/developerworks/library/wa-use-swagger-to-document-and-define-restful-apis/index.html)
- [Write Beautiful REST Documentation with Swagger](http://www.kennethlange.com/posts/Write-Beautiful-REST-Documentation-with-Swagger.html)
- [Documentation of a REST API with Swagger and AsciiDoc](http://www.robwin.eu/documentation-of-a-rest-api-with-swagger-and-asciidoc/)

#### Java / Spring

- [Swagger: make developers love working with your REST API](http://aredko.blogspot.co.uk/2013/09/swagger-make-developers-to-love-working.html)
- [Setting Up Swagger 2 with a Spring REST API](http://www.baeldung.com/swagger-2-documentation-for-spring-rest-api)
- [RESTful API Documentation Using Swagger and Spring MVC](https://www.3pillarglobal.com/insights/restful-api-documentation-using-swagger-and-spring-mvc)
- [Documenting your REST API with Swagger and Springfox](https://g00glen00b.be/documenting-rest-api-swagger-springfox/)

#### Node.js

- [Swagger Test Templates: Test Your APIs](https://apigee.com/about/blog/developer/swagger-test-templates-test-your-apis)
- [Speed up your RESTful API development in Node.js with Swagger](https://scotch.io/tutorials/speed-up-your-restful-api-development-in-node-js-with-swagger)
- [Swagger and NodeJS](http://mherman.org/blog/2016/05/26/swagger-and-nodejs/#.WNjlkm_ytaQ)

### RAML

- [Contract Driven REST Services with Vert.x3](http://vertx.io/blog/contract-driven-rest-services-with-vert-x3/)
- [Testing generic REST APIs with RAML](https://www.insaneprogramming.be/article/2015/09/06/generic-raml-testing/)
- [Design, test and document RESTful APIs using RAML in .NET](https://dusted.codes/design-test-and-document-restful-apis-using-raml-in-dotnet)

### API Blueprint

- [HTTP Documentation with API Blueprint](https://philsturgeon.uk/api/2015/10/08/http-documentation-with-api-blueprint/)
- [No more outdated API documentation!](https://blog.apiary.io/2013/10/10/No-more-outdated-API-documentation)

### Pact

- [Pact 101 – Getting started with Pact and Consumer Driven Contract Testing](http://dius.com.au/2016/02/03/microservices-pact/)
- [Simplifying Micro-Service testing with Pacts](http://dius.com.au/2014/05/20/simplifying-micro-service-testing-with-pacts/)
- [Java Consumer Driven Contract Testing](http://the-creative-tester.github.io/Java-Consumer-Driven-Contract-Testing/)
- [Better Testing of Microservices Using Consumer-Driven Contracts in Node.js](http://hecodes.com/2016/10/better-testing-microservices-using-consumer-driven-contracts-node-js/)
- [Consumer Driven Contracts using Pact](http://blog.scottlogic.com/2017/01/10/consumer-driven-contracts-using-pact.html)
- [Consumer driven contract testing using PACT](http://shavo007.github.io/2016/07/19/consumer-driven-contract-testing-using-pact/)
- [Why you should use Consumer-Driven Contracts for Microservice integration tests](http://techblog.newsweaver.com/why-should-you-use-consumer-driven-contracts-for-microservices-integration-tests/)
- [Microservices: Agreements must be kept](https://jaxenter.com/microservices-agreements-must-be-kept-123129.html)

## Tools

- [Apiary Editor](https://help.apiary.io/tools/apiary-editor/)
- [LucyBot](https://www.lucybot.com/)
    - [LucyBot-Inc/documentation-starter](https://github.com/LucyBot-Inc/documentation-starter)
    - [LucyBot-Inc/api-spec-converter](https://github.com/LucyBot-Inc/api-spec-converter): Convert API descriptions between popular formats such as OpenAPI(fka Swagger), RAML, API Blueprint, WADL, etc.
- [API Spec Transformer](https://github.com/stoplightio/api-spec-converter) helps to convert between different API specifications (Postman, Swagger, RAML, StopLight).
- [test2doc.js](https://github.com/stackia/test2doc.js): Build API docs from your tests, using API Blueprint generator or Swagger generator.
- [Imposter](https://github.com/outofcoffee/imposter): A scriptable, multipurpose mock server.

### Swagger

- [Swagger Core](https://github.com/swagger-api/swagger-core)
- [Swagger-Editor](https://github.com/swagger-api/swagger-editor)
- [Swagger UI](https://github.com/swagger-api/swagger-ui)
- [Swagger Code Generator](https://github.com/swagger-api/swagger-codegen)
- [swaggerapi/swagger-validator](https://hub.docker.com/r/swaggerapi/swagger-validator/)
- [apigee-127/swagger-tools](https://github.com/apigee-127/swagger-tools)
- [Swagger2Markup](https://github.com/Swagger2Markup/swagger2markup): A Swagger to AsciiDoc or Markdown converter
    - [swagger2markup-maven-plugin](https://github.com/Swagger2Markup/swagger2markup-maven-plugin)
    - [swagger2markup-gradle-plugin](https://github.com/Swagger2Markup/swagger2markup-gradle-plugin)
- [ReDoc](https://github.com/Rebilly/ReDoc): OpenAPI/Swagger-generated API Reference Documentation
- [Swagger Confluence](https://cloud.slkdev.net/swagger-confluence/)

#### Java

- [Swagger Request Validator](https://bitbucket.org/atlassian/swagger-request-validator): A Java library for validating HTTP request/responses against a Swagger/OpenAPI specification
    - [swagger-codegen-maven-plugin](https://github.com/garethjevans/swagger-codegen-maven-plugin)
    - [swagger-codegen-gradle-plugin](https://github.com/thebignet/swagger-codegen-gradle-plugin)
- [swagger-maven-plugin](http://kongchen.github.io/swagger-maven-plugin/)
- [SpringFox](https://springfox.github.io/springfox/)
- [Swagger Parser](https://github.com/swagger-api/swagger-parser)
- [assertj-swagger](https://github.com/RobWin/assertj-swagger) is an assertj library which compares a contract-first Swagger YAML/JSON file with a code-first Swagger JSON output. It allows to validate that the API implementation is in compliance with a contract specification for two test patterns: Documentation Driven Contracts and Consumer Driven Contracts.

#### Node.js / Javascript

- [swagger-api/swagger-node](https://github.com/swagger-api/swagger-node)
- [Swagger-JS](https://github.com/swagger-api/swagger-js)
- [Swagger Parser](https://github.com/BigstickCarpet/swagger-parser): Swagger 2.0 parser and validator for Node and browsers
- [swagger-jsdoc](https://github.com/Surnet/swagger-jsdoc)
- [Swagger to JS & Typescript Codegen](https://github.com/wcandillon/swagger-js-codegen)
- [Swagger Test Templates](https://github.com/apigee-127/swagger-test-templates)
- [Swagger Testing](https://github.com/apigee-127/swagger-testing)
- [Specification-driven REST API testing](https://github.com/earldouglas/swagger-test)
- [Got Swag](https://github.com/mobilcom-debitel/got-swag): A tool to test Swagger-powered APIs automatically through monkey testing and custom test suites

### RAML

- [API Designer]()https://github.com/mulesoft/api-designer
- [RAML Client Generator](https://github.com/mulesoft-labs/raml-client-generator)

### API Blueprint

- [Swagger to API Blueprint Converter](https://github.com/apiaryio/swagger2blueprint)
- [Drakov API Blueprint Mock Server](https://github.com/Aconex/drakov)
- ~~[API Blueprint Mock Server](https://bitbucket.org/outofcoffee/api-blueprint-mockserver)~~
- [Aconex/grunt-blueprint-validator](https://github.com/Aconex/grunt-blueprint-validator): Validates Blueprint files

### Testing

- [Behaviour driven REST API development with Spring](http://www.talangsoft.org/2015/03/02/bdd-spring-restapi/)
- [Chakram](http://dareid.github.io/chakram/) is a REST API testing framework offering a BDD testing style and fully exploiting promises.
- [Consumer Contracts](https://bbc.github.io/consumer-contracts/) lets you write executable contracts in JavaScript.
- [dev-contract-tester](https://github.com/gurpreet-hanjra/dev-contract-tester)
- [Dredd](https://github.com/apiaryio/dredd): Dredd is a language-agnostic command-line tool for validating API description document (either Swagger or API Blueprint format) against backend implementation of the API.
- [Abao](https://github.com/cybertk/abao) is a command-line tool for testing API documentation written in RAML format against its back-end implementation.
- [Vigia](https://github.com/nogates/vigia): Adaptable API integration test suite that supports API blueprint and RAML files.
- [Spring Cloud Contract](https://github.com/spring-cloud/spring-cloud-contract)
- ~~[Pacto](http://thoughtworks.github.io/pacto/)~~
- [Pact](Consumer-Driven Contracts/Pact/README.md)

# Challenges

## Contract Design / Specification

### Documentation Driven Contracts (external public service)

### Consumer Driven Contracts (internal / microservices)

## Code Generation

### Server Side

### Client Side

## Contract Testing
