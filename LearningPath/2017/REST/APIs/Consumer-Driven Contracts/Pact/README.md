:: Consumer-Driven Contracts :: Pact ::
=======================================

# Overview

## What is [Pact](https://docs.pact.io/)?

> The Pact family of frameworks provide support for Consumer Driven Contracts testing.

> A Contract is a collection of agreements between a client (Consumer) and an API (Provider) that describes the interactions that can take place between them.
> Consumer Driven Contracts is a pattern that drives the development of the Provider from its Consumers point of view.
> Pact is a testing tool that guarantees those Contracts are satisfied.

[Pact](https://github.com/realestate-com-au/pact) is used to define a pact between service consumers and providers, enabling "consumer driven contract" testing.

The [pact-foundation/pact-specification](https://github.com/pact-foundation/pact-specification) describes the pact format and verification specifications.

## Why use Pact?

There's also a ["convince me"](https://docs.pact.io/faq/convinceme.html) page.

### Pros

> https://docs.pact.io/
- **Confidence**: Continuously evolve your codebase knowing that Pact will guarantee Contracts are met.
- **Faster**: No need to setup end-to-end environments. No need for manual testing.
- **Less Error Prone**: Generation and verification of Contracts are automatically managed by Pact.

### Cons

## How to use Pact?

### Pact Server

### Pact Broker

### Consumer

### Producer

## What are the alternatives?

# Resources

## Articles

- [Simplifying Micro-Service testing with Pacts](http://dius.com.au/2014/05/20/simplifying-micro-service-testing-with-pacts/)
- [Pact 101 – Getting started with Pact and Consumer Driven Contract Testing](http://dius.com.au/2016/02/03/microservices-pact/)
- [Spring Boot Microservices + Pact-JVM](https://github.com/mstine/microservices-pact)
- [Getting started with Pact testing](http://charliegerard.github.io/blog/getting-started-pact-testing/)
- [Consumer driven contract testing using PACT](http://shavo007.github.io/2016/07/19/consumer-driven-contract-testing-using-pact/)
- [Better Testing of Microservices Using Consumer-Driven Contracts in Node.js](http://hecodes.com/2016/10/better-testing-microservices-using-consumer-driven-contracts-node-js/)
- [Consumer Driven Contracts using Pact](http://blog.scottlogic.com/2017/01/10/consumer-driven-contracts-using-pact.html)

## Presentations

- [Verifying Microservice Integrations with Contract Testing - Atlassian Summit 2016](https://www.youtube.com/watch?v=-6x6XBDf9sQ&feature=youtu.be)
- [Pacts to the Rescue](https://www.infoq.com/presentations/pact): Beth Skurrie introduces Pact, a consumer driven contracts testing library useful for creating and executing integration tests on microservices.
- [Move Fast and Consumer Driven Contract Test Things](https://speakerdeck.com/alonpeer/move-fast-and-consumer-driven-contract-test-things)

## Examples / Tutorials

## Tools

- [Pact Mock Service](https://github.com/bethesque/pact-mock_service)
- [Pact::Provider::Proxy](https://github.com/bethesque/pact-provider-proxy)
- [Pacto Provider Proxy](https://github.com/madkom/docker/tree/master/pact-provider-proxy): Docker Image for Pact Provider Proxy.
- [Pact Provider Verification](https://github.com/DiUS/pact-provider-verifier-docker): Docker container to validate Pacts in a language-agnostic manner
- [Swagger Mock Validator](https://bitbucket.org/atlassian/swagger-mock-validator): A CLI tool to validate mocks (either in Swagger or Pact format - includes Pact Broker support) against Swagger specs.
- [Pact Broker](https://github.com/bethesque/pact_broker)
- [Pact Broker Client](https://github.com/bethesque/pact_broker-client)
- [Dockerised Pact Broker](https://github.com/DiUS/pact_broker-docker)
- [ehdez73/docker-pact-broker](https://github.com/ehdez73/docker-pact-broker): Docker-Compose for Pact-Broker
- [shavo007/docker-pact-postgres](https://github.com/shavo007/docker-pact-postgres): Docker container for pact broker postgres and docker compose
- [Shokkenki](https://github.com/brentsnook/shokkenki) records consumer-driven contracts from real examples and uses them to test both ends of a RESTful consumer-provider relationship.

### Java

- [pact-jvm](https://github.com/DiUS/pact-jvm): JVM implementation of the consumer driven contract library Pact.
    - [pact-jvm-consumer-groovy](https://github.com/DiUS/pact-jvm/tree/master/pact-jvm-consumer-groovy)
    - [pact-jvm-consumer-junit](https://github.com/DiUS/pact-jvm/tree/master/pact-jvm-consumer-junit)
    - [pact-jvm-provider-junit](https://github.com/DiUS/pact-jvm/tree/master/pact-jvm-provider-junit)
    - [pact-jvm-provider-maven](https://github.com/DiUS/pact-jvm/tree/master/pact-jvm-provider-maven)
    - [pact-jvm-provider-gradle](https://github.com/DiUS/pact-jvm/tree/master/pact-jvm-provider-gradle)
    - [pact-jvm-provider](https://github.com/DiUS/pact-jvm/tree/master/pact-jvm-provider)
- [pact-jvm-provider-spring-mvc](https://github.com/realestate-com-au/pact-jvm-provider-spring-mvc)
- [warmuuh/pactbroker-maven-plugin](https://github.com/warmuuh/pactbroker-maven-plugin)

### Javascript

- ~~[Pact Consumer Javascript DSL](https://github.com/DiUS/pact-consumer-js-dsl)~~ This project has been superceded by Pact JS and is no longer receiving regular updates.
- ~~[Pact Provider Javascript DSL](https://github.com/DiUS/pact-provider-js-dsl)~~
- [Pact JS](https://github.com/pact-foundation/pact-js): Implementation of the consumer driven contract library Pact for Javascript.
- [Pact Mocha Interface](https://github.com/pact-foundation/pact-js-mocha): Implementation of a Mocha Interface to be used with Pact JS.
- [Pact Mock Service for NPM](https://github.com/pact-foundation/pact-mock-service-npm)
- [Pact Node](https://github.com/pact-foundation/pact-node): An idiomatic Node interface for the Pact mock service (Consumer) and Verification (Provider) process.
- [Node Pact Publisher](https://github.com/alexcu/node-pact-publisher)

# Challenges

## Pact Server

## Pact Broker

## Contract Testing

## Languages

### Java

### Javascript
