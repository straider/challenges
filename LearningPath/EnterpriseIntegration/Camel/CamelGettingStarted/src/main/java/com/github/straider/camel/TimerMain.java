package com.github.straider.camel;

import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.main.Main;

public class TimerMain extends Main {

    public static void main( final String[] arguments ) throws Exception {
        Main main = new TimerMain();

        main.enableHangupSupport();
        main.addRouteBuilder( createRouteBuilder() );
        main.run( arguments );
    }

    private static RouteBuilder createRouteBuilder() {
        final TimerRouteBuilder builder   = new TimerRouteBuilder();
        final Processor         processor = new TimerProcessor();
        builder.setProcessor( processor );

        return builder;
    }

}
