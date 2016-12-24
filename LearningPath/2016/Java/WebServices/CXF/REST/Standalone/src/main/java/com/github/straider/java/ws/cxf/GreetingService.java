package com.github.straider.java.ws.cxf;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path( "/" )
public class GreetingService {

    private final Greeter greeter;

    public GreetingService() {
        greeter = new Greeter();
    }

    @Path( "speak/" )
    @GET
    @Consumes( "text/plain" )
    @Produces( "text/plain" )
    public String speak( @DefaultValue( "" ) @QueryParam( "name" ) final String name ) {
        final String response;

        if ( name == null || "".equals( name ) ) {
            response = greeter.speak();
        } else {
            response = greeter.speak( name );
        }

        return response;
    }

    @Path( "greeting/{greeting}" )
    @PUT
    @Consumes( "text/plain" )
    @Produces( "text/plain" )
    public void setGreeting( @PathParam( "greeting" ) final String greeting ) {
        greeter.setGreeting( greeting );
    }

}
