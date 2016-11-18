package com.github.straider.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.spring.SpringCamelContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainSpring {

    static final String ACTIVEMQ_TAG       = "activemq";
    static final String QUEUE_NAME         = "test.queue";
    static final String INBOUND_ROUTE_NAME = String.format( "%s:%s", ACTIVEMQ_TAG, QUEUE_NAME);

    public static void main( final String[] arguments ) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext( "springRoute.xml" );

        CamelContext camelContext = SpringCamelContext.springCamelContext( applicationContext, false );
        try {
            ProducerTemplate template = camelContext.createProducerTemplate();

            camelContext.start();
            template.sendBody( INBOUND_ROUTE_NAME, "Hello, World!" );
        } finally {
            camelContext.stop();
        }
    }

}
