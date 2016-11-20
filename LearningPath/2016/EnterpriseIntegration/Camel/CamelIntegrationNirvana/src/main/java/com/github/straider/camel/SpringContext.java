package com.github.straider.camel;

import org.apache.activemq.util.IOHelper;
import org.apache.camel.CamelContext;
import org.apache.camel.spring.SpringCamelContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

public class SpringContext {

    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext( "spring-context.xml" );

        CamelContext camelContext = SpringCamelContext.springCamelContext( applicationContext, false );
        try {
            final File folder  = new File( "target/placeorder" );
            final File xmlFile = new File( "target/classes/data/message.xml" );
            final File csvFile = new File( "target/classes/data/message.csv" );

            IOHelper.deleteChildren( folder );
            IOHelper.deleteFile( folder );
            IOHelper.mkdirs( folder );

            IOHelper.copyFile( xmlFile, folder );
            IOHelper.copyFile( csvFile, folder );

            camelContext.start();

            Thread.sleep( 2500 );
        } finally {
            camelContext.stop();
        }
    }

}
