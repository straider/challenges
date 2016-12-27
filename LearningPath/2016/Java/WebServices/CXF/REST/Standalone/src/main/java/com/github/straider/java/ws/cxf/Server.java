package com.github.straider.java.ws.cxf;

import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.apache.cxf.jaxrs.provider.AbstractConfigurableProvider;
import org.apache.cxf.jaxrs.provider.json.JSONProvider;

import java.util.List;
import java.util.ArrayList;

public class Server {

    private static final String  DEFAULT_HOST = "localhost";
    private static final Integer DEFAULT_PORT = 10000;

    public static void main( final String[] arguments ) {
        String  host = DEFAULT_HOST;
        Integer port = DEFAULT_PORT;
        if ( arguments.length == 2 ) {
            host = arguments[ 0 ];
            port = new Integer( arguments[ 1 ] );
        }

        final JAXRSServerFactoryBean serverFactory = new JAXRSServerFactoryBean();
        serverFactory.setResourceClasses( GreetingService.class, ChecksumService.class );
        serverFactory.setResourceProvider( GreetingService.class, new SingletonResourceProvider( new GreetingService() ) );
        serverFactory.setAddress( String.format( "http://%s:%d", host, port ) );

        final JSONProvider                         jsonProvider = new JSONProvider();
        final List< AbstractConfigurableProvider > providers    = new ArrayList< AbstractConfigurableProvider >();
        providers.add( jsonProvider );
        serverFactory.setProviders( providers );
        serverFactory.create();
    }

}
