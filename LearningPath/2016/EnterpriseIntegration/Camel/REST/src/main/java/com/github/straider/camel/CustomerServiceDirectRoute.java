package com.github.straider.camel;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

public class CustomerServiceDirectRoute extends RouteBuilder {

    private static final String  HOST = "0.0.0.0";
    private static final Integer PORT = 10000;
    private static final String  PATH = "route";

    private static final String SERVICE_URL   = String.format( "http://%s:%d/%s?resourceClasses=%s", HOST, PORT, PATH, CustomerServiceResource.class.getName() );
    private static final String INBOUND_ROUTE = String.format( "cxfrs://%s", SERVICE_URL );

    @Override
    public void configure() throws Exception {
        from( INBOUND_ROUTE )
                .log( LoggingLevel.INFO, "Received request with body: ${body}" )
        ;
    }

}
