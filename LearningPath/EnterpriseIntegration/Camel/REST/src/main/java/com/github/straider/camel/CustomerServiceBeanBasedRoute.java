package com.github.straider.camel;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

public class CustomerServiceBeanBasedRoute extends RouteBuilder {

    private static final String INBOUND_ROUTE = "cxfrs://bean:rsServer";

    @Override
    public void configure() throws Exception {
        from( INBOUND_ROUTE )
                .log( LoggingLevel.INFO, "Received request with body: ${body}" )
                .setHeader( Exchange.FILE_NAME, simple( "customer-${body}.xml" ) )
                .pollEnrich( "file:target/classes/data?noop=true", 1000, new CustomerEnricher() )
                .log( LoggingLevel.INFO, "Enriched message: ${body}" )
        ;
    }

}
