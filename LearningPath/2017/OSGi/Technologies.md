:: OSGi :: Technologies ::
==========================

# Framework Implementations

## Oscar

- [Oscar](https://projects.ow2.org/bin/view/oscar-osgi/) is an open source implementation of the Open Services Gateway Initiative (OSGi) framework
- [Oscar Bundle Repository](http://oscar-osgi.sourceforge.net/)

## [Felix](Felix/README.md)

## Equinox

- [Equinox](http://www.eclipse.org/equinox/) is an implementation of the OSGi core framework specification, a set of bundles that implement various optional OSGi services and other infrastructure for running OSGi-based systems. The Equinox OSGi core framework implementation is used as the reference implementation and as such it implements all the required features of the latest OSGi core framework specification.
- [Concierge](http://www.eclipse.org/proposals/rt.concierge/) is an alternative implementation to Equinox of the OSGi core framework and can serve as the sandbox for experimental work on the OSGi core which can later be adopted by Equinox.
- [OSGi: An Introduction](https://www.javacodegeeks.com/2012/01/osgi-introduction.html)
- [Creating an OSGi bundle](http://underlap.blogspot.co.uk/2007/01/creating-osgi-bundle.html)

### Maven

- [Tycho](https://eclipse.org/tycho/) is a set of Maven plugins and extensions for building Eclipse plugins and OSGi bundles with Maven.
- [How to build OSGi bundles using Maven Bundle Plugin - Part 1](http://wso2.com/library/tutorials/develop-osgi-bundles-using-maven-bundle-plugin/)
- [OSGI for Beginners Using Maven with Equinox(HowTo)](https://ashwinrayaprolu.wordpress.com/2011/06/01/osgi-for-beginners-using-maven-with-equinoxhowto/)

## Knopflerfish

- [Knopflerfish](http://www.knopflerfish.org/)

## [Karaf](Karaf/README.md)

## Virgo

- [Dynamic Enterprise Application Platform Project (Virgo)](http://www.eclipse.org/proposals/virgo/)
- [Virgo](http://www.eclipse.org/virgo/) is a completely module-based Java application server that is designed to run enterprise Java applications and Spring-powered applications with a high degree of flexibility and reliability.
- [On OSGi, Spring And Eclipse Virgo](http://www.onegeek.com.au/articles/programming/on-osgi-spring-and-eclipse-virgo)
- [Why dm Server Is Moving To Eclipse](https://jaxenter.com/adrian-colyer-why-dm-server-is-moving-to-eclipse-100111.html)

# Blueprints

- [Spring and OSGi](http://dkacetl.blogspot.co.uk/2016/01/spring-and-osgi.html)
- [Spring-DM, Aries Blueprint and custom namespaces](http://gnodet.blogspot.co.uk/2010/03/spring-dm-aries-blueprint-and-custom.html)
- [Building OSGi applications with the Blueprint Container specification](https://www.ibm.com/developerworks/library/os-osgiblueprint/)
- [Blueprint and Service Dynamism in OSGi](http://javabeat.net/blueprint-and-service-dynamism-in-osgi/)
- [What are the differences between Camel Spring and Blueprint xml configuration?](http://fuseesb.blogspot.co.uk/2014/10/what-is-differences-between-camel.html)

## Spring Dynamic Modules

- [Spring Dynamic Modules reaches 1.0!](https://spring.io/blog/2008/01/25/spring-dynamic-modules-reaches-1-0)
- [Spring Dynamic Modules 1.0 is here](https://spring.io/blog/2008/01/25/spring-dynamic-modules-1-0-is-here) (formerly known as Spring OSGi)
- [Spring Dynamic Modules Reference Guide](http://docs.spring.io/osgi/docs/current/reference/html/)
- [Setting up a project with Spring and OSGi](https://eknet.org/main/dev/spring-dm-example.html)
- [Getting Started with Spring-DM](https://dzone.com/refcardz/getting-started-spring-dm)
- [Let's play with OSGi, Spring and Maven, part 1](https://blog.krecan.net/2008/05/29/lets-play-with-osgi-spring-and-maven-part-1/)
- [Let's play with OSGi, Spring and Maven, part 2](https://blog.krecan.net/2008/06/01/lets-play-with-osgi-spring-and-maven-part-2/)
- [Testing OSGi...Spring Style](https://nofluffjuststuff.com/blog/craig_walls/2009/08/testing_osgi__spring_style)
- [Starting with OSGI with Maven and Spring, and understanding OSGI dependency problems](http://www.integratingstuff.com/2012/07/29/starting-with-osgi-with-maven-and-spring-and-understanding-osgi-dependency-problems/)
- [Osgi Hibernate Spring-DM Sample](http://notehive.com/wp/2008/07/23/osgi-hibernate-spring-dm-sample/)

## Gemini Blueprint

- Eclipse [Gemini Blueprint](http://www.eclipse.org/gemini/blueprint/) is the reference implementation for the OSGi Alliance Blueprint Service (chapter 121 of the OSGi 4.2 Compendium Specification). It was originally called Spring DM (Dynamic Modules) before being donated to Eclipse and becoming Gemini Blueprint.
- [Eclipse Gemini Blueprint 2.0.0 Tutorial](http://www.belaso.de/articles/eclipse-gemini-blueprint-tutorial/)
- [Gemini Blueprint – Converting from Spring OSGi](https://dzone.com/articles/gemini-blueprint-%E2%80%93-converting)
- [How to create blueprints for your OSGi building blocks](http://eclipsesource.com/blogs/2012/08/11/how-to-create-blueprints-for-your-osgi-building-blocks/)
- [Control Your OSGi Application at Runtime](http://eclipsesource.com/blogs/2013/08/05/take-control-of-your-osgi-application-at-runtime/)
- [Moving from Spring to OSGi Blueprint](https://gurke300.gitbooks.io/osgi-with-spring-4-and-hibernate-4/content/moving_from_spring_to_osgi_blueprint/index.html)

## Aires Blueprint

- [Apache Aries](http://aries.apache.org/)
- [Blueprint](http://aries.apache.org/modules/blueprint.html)
- [Blueprint No-OSGi](http://aries.apache.org/modules/blueprintnoosgi.html)
- [Blueprint tutorial](http://aries.apache.org/documentation/tutorials/blueprinthelloworldtutorial.html)
- [The Greeter Tutorial](http://aries.apache.org/documentation/tutorials/greetertutorial.html)

# Tools

## Maven

- [OSGi Bundle Utility for Apache Ant](http://www.jeremias-maerki.ch/wordpress/software/osgi/bundle-utility/)
- [Bndtools](http://njbartlett.name/bndtools_intro.html) is an Eclipse-based development environment for OSGi bundles and applications that focuses on ease of use, rapid development and producing accurate bundle metadata;
    - [Bndtools Tutorial](http://bndtools.org/tutorial.html)
- [Bundle Maven Plugin](http://felix.apache.org/components/bundle-plugin/index.html)
    - [Secrets of The Felix Bundle Plug-in Macros Revealed](https://davidvaleri.wordpress.com/2011/04/07/secrets-of-the-felix-bundle-plug-in-macros-revealed/)
    - [Release an OSGI Bundle into an OBR with Maven](http://www.flexthinker.com/2012/06/release-an-osgi-bundle-into-an-obr-with-maven/)
- [Maven Launchpad Plugin](http://sling.apache.org/site/maven-launchpad-plugin.html)
- [OPS4J - Open Participation for Java](https://github.com/ops4j)
    - [Pax Construct](https://ops4j1.jira.com/wiki/display/paxconstruct/Pax+Construct)
        - [maven-pax-plugin](https://github.com/ops4j/org.ops4j.pax.construct/tree/master/maven-pax-plugin): plugin to help create, manage and provision OSGi projects
        - [Maven Tips and Tricks: Creating an OSGi Project with Maven](http://blog.sonatype.com/2009/09/maven-tips-and-tricks-creating-an-osgi-project-with-maven/)
        - [Generating an OSGi Project with Maven](https://books.sonatype.com/mcookbook/reference/sect-osgi-generate-project.html)
        - [OSGi, Maven, Pax, and web applications](http://leshazlewood.com/2010/09/08/osgi-maven-pax-and-web-applications/)
        - [Pax Construct: From zero to OSGi](http://www.jroller.com/habuma/entry/pax_construct_from_zero_to)
    - [Pax Runner](https://ops4j1.jira.com/wiki/display/paxrunner/Pax+Runner)
        - [Launching OSGi With Pax Runner](http://www.jroller.com/habuma/entry/launching_osgi_with_pax_runner)
        - [Pax Runner Profiles and Distributed OSGi](http://www.jroller.com/habuma/entry/pax_runner_profiles_and_distributed)
        - [Getting started with Pax Runner](https://thecarlhall.wordpress.com/2012/07/10/getting-started-with-pax-unner/)
    - [Pax Cursor](https://ops4j1.jira.com/wiki/display/ops4j/Pax+Cursor) is an Eclipse Plugin that adds Eclipse launch configurations for all platforms / versions supported by Pax Runner. Starting with May 28, 2009 Pax Cursor has been merged into Pax Runner as Pax Runner Plugin for Eclipse.

## Gradle Plugins

- [OSGi Plugin](https://docs.gradle.org/current/userguide/osgi_plugin.html)

# Testing

- [How to test OSGi Applications?](http://javabeat.net/how-to-test-osgi-applications/)
- [OSGi Versioning & Testing](http://www.slideshare.net/caniszczyk/osgi-versioning-and-testingppt)
- [Test-Driven Development with OSGi](https://dzone.com/articles/test-driven-development-osgi)
on-the-fly inside Tests (like in Pax Exam).
- [JUnit4OSGi](http://felix.apache.org/documentation/subprojects/apache-felix-ipojo/apache-felix-ipojo-junit4osgi.html)
    - [Quick Start](http://felix.apache.org/documentation/subprojects/apache-felix-ipojo/apache-felix-ipojo-junit4osgi/apache-felix-ipojo-junit4osgi-tutorial.html)
    - [Executing Unitary and Integration Test on OSGi](http://felix.apache.org/documentation/subprojects/apache-felix-ipojo/apache-felix-ipojo-tools/junit4osgi.html)
    - [Maven-junit4OSGi-plugin](http://felix.apache.org/documentation/subprojects/apache-felix-ipojo/apache-felix-ipojo-junit4osgi/apache-felix-ipojo-junit4osgi-maven.html)
- [The Junit4OSGi - Pax:Exam mix](http://ipojo-dark-side.blogspot.co.uk/2009/05/junit4osgi-paxexam-mix.html)
- [Pax Drone](https://ops4j1.jira.com/wiki/display/ops4j/Pax+Drone) (JUnit 3)
- [Pax Exam](https://ops4j1.jira.com/wiki/display/PAXEXAM4/Pax+Exam) (JUnit 4)
    - [Getting Started with OSGi Tests](https://ops4j1.jira.com/wiki/display/PAXEXAM3/Getting+Started+with+OSGi+Tests)
    - [OSGi Containers](https://ops4j1.jira.com/wiki/display/PAXEXAM3/OSGi+Containers)
    - [Pax Exam - Tutorial 1](https://ops4j1.jira.com/wiki/display/paxexam/Pax+Exam+-+Tutorial+1)
    - [Putting OSGi to the Test with Pax Exam](https://dzone.com/articles/putting-osgi-test-pax-exam)
    - [org.ops4j.pax.exam 1](https://github.com/ops4j/org.ops4j.pax.exam1): 1.x release line of Pax Exam;
    - [org.ops4j.pax.exam 2](https://github.com/tonit/exxam): Next Generation Pax Exam;
    - [org.ops4j.pax.exam 3 and 4](https://github.com/ops4j/org.ops4j.pax.exam2): In-Container Test Framework for OSGi, Java EE and CDI Applications.
    - [Learn-PaxExam](https://github.com/rebaze/Learn-PaxExam)
- [Tinybundles](https://ops4j1.jira.com/wiki/display/ops4j/Tinybundles): is all about creating OSGi related artifacts like Bundles, Fragments and Deployment Packages with Java Api. It is very convinient to create such artifacts

**Notes**:

- JUnit4OSGi is part of iPOJO which is a sub-project of Apache Felix, relies on JUnit 3 (although there's a JIRA issue to support JUnit 4 and TestNG) and runs the tests inside a Felix container;
- Spring-DM (Dynamic Modules) Test is deprecated by Eclipse Gemini, relies on JUnit 3 and uses Equinox by default, although it's possible to switch to Felix or Knopflerfish;
- Pax-Exam 3 or 4 relies on JUnit 4.
