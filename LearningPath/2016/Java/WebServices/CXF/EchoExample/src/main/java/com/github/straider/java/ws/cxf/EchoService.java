package com.github.straider.java.ws.cxf;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path( "/" )
public class EchoService {

    @GET
    @Path( "/echo/{input}" )
    @Produces( "text/plain" )
    public String echo( @PathParam( "input" ) String input ) {
        return input;
    }

}
