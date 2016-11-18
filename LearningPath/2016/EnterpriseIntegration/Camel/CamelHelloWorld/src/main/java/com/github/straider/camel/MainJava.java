package com.github.straider.camel;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;

import static com.github.straider.camel.JavaRoute.ACTIVEMQ_TAG;
import static com.github.straider.camel.JavaRoute.INBOUND_ROUTE_NAME;

public class MainJava {

    private static final String BROKER_HOST = "localhost";
    private static final String BROKER_URL  = String.format( "vm://%s?broker.persistent=false", BROKER_HOST );

    public static void main( final String[] arguments ) throws Exception {
        final CamelContext camelContext = new DefaultCamelContext();

        try {
            camelContext.addComponent( ACTIVEMQ_TAG, ActiveMQComponent.activeMQComponent( BROKER_URL ) );
            camelContext.addRoutes( new JavaRoute() );

            ProducerTemplate template = camelContext.createProducerTemplate();

            camelContext.start();
            template.sendBody( INBOUND_ROUTE_NAME, "Hello, World!" );
        } finally {
            camelContext.stop();
        }
    }

}
