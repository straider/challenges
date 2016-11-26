package net.kevinboone.mavencameltest;

import org.apache.camel.builder.RouteBuilder;

public class MyRouteBuilder extends RouteBuilder {

    public void configure() {
        // Override the configure() method to define the route. We're
        //  reading from a directory, logging, and then copying to a
        //  directory. The log class is defined to be
        //  net.kevinboone.mavencameltest.MyRouteBuilder — we'll need
        //  this information for the log4j configuration file
        from ("file:tmp/in?noop=true")
            .to("log:net.kevinboone.mavencameltest.MyRouteBuilder?level=DEBUG")
                .to("file:tmp/out");
    }

}
