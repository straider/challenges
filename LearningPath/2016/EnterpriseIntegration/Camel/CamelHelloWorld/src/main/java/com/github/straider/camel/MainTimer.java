package com.github.straider.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class MainTimer {

    public static void main( final String[] arguments ) throws Exception {
        final CamelContext camelContext = new DefaultCamelContext();

        try {
            camelContext.addRoutes( new TimerJavaRoute() );

            camelContext.start();
            Thread.sleep( 5000 );
        } finally {
            camelContext.stop();
        }
    }

}
