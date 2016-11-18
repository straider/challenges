package com.github.straider.camel;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;

public class JavaCamelContext {

    public static void main( final String[] arguments ) throws Exception {
        final CamelContext context = new DefaultCamelContext();

        try {
            context.addComponent( "activemq", ActiveMQComponent.activeMQComponent( "vm://localhost?broker.persistent=false" ) );

            ProducerTemplate template = context.createProducerTemplate();

            context.start();
            template.sendBody( "activemq:test.queue", "Hello World" );
            Thread.sleep( 2000 );
        } finally {
            context.stop();
        }
    }

}
