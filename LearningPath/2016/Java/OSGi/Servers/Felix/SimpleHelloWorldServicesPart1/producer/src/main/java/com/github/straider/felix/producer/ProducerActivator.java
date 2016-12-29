package com.github.straider.felix.producer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import static com.github.straider.felix.producer.HelloWorldService.INTERFACE_NAME;

public class ProducerActivator implements BundleActivator {

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
