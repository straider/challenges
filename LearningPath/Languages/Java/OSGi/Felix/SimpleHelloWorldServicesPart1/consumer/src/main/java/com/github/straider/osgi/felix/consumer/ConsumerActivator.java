package com.github.straider.osgi.felix.consumer;

import com.github.straider.osgi.felix.common.HelloWorldService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import static com.github.straider.osgi.felix.common.HelloWorldService.INTERFACE_NAME;

public class ConsumerActivator implements BundleActivator {

    private HelloWorldServiceConsumer consumer;

    @Override
    public void start( final BundleContext bundleContext ) throws Exception {
        final ServiceReference service = bundleContext.getServiceReference( INTERFACE_NAME );

        consumer = new HelloWorldServiceConsumer( ( HelloWorldService ) bundleContext.getService( service ) );
        consumer.startTimer();
    }

    @Override
    public void stop( final BundleContext bundleContext ) throws Exception {
        consumer.stopTimer();
    }

}
