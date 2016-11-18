package com.github.straider.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.spring.SpringCamelContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainSpring {

    public static void main( final String[] arguments ) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext( "springRoute.xml" );

        CamelContext camelContext = SpringCamelContext.springCamelContext( applicationContext, false );
        try {
            camelContext.start();
        } finally {
            camelContext.stop();
        }
    }

}
