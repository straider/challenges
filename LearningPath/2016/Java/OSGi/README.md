:: OSGi ::
==========

# Overview

> The [OSGi Alliance](https://www.osgi.org/) is a worldwide consortium of technology innovators that advances a proven and mature process to create open specifications that enable the modular assembly of software built with Java technology. Modularity reduces software complexity; OSGi is the best model to modularize Java.

> The OSGi Alliance, formerly known as the Open Services Gateway initiative, is an open standards organization founded in March 1999 that originally specified and continues to maintain the OSGi standard. The [OSGi](https://en.wikipedia.org/wiki/OSGi) specification describes a modular system and a service platform for the Java programming language that implements a complete and dynamic component model, something that does not exist in standalone Java VM environments. Applications or components, coming in the form of bundles for deployment, can be remotely installed, started, stopped, updated, and uninstalled without requiring a reboot; management of Java packages/classes is specified in great detail. Application life cycle management is implemented via APIs that allow for remote downloading of management policies. The service registry allows bundles to detect the addition of new services, or the removal of services, and adapt accordingly.

> [OSGi (Open Service Gateway Initiative)](http://searchnetworking.techtarget.com/definition/OSGi) (Open Service Gateway Initiative) is a Java framework for developing and deploying modular software programs and libraries. OSGi has two parts:
- The first part is a specification for modular components called bundles, which are commonly referred to as plug-ins. The specification defines an infrastructure for a bundle's life cycle and determines how bundles will interact;
- The second part of OSGi is a Java Virtual Machine (JVM)-level service registry that bundles can use to publish, discover and bind to services in a service-oriented architecture.

> [A simple answer](http://stackoverflow.com/a/106263): An OSGi Service Platform provides a standardized, component-oriented computing environment for cooperating networked services. This architecture significantly reduces the overall complexity of building, maintaining and deploying applications. The OSGi Service Platform provides the functions to change the composition dynamically on the device of a variety of networks, without requiring a restarts.

## Questions

### What is it?

- It's a module system for Java
- Includes visibility rules, dependency management and versioning of OSGi "bundles" (modules);
- It's fully dynamic: Installing, starting, stopping, updating, uninstalling bundles, all done dynamically at runtime;
- It's service oriented (always has been …): all services are registered in a service registry, available in the well-understood publish, find and bind pattern, again all done dynamically at runtime.

### Why use it?

- Reduced Footprint
- Improved Extensibility
- Improved Serviceability and Availability
- OSGi for Simplicity:
    - Framework for modularity - avoids classpath JAR file hell;
    - Package/Use/Deploy/Stop just what you need;
    - Reduced footprint means reduced TCO;
    - Reuse modular code *out of the box*;
    - Simplifies third-party module integration;
    - Simplifies lifecycle and dependency management;
    - Manages deployments locally or remotely;
    - Enables smaller, distributed, and diverse teams;
    - Extensive tool support to hide complexity.
- OSGi for Flexibility:
    - No lock in, many providers of core technology including many open source;
    - Install, start, stop, update, uninstall bundles, all dynamically at runtime means new features can be added or stopped dynamically for rapid adaptability;
    - Users can run multiple versions of the same module in the same application;
    - Users can implement their own bundles to extend product capabilities without breaking existing functionality.
- OSGi for Stability:
    - Deploy only what you need, reducing complexity, and improving stability;
    - Set-up visibility rules, dependency management and versioning at the bundle level for ease of deployment, scalability and serviceability;
    - Ability to run multiple versions simultaneously to test effects and minimize risk of upgrades;
    - Enables zero-downtime patch/upgrades;
    - Service registry provides control and predictability of interactions across modules;
    - Fully integrated with security architecture.

[Benefits of Using OSGi](https://www.osgi.org/developer/benefits-of-using-osgi/)
> The OSGi modular and dynamic model reduces operational costs and integrates multiple devices in a networked environment, tackling costly application development, maintenance and remote service management.

### How to use it?

## Scope

## History

> The OSGi Alliance was founded by Ericsson, IBM, Motorola, Sun Microsystems and others in March 1999. Before incorporating as a nonprofit corporation it was called the Connected Alliance.

- OSGi Release 1 (R1): May 2000
- OSGi Release 2 (R2): October 2001
- OSGi Release 3 (R3): March 2003
- OSGi Release 4 (R4): October 2005 / September 2006
    - Core Specification (R4 Core): October 2005
    - Mobile Specification (R4 Mobile / JSR-232): September 2006
- OSGi Release 4.1 (R4.1): May 2007 (AKA JSR-291)
- OSGi Release 4.2 (R4.2): September 2009
    - Enterprise Specification (R4.2): March 2010
- OSGi Release 4.3 (R4.3): April 2011
    - Core: April 2011
    - Compendium and Residential: May 2012
- OSGi Release 5 (R5): June 2012
    - Core and Enterprise: June 2012
- OSGi Release 6 (R6): June 2015
    - Core: June 2015

## Resources

### Tutorials

- [Quick Start Tutorial](http://enroute.osgi.org/qs/050-start.html)
- [Base Tutorial](http://enroute.osgi.org/tutorial_base/050-start.html)
- [Distributed OSGi Tutorial](http://enroute.osgi.org/tutorial_rsa/050-start.html)
- [Creating OSGi bundles](https://spring.io/blog/2008/02/18/creating-osgi-bundles/)
- [OSGi: An Introduction](https://www.javacodegeeks.com/2012/01/osgi-introduction.html)
- [OSGi and Spring Dynamic Modules – Simple Hello World](https://www.javacodegeeks.com/2011/11/osgi-and-spring-dynamic-modules-simple.html)
- [OSGi Tutorial: From project structure to release](http://blog.knowhowlab.org/2010/06/osgi-tutorial-from-project-structure-to.html)

### Articles

- [OSGi (Open Service Gateway Initiative)](http://searchnetworking.techtarget.com/definition/OSGi)
- [Best practices for OSGi development in enterprise Java integration](http://searchsoa.techtarget.com/tip/Best-practices-for-OSGi-development-in-enterprise-Java-integration)
- [Best practices for developing and working with OSGi applications](http://www.ibm.com/developerworks/websphere/techjournal/1007_charters/1007_charters.html)
- [OSGi and The Rise of The Stackless Stack: Just in Time](http://redmonk.com/jgovernor/2008/02/05/osgi-and-the-rise-of-the-stackless-stack-just-in-time/)
- [OSGi plugs along](http://www.javaworld.com/article/2073293/osgi-plugs-along.html)
- [Cloud & OSGi - Beyond the VM](http://www.slideshare.net/mfrancis/paremus-cloud-and-osgi-beyond-the-vm-osgi-cloud-workshop-march-2012)
- [Cloud and OSGi @ eBay](http://www.slideshare.net/mfrancis/cloud-and-osgi-at-ebay-osgi-cloud-workshop-march-2012)
- [Eclipse Gyrex OSGi based PaaS-Like Programming Stack](http://www.slideshare.net/mfrancis/eclipse-gyrex-osgi-based-paas-like-os-gi-cloud-workshop-march-2012)
- [Java 9, OSGi and the Future of Modularity (Part 1)](https://www.infoq.com/articles/java9-osgi-future-modularity)
- [Java 9, OSGi and the Future of Modularity (Part 2)](https://www.infoq.com/articles/java9-osgi-future-modularity-part-2)
- [OSGi leads application development into the future](http://www.theserverside.com/news/1280100062/OSGi-leads-application-development-into-the-future)
- [OSGi - the next big thing? (a beginner's view)](http://seewah.blogspot.co.uk/2009/05/osgi-next-big-thing-beginners-view.html)
- [All we need to do is take these lies and make them true (somehow)](http://web.archive.org/web/20091023053049/http://www.tensegrity.hellblazer.com/2009/10/all-we-need-to-do-is-take-these-lies-and-make-them-true-somehow.html)

### Books

- [Building Modular Cloud Apps with OSGi](http://shop.oreilly.com/product/0636920028086.do)
- [OSGi in Depth](https://www.manning.com/books/osgi-in-depth)
- [OSGi in Action](https://www.manning.com/books/osgi-in-action)
- [Enterprise OSGi In Action](https://www.manning.com/books/enterprise-osgi-in-action)
- [OSGi and Equinox: Creating Highly Modular Java Systems](https://www.informit.com/store/osgi-and-equinox-creating-highly-modular-java-systems-9780321585714)
- [OSGi in Practice](http://njbartlett.name/osgibook.html)
- [Modular Java - Creating Flexible Applications with OSGi and Spring](https://pragprog.com/book/cwosg/modular-java)
- [Pro Spring Dynamic Modules for OSGi Service Platforms](http://www.apress.com/us/book/9781430216124)
- [OSGi and Equinox: Creating Highly Modular Java Systems](https://www.amazon.com/OSGi-Equinox-Creating-Modular-Systems/dp/0321585712)

# Architecture

[Architecture](https://www.osgi.org/developer/architecture/)
> The OSGi technology is a set of specifications that define a dynamic component system for Java. These specifications enable a development model where applications are (dynamically) composed of many different (reusable) components. The OSGi specifications enable components to hide their implementations from other components while communicating through services, which are objects that are specifically shared between components. This surprisingly simple model has far reaching effects for almost any aspect of the software development process.

> The OSGi has a layered model and the following list contains a short definition of the terms:
- Bundles: Bundles are the OSGi components made by the developers;
- Services: The services layer connects bundles in a dynamic way by offering a publish-find-bind model for plain old Java objects;
- Life-Cycle: The API to install, start, stop, update, and uninstall bundles;
- Modules: The layer that defines how a bundle can import and export code;
- Security: The layer that handles the security aspects;
- Execution Environment: Defines what methods and classes are available in a specific platform.

## Bundles

> Bundles are normal jar components with extra manifest headers. A bundle is a group of Java classes and additional resources equipped with a detailed manifest MANIFEST.MF file on all its contents, as well as additional services needed to give the included group of Java classes more sophisticated behaviors, to the extent of deeming the entire aggregate a component.

## Services

> The services layer connects bundles in a dynamic way by offering a publish-find-bind model for Plain Old Java Interfaces (POJI) or Plain Old Java Objects (POJO). The OSGi Alliance has specified many services. Services are specified by a Java interface. Bundles can implement this interface and register the service with the Service Registry. Clients of the service can find it in the registry, or react to it when it appears or disappears.

### OSGi System Services

### OSGi Protocol Services

### OSGi Miscellaneous Services

## Service Registry

> It is the application programming interface for management services (ServiceRegistration, ServiceTracker and ServiceReference).

## Life-Cycle

> The application programming interface for life cycle management (install, start, stop, update, and uninstall) for bundles. A Life Cycle layer adds bundles that can be dynamically installed, started, stopped, updated and uninstalled. Bundles rely on the module layer for class loading but add an API to manage the modules in run time. The life cycle layer introduces dynamics that are normally not part of an application. Extensive dependency mechanisms are used to assure the correct operation of the environment. Life cycle operations are fully protected with the security architecture.

### Bundle States

| Bundle State | Description |
|--------------|-------------|
| Installed    | The bundle has been successfully installed. |
| Resolved     | All Java classes that the bundle needs are available. This state indicates that the bundle is either ready to be started or has stopped. |
| Starting     | The bundle is being started, the BundleActivator.start method has been called but the start method has not yet returned. |
| Active       | The bundle has been successfully activated and is running; its Bundle Activator start method has been called and returned. |
| Stopping     | The bundle is being stopped. The BundleActivator.stop method has been called but the stop method has not yet returned. |
| Uninstalled  | The bundle has been uninstalled. It cannot move into another state. |

**Note**: When the bundle has an activation policy, the bundle will remain in the STARTING state until the bundle is activated according to its activation policy.

## Modules

> The layer that defines encapsulation and declaration of dependencies (how a bundle can import and export code).

## Security

> The layer that handles the security aspects by limiting bundle functionality to pre-defined capabilities.

## Execution Environment

> Defines what methods and classes are available in a specific platform.

# Projects

## Framework Implementations

### Felix

- [Apache Felix](http://felix.apache.org/)  is a community effort to implement the OSGi Framework and Service platform and other interesting OSGi-related technologies under the Apache license.
- [Apache Felix OSGi Tutorial](http://felix.apache.org/documentation/tutorials-examples-and-presentations/apache-felix-osgi-tutorial.html)
- [OSGi – Simple Hello World with services](https://www.javacodegeeks.com/2011/11/osgi-simple-hello-world-with-services.html)

### Equinox

- [Equinox](http://www.eclipse.org/equinox/) is an implementation of the OSGi core framework specification, a set of bundles that implement various optional OSGi services and other infrastructure for running OSGi-based systems. The Equinox OSGi core framework implementation is used as the reference implementation and as such it implements all the required features of the latest OSGi core framework specification.
- [Tutorial: Using REST and OSGi Standards for Micro Services](https://wiki.eclipse.org/Tutorial:_Using_REST_and_OSGi_Standards_for_Micro_Services)
- [Tutorial: Exposing a Jax REST service as an OSGi Remote Service](https://wiki.eclipse.org/Tutorial:_Exposing_a_Jax_REST_service_as_an_OSGi_Remote_Service)
- [OSGi Component Programming](https://github.com/osgi/eclipsecon/tree/master/2006/tutorial)
- [OSGi Modularity - Tutorial](http://www.vogella.com/tutorials/OSGi/article.html)
- [OSGi Services - Tutorial](http://www.vogella.com/tutorials/OSGiServices/article.html)
- [OSGi Using Maven with Equinox](https://www.javacodegeeks.com/2011/06/osgi-using-maven-equinox.html)
- [Hello, OSGi, Part 1: Bundles for beginners](http://www.javaworld.com/article/2077837/java-se/java-se-hello-osgi-part-1-bundles-for-beginners.html)
- [Hello, OSGi, Part 2: Introduction to Spring Dynamic Modules](http://www.javaworld.com/article/2077853/java-se/java-se-hello-osgi-part-2-introduction-to-spring-dynamic-modules.html)
- [OSGi for Beginners](http://www.theserverside.com/news/1363825/OSGi-for-Beginners)
- [Creating an OSGi bundle](http://underlap.blogspot.co.uk/2007/01/creating-osgi-bundle.html)

### Knopflerfish

- [Knopflerfish](http://www.knopflerfish.org/)

### Karaf

- [Karaf](http://karaf.apache.org/)
- [Karaf Tutorials](http://liquid-reality.de/display/liquid/Karaf+Tutorials)
- [Creating OSGI bundles and services from the ground up using Apache Karaf](http://kevinboone.net/osgitest.html)
- [Dynamic configuration of OSGi bundles running on Apache Karaf, from the ground up](http://kevinboone.net/osgitest2.html)
- [Implementing an Apache Camel route in an OSGi Java bundle from the ground up](http://kevinboone.net/karafcameltest.html)
- [Implementing an Apache Camel route in an OSGi Java bundle using Maven from the ground up](http://kevinboone.net/camelosgimaventest.html)
- [Creating a plugin system with Karaf and OSGi µServices](https://blog.doubleslash.de/creating-a-plugin-system-with-karaf-and-osgi-%C2%B5services/)
- [Combining Karaf Features, PAX URL, and Maven to deploy a plain JAR as an OSGi bundle](https://davidvaleri.wordpress.com/2010/08/13/combining-karaf-features-pax-url-and-maven-to-deploy-a-plain-jar-as-an-osgi-bundle/)
- [Integration Testing OSGi Bundles in Apache Karaf/ServiceMix with Pax Exam 3](https://davidvaleri.wordpress.com/2013/09/17/integration-testing-osgi-bundles-in-apache-karafservicemix-with-pax-exam-3/)
- [Implementing a Web Service using CXF in an OSGi bundle](http://kevinboone.net/suntimes_ws.html)
- [RESTful web-services in OSGi container: meet Karaf and CXF](http://deemson.blogspot.co.uk/2013/09/restful-web-services-in-osgi-container.html)
- [Building CXF REST service in OSGi for Karaf](http://rerun.me/2013/09/01/building-cxf-rest-service-in-osgi-for-karaf/)
- [Building Camel-CXF REST Service in OSGi for Karaf – Multicasting and Aggregation](http://rerun.me/2013/10/20/building-camel-cxf-rest-service-in-osgi-for-karaf-multicasting-and-aggregation/)
- [Understand OSGI Bundle Build And Deployment](http://ggl-consulting.blogspot.co.uk/2014/02/understand-osgi-bundle-build-and.html)
- [OSGi Bundle Using Blueprint Dymisfied](http://ggl-consulting.blogspot.co.uk/2014/02/osgi-bundle-using-blueprint-dymisfied.html)
- [Create Apache Camel OSGi Bundle Maven Project From Scratch](http://ggl-consulting.blogspot.co.uk/2014/02/create-apache-camel-osgi-bundle-maven.html)
- [Develop RESTful Web Service Using Camel-CXF As OSGi bundle](http://ggl-consulting.blogspot.co.uk/2014/03/develop-restful-web-service-using-camel.html)
- [Develop SOAP Web Service As OSGi Bundle With Camel-CXF](http://ggl-consulting.blogspot.co.uk/2014/03/develop-soap-web-service-as-osgi-bundle.html)
- [Step by Step: How to bring JAX-RS and OSGi together](http://eclipsesource.com/blogs/2014/02/04/step-by-step-how-to-bring-jax-rs-and-osgi-together/)
- [Developing a REST Service in Apache Karaf](http://www.modio.io/developing-a-rest-service-in-apache-karaf-part-1/)
- [Web Applications with OSGi – Static Files](https://vzurczak.wordpress.com/2014/09/30/web-applications-with-osgi-static-files/)
- [Web Applications with OSGi – Working with Jersey](https://vzurczak.wordpress.com/2014/09/30/web-applications-with-osgi-working-with-jersey/)
- [Web Applications with OSGi – Working with Jersey and iPojo](https://vzurczak.wordpress.com/2014/09/30/web-applications-with-osgi-working-with-jersey-and-ipojo/)

## Blueprints

- [JAX-RS applications in OSGi – whiteboard style](http://www.jeremias-maerki.ch/wordpress/2011/08/20/jaxrs-applications-in-osgi-whiteboard-style/)
- [Deploying Apache CXF services using Whiteboard Pattern in OSGi Container](https://nadirsaghar.wordpress.com/2013/07/31/deploying-apache-cxf-services-using-whiteboard-pattern-in-osgi-container/)
- [Building OSGi applications with the Blueprint Container specification](https://www.ibm.com/developerworks/library/os-osgiblueprint/)

### Spring Dynamic Modules

- [Spring Dynamic Modules reaches 1.0!](https://spring.io/blog/2008/01/25/spring-dynamic-modules-reaches-1-0)
- [Spring Dynamic Modules 1.0 is here](https://spring.io/blog/2008/01/25/spring-dynamic-modules-1-0-is-here) (formerly known as Spring OSGi)
- [Spring Dynamic Modules Reference Guide](http://docs.spring.io/osgi/docs/current/reference/html/)
- [Moving from Spring to OSGi Blueprint](https://gurke300.gitbooks.io/osgi-with-spring-4-and-hibernate-4/content/moving_from_spring_to_osgi_blueprint/index.html)

### Gemini Blueprint

- Eclipse [Gemini Blueprint](http://www.eclipse.org/gemini/blueprint/) is the reference implementation for the OSGi Alliance Blueprint Service (chapter 121 of the OSGi 4.2 Compendium Specification). It was originally called Spring DM (Dynamic Modules) before being donated to Eclipse and becoming Gemini Blueprint.
- [Eclipse Gemini Blueprint 2.0.0 Tutorial](http://www.belaso.de/articles/eclipse-gemini-blueprint-tutorial/)
- [Gemini Blueprint – Converting from Spring OSGi](https://dzone.com/articles/gemini-blueprint-%E2%80%93-converting)
- [How to create blueprints for your OSGi building blocks](http://eclipsesource.com/blogs/2012/08/11/how-to-create-blueprints-for-your-osgi-building-blocks/)
- [Control Your OSGi Application at Runtime](http://eclipsesource.com/blogs/2013/08/05/take-control-of-your-osgi-application-at-runtime/)

### Aires Blueprint

- [Apache Aries](http://aries.apache.org/)
- [Blueprint](http://aries.apache.org/modules/blueprint.html)
- [Blueprint No-OSGi](http://aries.apache.org/modules/blueprintnoosgi.html)
- [Blueprint tutorial](http://aries.apache.org/documentation/tutorials/blueprinthelloworldtutorial.html)
- [The Greeter Tutorial](http://aries.apache.org/documentation/tutorials/greetertutorial.html)
- [Apache CXF and Aries Blueprint Everywhere](http://sberyozkin.blogspot.co.uk/2015/10/apache-cxf-and-aries-blueprint.html)
- [Creating a CXF REST service with Camel Blueprint](https://capgemini.github.io/development/creating-a-cxf-restful-service-in-camel-blueprint/)

## Maven Plugins

- [Bndtools](http://njbartlett.name/bndtools_intro.html) is an Eclipse-based development environment for OSGi bundles and applications that focuses on ease of use, rapid development and producing accurate bundle metadata;
    - [Bndtools Tutorial](http://bndtools.org/tutorial.html)
- [Bundle Maven Plugin](http://felix.apache.org/components/bundle-plugin/index.html)
    - [Secrets of The Felix Bundle Plug-in Macros Revealed](https://davidvaleri.wordpress.com/2011/04/07/secrets-of-the-felix-bundle-plug-in-macros-revealed/)
- [Do you know the Apache Karaf Maven plugins?](http://blog.nanthrax.net/2011/12/do-you-know-the-apache-karaf-maven-plugins/)
- [OSGi Bundle Utility for Apache Ant](http://www.jeremias-maerki.ch/wordpress/software/osgi/bundle-utility/)

## Testing

### Pax Exame

- [Pax Exam](https://ops4j1.jira.com/wiki/display/PAXEXAM4/Pax+Exam)
- [Putting OSGi to the Test with Pax Exam](https://dzone.com/articles/putting-osgi-test-pax-exam)

## Assorted

- [Pax Construct](https://ops4j1.jira.com/wiki/display/paxconstruct/Pax+Construct)
    - [Maven Tips and Tricks: Creating an OSGi Project with Maven](http://blog.sonatype.com/2009/09/maven-tips-and-tricks-creating-an-osgi-project-with-maven/)
    - [Generating an OSGi Project with Maven](https://books.sonatype.com/mcookbook/reference/sect-osgi-generate-project.html)
    - [OSGi, Maven, Pax, and web applications](http://leshazlewood.com/2010/09/08/osgi-maven-pax-and-web-applications/)
- [Pax Runner](https://ops4j1.jira.com/wiki/display/paxrunner/Pax+Runner)
- [Pax Logging](https://ops4j1.jira.com/wiki/display/paxlogging/Pax+Logging)
- [OSGi - JAX-RS Connector](https://github.com/hstaudacher/osgi-jax-rs-connector)
