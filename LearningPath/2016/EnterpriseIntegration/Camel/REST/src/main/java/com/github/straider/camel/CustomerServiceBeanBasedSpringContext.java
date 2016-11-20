package com.github.straider.camel;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomerServiceBeanBasedSpringContext {

    public static void main( final String[] arguments ) {
        new ClassPathXmlApplicationContext( "META-INF/spring/camel-context.xml" );
    }
}
