package com.github.straider.camel;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path( "/customerservice/" )
public class CustomerServiceResource {

    @Context
    private UriInfo uriInfo;

    public CustomerServiceResource() {
    }

    @GET
    @Path( "/customer/{id}/" )
    @Produces( "text/xml" )
    public CustomerModel getCustomer( @PathParam( "id" ) final String id ) {
        return null;
    }

    @PUT
    @Path( "/customer/" )
    public Response updateCustomer( final CustomerModel customer ) {
        return null;
    }

}
