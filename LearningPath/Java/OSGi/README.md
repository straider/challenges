:: OSGi ::
==========

# Overview

> The [OSGi Alliance](https://www.osgi.org/) is a worldwide consortium of technology innovators that advances a proven and mature process to create open specifications that enable the modular assembly of software built with Java technology. Modularity reduces software complexity; OSGi is the best model to modularize Java.

> The OSGi Alliance, formerly known as the Open Services Gateway initiative, is an open standards organization founded in March 1999 that originally specified and continues to maintain the OSGi standard. The [OSGi](https://en.wikipedia.org/wiki/OSGi) specification describes a modular system and a service platform for the Java programming language that implements a complete and dynamic component model, something that does not exist in standalone Java VM environments. Applications or components, coming in the form of bundles for deployment, can be remotely installed, started, stopped, updated, and uninstalled without requiring a reboot; management of Java packages/classes is specified in great detail. Application life cycle management is implemented via APIs that allow for remote downloading of management policies. The service registry allows bundles to detect the addition of new services, or the removal of services, and adapt accordingly.

> [OSGi (Open Service Gateway Initiative)](http://searchnetworking.techtarget.com/definition/OSGi) (Open Service Gateway Initiative) is a Java framework for developing and deploying modular software programs and libraries. OSGi has two parts:
- The first part is a specification for modular components called bundles, which are commonly referred to as plug-ins. The specification defines an infrastructure for a bundle's life cycle and determines how bundles will interact;
- The second part of OSGi is a Java Virtual Machine (JVM)-level service registry that bundles can use to publish, discover and bind to services in a service-oriented architecture.

[A simple answer](http://stackoverflow.com/a/106263):
> An OSGi Service Platform provides a standardized, component-oriented computing environment for cooperating networked services. This architecture significantly reduces the overall complexity of building, maintaining and deploying applications. The OSGi Service Platform provides the functions to change the composition dynamically on the device of a variety of networks, without requiring a restarts.

[An introduction to OSGi](http://www.developerfusion.com/article/84923/an-introduction-to-osgi/):
> The OSGi framework maintains a Service Registry. Service providers can register with the framework and service consumers can then look up the service from the registry. The interaction between services, including a detailed description the service registry, can be found in the Service Layer section of the OSGi specification. Deployable services exist in the OSGi world as bundles. Physically, a bundle is a JAR file containing an OSGi-specific manifest.

## Questions

### What is it?

- It's a module system for Java;
- Includes visibility rules, dependency management and versioning of OSGi "bundles" (modules);
- It's fully dynamic: Installing, starting, stopping, updating, uninstalling bundles, all done dynamically at runtime;
- It's service oriented (always has been ...): all services are registered in a service registry, available in the well-understood publish, find and bind pattern, again all done dynamically at runtime.

### Why use it?

- Reduced Footprint;
- Improved Extensibility;
- Improved Serviceability and Availability;
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

# Architecture

[Architecture](https://www.osgi.org/developer/architecture/)
> The OSGi technology is a set of specifications that define a dynamic component system for Java. These specifications enable a development model where applications are (dynamically) composed of many different (reusable) components. The OSGi specifications enable components to hide their implementations from other components while communicating through services, which are objects that are specifically shared between components. This surprisingly simple model has far reaching effects for almost any aspect of the software development process.

> The OSGi has a layered model and the following list contains a short definition of the terms:
- **Bundles**: Bundles are the OSGi components made by the developers;
- **Services**: The services layer connects bundles in a dynamic way by offering a publish-find-bind model for plain old Java objects;
- **Life-Cycle**: The API to install, start, stop, update, and uninstall bundles;
- **Modules**: The layer that defines how a bundle can import and export code;
- **Security**: The layer that handles the security aspects;
- **Execution Environment**: Defines what methods and classes are available in a specific platform.

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
