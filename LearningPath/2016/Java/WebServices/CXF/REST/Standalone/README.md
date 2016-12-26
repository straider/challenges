:: CXF :: REST :: Standalone ::
===============================

# Overview

Register the steps necessary, from scratch, to develop a simple REST service using CXF.

## How to run a CXF REST service in standalone mode?

> The Server class requires a JAXRSServerFactoryBean instance, to set the resource classes and resource providers as well as a JAXRSBindingFactory instance to bind with the service factory instance transport bus.

## How to enable JSON suport?

# Steps

## Buildfiles

### Maven

#### 1st version

A normal and usual pom.xml.

```xml
<?xml version = "1.0" encoding = "UTF-8"?>
<project xmlns              = "http://maven.apache.org/POM/4.0.0"
         xmlns:xsi          = "http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation = "http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd"
>

    <modelVersion>4.0.0</modelVersion>

    <groupId>com.github.straider.java.ws.cxf</groupId>
    <artifactId>rest-standalone</artifactId>
    <version>1.0.0</version>
    <name>Apache CXF Greeting Service</name>
    <description>REST Greeting Service using CXF (JAX-RS implementation).</description>
    <url>https://github.com/straider/coding-dojo/tree/Java/WebServices/CXF/REST/Standalone</url>

    <packaging>jar</packaging>

</project>
```

#### 2nd version

Add compile properties, that fix the warning message:

```
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ rest-standalone ---
[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
```

```xml
...

    <properties>
        <java.version>1.7</java.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>
```

#### 3rd version

Add **cxf-rt-frontend-jaxrs** and **cxf-rt-transports-http-jetty** dependencies, version 3.1.9, as well as the JAX-RS API, version 2.0.1:

```xml
...

    <properties>
        <java.version>1.7</java.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>

        <jaxrs.version>2.0.1</jaxrs.version>
        <cxf.version>3.1.9</cxf.version>
    </properties>

    <dependencies>

        <dependency>
            <groupId>javax.ws.rs</groupId>
            <artifactId>javax.ws.rs-api</artifactId>
            <version>${jaxrs.version}</version>
        </dependency>

        <dependency>
            <groupId>org.apache.cxf</groupId>
            <artifactId>cxf-rt-frontend-jaxrs</artifactId>
            <version>${cxf.version}</version>
        </dependency>
        <dependency>
            <groupId>org.apache.cxf</groupId>
            <artifactId>cxf-rt-transports-http-jetty</artifactId>
            <version>${cxf.version}</version>
            <scope>runtime</scope>
        </dependency>
        
    </dependencies>
```

### Gradle

## Components

### Base / Foundation

#### Greeter

Simple class with methods _speak()_ and _setGreeting()_:

```java
package com.github.straider.java.ws.cxf;

public class Greeter {

    private static final String DEFAULT_GREETING = "Hello";
    private static final String DEFAULT_NAME     = "World";
    private static final String MESSAGE_FORMAT   = "%s, %s!";

    private String greeting;

    public Greeter() {
        greeting = DEFAULT_GREETING;
    }

    public String speak( final String name ) {
        final String nameOrWorld = ( name == null || name.length() == 0 ) ? DEFAULT_NAME : name ;

        return String.format( MESSAGE_FORMAT, greeting, nameOrWorld );
    }

    public String speak() {
        return speak( DEFAULT_NAME );
    }

    public void setGreeting( final String greeting ) {
        this.greeting = ( greeting == null || greeting.length() == 0 ) ? DEFAULT_GREETING : greeting;
    }

}
```

#### JAXB Models

To handle XML / JSON service requests and responses it's useful to work with a JAXB models. These models are handled by the service class, which takes care of the unmarshalling and marshalling.

##### Request Model

```java
package com.github.straider.java.ws.cxf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement( name = "request" )
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( propOrder = { "name" } )
public class RequestModel {

    @XmlElement( required = true, name ="name" ) private String name;
    
    public String getName() {
        return name;
    }

    public void setName( final String name ) {
        this.name = name;
    }
    
}```

##### Response Model

```java
package com.github.straider.java.ws.cxf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

@XmlRootElement( name = "ResponseModel" )
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( propOrder = { "message", "requestOn", "responseOn" } )
public class ResponseModel {

    @XmlElement( required = true, name ="request-on"  ) private Date   requestOn;
    @XmlElement( required = true, name ="response-on" ) private Date   responseOn;
    @XmlElement( required = true, name ="message"     ) private String message;

    public ResponseModel() {
        requestOn = new Date();
    }

    public void setResponseOn() {
        responseOn = new Date();
    }

    public void setMessage( final String message ) {
        this.message = message;
    }

}
```

### Service

#### 1st version

```java
package com.github.straider.java.ws.cxf;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path( "/" )
public class GreetingService {

    private final Greeter greeter;

    public GreetingService() {
        greeter = new Greeter();
    }

    @Path( "speak/" )
    @GET
    @Consumes( MediaType.TEXT_PLAIN )
    @Produces( MediaType.TEXT_PLAIN )
    public Response speak( @DefaultValue( "" ) @QueryParam( "name" ) final String name ) {
        final String response;
        if ( name == null || "".equals( name ) ) {
            response = greeter.speak();
        } else {
            response = greeter.speak( name );
        }

        return Response.status( Response.Status.OK ).entity( response ).build();
    }

    @Path( "greeting/{greeting}" )
    @PUT
    @Consumes( MediaType.TEXT_PLAIN )
    @Produces( MediaType.TEXT_PLAIN )
    public Response setGreeting(@PathParam( "greeting" ) final String greeting ) {
        greeter.setGreeting( greeting );

        return Response.status( Response.Status.ACCEPTED ).build();
    }

}
```

#### 2nd version

This version adds a _process()_ method that receives a request model and returns a response model:

```java
package com.github.straider.java.ws.cxf;

@Path( "/" )
public class GreetingService {

    ...

    @Path( "process/" )
    @POST
    @Consumes( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON } )
    @Produces( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON } )
    public Response process( final RequestModel request ) {
        final String message = ( "".equals( request.getName() ) ) ? greeter.speak() : greeter.speak( request.getName() );
        final ResponseModel response = new ResponseModel();
        response.setMessage( message );
        response.setResponseOn();

        return Response.status( Response.Status.OK ).entity( response ).build();
    }

}
```

### Server

The standalone application follows the guidelines given by [Configuring JAX-RS endpoints programmatically without Spring](http://cxf.apache.org/docs/jaxrs-services-configuration.html#JAXRSServicesConfiguration-ConfiguringJAX-RSendpointsprogrammaticallywithoutSpring):

```java
package com.github.straider.java.ws.cxf;

import org.apache.cxf.binding.BindingFactoryManager;
import org.apache.cxf.jaxrs.JAXRSBindingFactory;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;

public class Server {

    private static final String  DEFAULT_HOST = "localhost";
    private static final Integer DEFAULT_PORT = 10000;

    public static void main( final String[] arguments ) {
        String  host = DEFAULT_HOST;
        Integer port = DEFAULT_PORT;
        if ( arguments.length == 2 ) {
            host = arguments[ 0 ];
            port = new Integer( arguments[ 1 ] );
        }

        final JAXRSServerFactoryBean serverFactory = new JAXRSServerFactoryBean();
        serverFactory.setResourceClasses( Greeter.class );
        serverFactory.setResourceProvider( Greeter.class, new SingletonResourceProvider( new GreetingService() ) );
        serverFactory.setAddress( String.format( "http://%s:%d", host, port ) );

        final JAXRSBindingFactory bindingFactory = new JAXRSBindingFactory();
        bindingFactory.setBus( serverFactory.getBus() );

        final BindingFactoryManager manager = serverFactory.getBus().getExtension( BindingFactoryManager.class );
        manager.registerBindingFactory( JAXRSBindingFactory.JAXRS_BINDING_ID, bindingFactory );

        serverFactory.create();
    }

}
```

**Note**: the main code would benefit from using command-line options library, which allows to handle short and long options in any order.

The standalone mode works on top of Jetty, at runtime, and that's why a runtime dependency for needs to be added. It's [configurable](http://cxf.apache.org/docs/jetty-configuration.html). If this dependency is not met then the following error message occurs:

```
org.apache.cxf.transport.http.HTTPTransportFactory getDestination
SEVERE: Cannot find any registered HttpDestinationFactory from the Bus.
```

### Client
