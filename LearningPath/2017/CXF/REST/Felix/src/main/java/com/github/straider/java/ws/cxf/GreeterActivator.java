package com.github.straider.java.ws.cxf;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class GreeterActivator implements BundleActivator {

    private ServiceRegistration registration;

    @Override
    public void start( final BundleContext bundleContext ) throws Exception {
        final GreetingService service = new GreetingService();

        registration = bundleContext.registerService( GreetingService.class.getName(), service, null );
    }

    @Override
    public void stop( final BundleContext bundleContext ) throws Exception {
        registration.unregister();
    }

}
