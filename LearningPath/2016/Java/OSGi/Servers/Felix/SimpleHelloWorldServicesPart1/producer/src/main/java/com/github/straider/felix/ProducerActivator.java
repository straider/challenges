package com.github.straider.felix;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ProducerActivator implements BundleActivator {

    private static final String INTERFACE_NAME = HelloWorldService.class.getName();

    private ServiceRegistration registration;

    @Override
    public void start( final BundleContext bundleContext ) throws Exception {
        final HelloWorldServiceImplementation service = new HelloWorldServiceImplementation();

        registration = bundleContext.registerService( INTERFACE_NAME, service, null );
    }

    @Override
    public void stop( final BundleContext bundleContext ) throws Exception {
        registration.unregister();
    }

}
