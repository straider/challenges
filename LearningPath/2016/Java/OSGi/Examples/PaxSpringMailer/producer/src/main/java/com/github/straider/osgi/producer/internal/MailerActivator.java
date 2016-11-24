package com.github.straider.osgi.producer.internal;

import java.util.Dictionary;
import java.util.Properties;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.github.straider.osgi.producer.IMailerService;

public final class MailerActivator implements BundleActivator {

    /**
     * Called whenever the OSGi framework starts our bundle
     */
    public void start( BundleContext bc ) throws Exception {
        System.out.println( "STARTING com.github.straider.osgi.producer" );

        Dictionary props = new Properties();
        // add specific service properties here...

        System.out.println( "REGISTER com.github.straider.osgi.producer.IMailerService" );

        // Register our example service implementation in the OSGi service registry
        bc.registerService( IMailerService.class.getName(), new MailerService(), props );
    }

    /**
     * Called whenever the OSGi framework stops our bundle
     */
    public void stop( BundleContext bc ) throws Exception {
        System.out.println( "STOPPING com.github.straider.osgi.producer" );

        // no need to unregister our service - the OSGi framework handles it for us
    }

}
