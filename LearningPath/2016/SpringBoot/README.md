﻿:: Dojo :: Java :: Spring Boot ::
=================================

----

# 1. Introduction

> [Spring Boot](http://projects.spring.io/spring-boot/) takes an opinionated view of building production-ready Spring applications. It favours convention over configuration and is designed to get you up and running as quickly as possible.

> Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run". We take an opinionated view of the Spring platform and third-party libraries so you can get started with minimum fuss. Most Spring Boot applications need very little Spring configuration.

[Exploring Micro-frameworks: Spring Boot](https://www.infoq.com/articles/microframeworks1-spring-boot):

> Spring Boot is a brand new framework from the team at Pivotal, designed to simplify the bootstrapping and development of a new Spring application. The framework takes an opinionated approach to configuration, freeing developers from the need to define boilerplate configuration. In that, Boot aims to be a front-runner in the ever-expanding rapid application development space.

> In pursuit of such an improved development experience, Spring Boot - and, indeed, the entire Spring ecosystem - has embraced the [Groovy](http://www.groovy-lang.org/) programming language.

## 1.1. Goal & Objectives

The goal is to quickly become productive in working with Spring Boot.

The objectives are to understand what main benefits arise from working with Spring Boot, how it works from a high-level perspective and what possibilities does it offer to Java and Groovy projects ( or usual Spring-based applications ).
 
## 1.2. Audience

This dojo is aimed for programmers that know Java and Maven or Gradle but have not yet had used Spring Boot.

## 1.3. History

[Should You Use Spring Boot in Your Next Project?](https://steveperkins.com/use-spring-boot-next-project/)

> Innovative drive never ceased among SpringSource developers themselves. In 2011, they introduced Spring Roo, a rapid development system inspired by the Rails command line tool. Roo allows developers to quickly bootstrap a new Spring application, and create elements such as web controllers or JPA entities through a comand-line console.

> However, for non-trivial use, the learning curve is almost as steep as building an application by hand. Perhaps even more so, since you still need to understand the underlying elements. Many developers were put off by the annotations and AspectJ files that Roo litters throughout your codebase to perform its magic. Although Roo is advertised as being easy to remove once you’re up and running, the reality is that removal is a major and tedious undertaking. Moreover, once you do convert the AspectJ stuff to plain Java, you lose the ability to use the magic command line tool. Roo is an interesting system created by talented developers, but never really caught on.

> Spring Boot is the next-generation attempt at easy Spring setup. There is an optional command-line tool of sorts, for testing small prototypes written in Groovy. However, Spring Boot is not an automatic code generation tool. Rather, it’s essentially a plugin for your build system (Maven and Gradle are supported).

## 1.4. Features

- Create stand-alone Spring applications;
- Embed Tomcat, Jetty or Undertow directly (no need to deploy WAR files);
- Provide opinionated 'starter' POMs to simplify your Maven configuration;
- Automatically configure Spring whenever possible;
- Provide production-ready features such as metrics, health checks and externalized configuration;
- Absolutely no code generation and no requirement for XML configuration.

> At its most fundamental level, Spring Boot is little more than a set of libraries that can be leveraged by any project’s build system. As a convenience, the framework also offers a command-line interface, which can be used to run and test Boot applications.

> [Spring Boot Starters](https://github.com/spring-projects/spring-boot/tree/master/spring-boot-starters) are a set of convenient dependency descriptors that you can include in your application. You get a one-stop-shop for all the Spring and related technology that you need without having to hunt through sample code and copy paste loads of dependency descriptors.

## 1.5. Requirements

By default, Spring Boot requires Java 7 and Spring Framework 4.3.2 or above. Explicit build support is provided for Maven (3.2+) and Gradle (1.12+).

## 1.6. Articles

- [Why SpringBoot?](http://sivalabs.in/2016/03/why-springboot/)
- [How SpringBoot AutoConfiguration magic works?](http://sivalabs.in/2016/03/how-springboot-autoconfiguration-magic/)
- [Exploring Micro-frameworks: Spring Boot](https://www.infoq.com/articles/microframeworks1-spring-boot)
- Building microservices with Spring Boot:
  - [Part 1](https://plainoldobjects.com/2014/04/01/building-microservices-with-spring-boot-part1/)
  - [Part 2](https://plainoldobjects.com/2014/05/05/building-microservices-with-spring-boot-part-2/)
  - [Part 3](https://plainoldobjects.com/2014/11/16/deploying-spring-boot-based-microservices-with-docker/)
- [Spring Boot Framework In A Nutshell](http://www.journaldev.com/8611/spring-boot-framework-ina-nutshell)
- [Spring Boot Tutorial](http://www.journaldev.com/7969/spring-boot-tutorial)
- [Spring Boot Tutorial for beginners](https://examples.javacodegeeks.com/enterprise-java/spring/boot/spring-boot-tutorial-beginners/)
- [Spring Boot Complete Guide](http://javabeat.net/spring-boot/)
- [Complete Guide for Spring Boot Actuator](http://javabeat.net/spring-boot-actuator/)
- [Experiences with Spring Boot](https://opencredo.com/experiences-with-spring-boot/)

----

# 2. Milestones

## 2.1. CLI: Hello World

## 2.2. JAX-RS: Hello World

## 2.3. JAX-WS: Hello World