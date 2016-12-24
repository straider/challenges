package com.github.straider.java.ws.cxf;

import org.apache.cxf.binding.BindingFactoryManager;
import org.apache.cxf.jaxrs.JAXRSBindingFactory;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;

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
        serverFactory.setResourceClasses( GreetingService.class );
        serverFactory.setResourceProvider( GreetingService.class, new SingletonResourceProvider( new GreetingService() ) );
        serverFactory.setAddress( String.format( "http://%s:%d", host, port ) );

        final JAXRSBindingFactory bindingFactory = new JAXRSBindingFactory();
        bindingFactory.setBus( serverFactory.getBus() );

        final BindingFactoryManager manager = serverFactory.getBus().getExtension( BindingFactoryManager.class );
        manager.registerBindingFactory( JAXRSBindingFactory.JAXRS_BINDING_ID, bindingFactory );

        serverFactory.create();
    }

}
