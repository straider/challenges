package com.github.straider.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.spring.SpringCamelContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContext {

    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext( "spring-context.xml" );

        CamelContext camelContext = SpringCamelContext.springCamelContext( applicationContext, false );
        try {
            camelContext.start();
        } finally {
            camelContext.stop();
        }
    }

}
