package com.github.straider.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class JavaCamelContext {

    public static void main( final String[] arguments ) throws Exception {
        final CamelContext context = new DefaultCamelContext();

        try {
            context.start();
        } finally {
            context.stop();
        }
    }

}
