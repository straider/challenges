:: OSGi :: Code Activation ::
=============================

# Overview

There are [4 ways to activate code](http://blog.knowhowlab.org/2010/10/osgi-tutorial-4-ways-to-activate-code.html) in an OSGi bundle:

## Bundle Activator

It's the simplest and oldest way, often used in examples, to activate the main code inside an OSGi bundle. When following this way then be aware that:

- Only one BundleActivator implementation is allowed per bundle, which isn't so much of a limitation since per convention a bundle is a modular unit and it should be simple (like a LEGO piece);
- The class that implements the BundleActivator interface is required to have an empty constructor;
- MANIFEST.INF must contain Bundle-Activator that points to the activated class;
- Suited for low-level bundles or when maximum control is desired.

## Declarative Services

It's the next high-level way of activating code inside an OSGi bundle. When following this way then be aware that:

- It uses Service Component model, instead of Bundle model, which allows a bundle to hold one or more activated classes;
- Each Service Component requires an XML file that declares its OSGi Component Definition;
- MANIFEST.INF must contain Service-Component that points to the XML file of each activated class;
- Helps to focus on the application logic, since it takes care of most of OSGi aspects of registering and tracking services.

## Blueprint Services

It has roots on Spring Dynamic Modules specification and is very similar to Declarative Services. When following this way then be aware that:

- It uses Component / Bean model, instead of Bundle model, which allows a bundle to hold one or more activated classes;
- Each Component / Bean requires an XML file that declares its OSGi Component Definition;
- All XML files must be located under OSGI-INF/bleprint/ sub-folder;
- Helps to focus on the application logic, since it takes care of most of OSGi aspects of registering and tracking services.

## Web Application Bundle

Web Application Bundle (WAB) was introduced in OSGi Enterprise 4.2 Specification. WAB is a combination of JEE Web Application and OSGi bundle.  When following this way then be aware that:

- WAB has the same structure as standard WAR + OSGi MANIFEST.MF;
- WAB uses the same life cycle and class/resource loading rules as standard OSGi bundle;
- MANIFEST.INF must contain Bundle-Classpath that lists all classes under classes/ folder and libraries under lib/ folder;
- MANIFEST.INF must contain Web-ContextPath that points to the WAB context path;
- OSGi BundleContext is provided to WAB as ServletContext attribute "osgi-bundlecontext". It is available for Servlets/JSPs/Listeners/Filters;
- Suited for ... FIXME.

# Examples

- [BundleActivator](BundleActivator/README.md)
- [DeclarativeServiceComponents](DeclarativeServiceComponents/README.md)
- [BlueprintComponents](BlueprintComponents/README.md)
- [WebApplication](WebApplication/README.md)
