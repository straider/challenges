package com.github.straider.java.ws.cxf;

import org.apache.cxf.binding.BindingFactoryManager;
import org.apache.cxf.jaxrs.JAXRSBindingFactory;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;

public class Main {

    public static void main( final String[] arguments ) {
//        final JAXRSServerFactoryBean rsFactory = new JAXRSServerFactoryBean();
//        rsFactory.setResourceClasses( EchoService.class );
//        rsFactory.setResourceProvider( EchoService.class, new SingletonResourceProvider( new EchoService() ) );
//        rsFactory.setAddress( "http://localhost:10000/ws/" );
//
//        final BindingFactoryManager manager = rsFactory.getBus().getExtension( BindingFactoryManager.class );
//        final JAXRSBindingFactory   factory = new JAXRSBindingFactory();
//        factory.setBus( factory.getBus() );
//        manager.registerBindingFactory( JAXRSBindingFactory.JAXRS_BINDING_ID, factory );
//
//        rsFactory.create();
    }

}
