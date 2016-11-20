package com.github.straider.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimerContext {

    private static final Logger logger = LoggerFactory.getLogger( TimerContext.class );

    public static void main( final String[] arguments ) {
        new TimerContext().run();
    }

    private void run() {
        final CamelContext camelContext = new DefaultCamelContext();
    }

}
