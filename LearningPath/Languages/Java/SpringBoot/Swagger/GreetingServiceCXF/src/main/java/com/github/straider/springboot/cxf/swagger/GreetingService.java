package com.github.straider.springboot.cxf.swagger;

import org.springframework.stereotype.Component;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path( "/" )
@Component
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
        response = ( "".equals( name ) ) ? greeter.speak() : greeter.speak( name );

        return Response.status( Response.Status.OK ).entity( response ).build();
    }

    @Path( "greeting/{greeting}" )
    @PUT
    @Consumes( MediaType.TEXT_PLAIN )
    @Produces( MediaType.TEXT_PLAIN )
    public Response setGreeting( @PathParam( "greeting" ) final String greeting ) {
        greeter.setGreeting( greeting );

        return Response.status( Response.Status.ACCEPTED ).build();
    }

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
