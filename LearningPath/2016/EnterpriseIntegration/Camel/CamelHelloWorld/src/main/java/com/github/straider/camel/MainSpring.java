package com.github.straider.camel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainSpring {

    public static void main( final String[] arguments ) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext( "springRoute.xml" );
    }

}
