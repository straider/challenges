package com.github.straider.felix.consumer;

import com.github.straider.felix.producer.HelloWorldService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import static com.github.straider.felix.producer.HelloWorldService.INTERFACE_NAME;

public class ConsumerActivator implements BundleActivator {

    private HelloWorldConsumer consumer;

    @Override
    public void start( final BundleContext bundleContext ) throws Exception {
        final ServiceReference service = bundleContext.getServiceReference( INTERFACE_NAME );

        consumer = new HelloWorldConsumer( ( HelloWorldService ) bundleContext.getService( service ) );
        consumer.startTimer();
    }

    @Override
    public void stop( final BundleContext bundleContext ) throws Exception {
        consumer.stopTimer();
    }

}
