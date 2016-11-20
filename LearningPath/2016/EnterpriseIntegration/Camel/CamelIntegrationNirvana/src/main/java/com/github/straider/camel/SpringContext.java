package com.github.straider.camel;

import org.apache.activemq.util.IOHelper;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.spring.SpringCamelContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static com.github.straider.camel.OrderRouter.SERVICE_URL;

public class SpringContext {

    public static void main(String[] args) throws Exception {
        final String response;

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

            final ProducerTemplate template      = camelContext.createProducerTemplate();
            final List< String >   lines         = Files.readAllLines( Paths.get( xmlFile.toURI() ), StandardCharsets.UTF_8 );
            final String           lineSeparator = System.getProperty( "line.separator" );

            String xmlMessage = "";
            for ( final String line : lines ) {
                xmlMessage += line + lineSeparator;
            }

            camelContext.start();

            response = template.requestBody( SERVICE_URL, xmlMessage, String.class );
            Thread.sleep( 2500 );
        } finally {
            camelContext.stop();
        }

        System.out.println( String.format( "Response: %s", response ) );
    }

}
