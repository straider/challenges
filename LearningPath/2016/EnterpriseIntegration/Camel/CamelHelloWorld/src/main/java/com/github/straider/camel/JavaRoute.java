package com.github.straider.camel;

import org.apache.camel.builder.RouteBuilder;

public class JavaRoute extends RouteBuilder {

    public static final String ACTIVEMQ_TAG        = "activemq";
    public static final String QUEUE_NAME          = "test.queue";
    public static final String INBOUND_ROUTE_NAME  = String.format( "%s:%s", ACTIVEMQ_TAG, QUEUE_NAME);
    public static final String OUTBOUND_ROUTE_NAME = "stream:out";

    @Override
    public void configure() throws Exception {
        from( INBOUND_ROUTE_NAME )
                .to( OUTBOUND_ROUTE_NAME )
        ;
    }

}
