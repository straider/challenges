package com.github.straider.camel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.main.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimerMain extends Main {

    private static final Logger logger = LoggerFactory.getLogger( TimerMain.class );

    public static void main( final String[] arguments ) throws Exception {
        Main main = new TimerMain();

        main.enableHangupSupport();
        main.addRouteBuilder( createRouteBuilder() );
        if ( arguments.length > 0 ) {
            main.run( arguments );
        } else {
            main.run();
        }
    }

    private static RouteBuilder createRouteBuilder() {
        return new TimerRouteBuilder();
    }

}
