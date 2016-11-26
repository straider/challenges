package com.github.straider.camel;

import org.apache.camel.builder.RouteBuilder;

class JavaRoute extends RouteBuilder {

    static final String ACTIVEMQ_TAG        = "activemq";
    static final String QUEUE_NAME          = "test.queue";
    static final String INBOUND_ROUTE_NAME  = String.format( "%s:%s", ACTIVEMQ_TAG, QUEUE_NAME);
    static final String OUTBOUND_ROUTE_NAME = "stream:out";

    @Override
    public void configure() throws Exception {
        from( INBOUND_ROUTE_NAME )
                .to( OUTBOUND_ROUTE_NAME )
        ;
    }

}
