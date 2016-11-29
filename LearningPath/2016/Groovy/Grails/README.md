:: Groovy :: Grails ::
======================

# Overview

> [Grails](https://en.wikipedia.org/wiki/Grails_(framework)) is an open source web application framework that uses the Apache Groovy programming language (which is in turn based on the Java platform). It is intended to be a high-productivity framework by following the "coding by convention" paradigm, providing a stand-alone development environment and hiding much of the configuration detail from the developer. Grails was previously known as "Groovy on Rails"; in March 2006 that name was dropped in response to a request by David Heinemeier Hansson, founder of the Ruby on Rails framework.

> Grails was developed to address a number of goals:
- Provide a web framework for the Java platform;
- Re-use existing Java technologies such as Hibernate and Spring under a single interface;
- Offer a consistent development framework;
- Offer documentation for key portions of the framework:
    - The Persistence framework;
    - Templates using GSP (Groovy Server Pages);
    - Dynamic tag libraries for creating web page components;
    - Customizable and extensible Ajax support.
- Provide sample applications that demonstrate the framework;
- Provide a complete development mode, including a web server and automatic reload of resources.

> Grails has three properties that differentiate it from traditional Java web frameworks:
- No XML configuration;
- Ready-to-use development environment;
- Functionality available through mixins.

## Goal & Objectives

Learn how to use Grails.

## Audience

The target audience are Java or Groovy programmers that want to learn about an integrated and highly productive environment for creating web applications.

## History

## Scope

# Resources

- [Grails](https://grails.org/) is a powerful web framework, for the Java platform aimed at multiplying developers’ productivity thanks to a Convention-over-Configuration, sensible defaults and opinionated APIs. It integrates smoothly with the JVM, allowing you to be immediately productive whilst providing powerful features, including integrated ORM, Domain-Specific Languages, runtime and compile-time meta-programming and Asynchronous programming.
    - [grails-core](https://github.com/grails/grails-core): Grails Web Application Framework is a framework used to build web applications with the Groovy programming language. The core framework is very extensible and there are numerous plugins available that provide easy integration of add-on features.
    - [Learn](https://grails.org/learn.html)
- [Groovy/Grails Tool Suite](https://spring.io/tools/ggts/all)

## Tutorials

- [Grails Tutorial for Beginners](http://grails.asia/grails-tutorial-for-beginners/)
- [Introduction to the Grails Web Framework](https://netbeans.org/kb/docs/web/grails-quickstart.html) in NetBeans IDE
- [Grails Development - Tutorial](http://www.vogella.com/tutorials/Grails/article.html)
- [Grails tutorial for beginners](https://examples.javacodegeeks.com/jvm-languages/groovy/grails/grails-tutorial-for-beginners/)
- [Grails MVC Tutorial](http://javabeat.net/grails-mvc-tutorial/)

## Articles

- [Mastering Grails: Build your first Grails application](http://www.ibm.com/developerworks/java/library/j-grails01158/index.html)
- [Grails 3 Project Structure Tutorial](http://grails.asia/grails-3-project-structure-tutorial)
- [mrhaki](http://mrhaki.blogspot.co.uk/search/label/Grails)
- [Grails Goodness: Changing Gradle Version](http://mrhaki.blogspot.co.uk/2016/01/grails-goodness-changing-gradle-version.html)
- [Grails Goodness: Run Grails Application As Docker Container](http://mrhaki.blogspot.co.uk/2015/10/grails-goodness-run-grails-application.html)
- [Grails Best Practices](https://www.infoq.com/articles/grails-best-practices)
- [Grails Design Best Practices](https://techmytalk.com/2013/04/01/groovy-grails-design-best-practices-2/)
- [Grails Key Architecture Considerations](https://techmytalk.com/2013/03/19/groovy-grails-architecture-best-practices-2/)
- [Groovy & Grails Understanding – Part 1](https://techmytalk.com/2013/04/12/groovy-understanding/)
- [Groovy & Grails Understanding – Part 2](https://techmytalk.com/2013/04/14/groovy-grails-understanding-part2/)
- [Grails – RESTful Webservice using JAX-RS plugin](https://techmytalk.com/2013/06/29/grails-restful-webservive-using-jax-rs-plugin/)
- [SOA and REST with Grails](https://techmytalk.com/2013/08/05/soa-and-rest-with-grails/)

## Books

- [Beginning Groovy and Grails: From Novice to Professional 1st Edition](https://www.amazon.com/Beginning-Groovy-Grails-Novice-Professional/dp/1430210451)
- [Grails 2: A Quick-Start Guide 1st Edition](https://www.amazon.com/gp/product/1937785777?tag=misa09-20)
- [The Definitive Guide to Grails 2](http://www.apress.com/us/book/9781430243779)
- [Grails in Action, 2nd Edition](https://www.manning.com/books/grails-in-action-second-edition)
- [Programming Grails](http://shop.oreilly.com/product/0636920024750.do)
- [Grails Goodness Notebook](https://leanpub.com/grails-goodness-notebook)
- [Falando de Grails](https://www.casadocodigo.com.br/products/livro-grails)
- [Grails 3: A Practical Guide to Application Development](https://www.grails3book.com/)

## Tools

- [SDKMAN!](http://sdkman.io/) is a tool for managing parallel versions of multiple Software Development Kits on most Unix based systems. Formerly known as GVM the Groovy enVironment Manager, it was inspired by the very useful RVM and rbenv tools.
    - [sdkman-cli](https://github.com/sdkman/sdkman-cli): the SDKMAN! Command Line Interface
- [posh-gvm](https://github.com/flofreud/posh-gvm): the POwerSHell Groovy enVironment Manager;
- [grails-boot](https://github.com/grails/grails-boot): Grails integrations with Spring Boot;
- [Grails Maven Plugin](https://github.com/grails/grails-maven)
- [grails-maven-archetype](https://github.com/grails/grails-maven-archetype)
- [gradle-docker-plugin](https://github.com/bmuschko/gradle-docker-plugin): Gradle plugin for managing Docker images and containers.
- [grails-cargo-deploy](https://github.com/aaronzirbes/grails-cargo-deploy)
- [Tomcat Grails Plugin](https://github.com/grails-plugins/grails-tomcat-plugin)

## Examples

# Milestones

## Installation

- Uncompress Grails;
- Configure Environment Variables:
    - GRAILS_HOME
    - GRAILS_GRADLE_HOME: to enable using a different version of Gradle instead of the one distributed with Grails.
- Add Grails to the path.

Execute the following command to validate installation:

```bash
grails --version
```

## Hello World
