package com.github.straider.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimerContext {

    private static final Logger logger = LoggerFactory.getLogger( TimerContext.class );

    public static void main( final String[] arguments ) throws Exception {
        new TimerContext().run();
    }

    private void run() throws Exception {
        final CamelContext camelContext = new DefaultCamelContext();

        camelContext.addRoutes( createRouteBuilder() );
        camelContext.setTracing( true );
        camelContext.start();
    }

    private RoutesBuilder createRouteBuilder() {
        return new TimerRouteBuilder();
    }

}
