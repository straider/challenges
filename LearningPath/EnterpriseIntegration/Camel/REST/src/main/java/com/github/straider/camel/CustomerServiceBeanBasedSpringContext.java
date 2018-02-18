package com.github.straider.camel;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomerServiceBeanBasedSpringContext {

    public static void main( final String[] arguments ) throws InterruptedException {
        new ClassPathXmlApplicationContext( "META-INF/spring/camel-context.xml" );

        while( true ) {
            Thread.sleep( 10000 );
        }
    }
}
