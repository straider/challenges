package com.github.straider.camel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.main.Main;

public class TimerBeansMain extends Main {

    public static void main( final String[] arguments ) throws Exception {
        Main main = new TimerBeansMain();

        main.enableHangupSupport();
        main.bind( "processByBeanA", new TimerBeanProcessor( "1st" ) );
        main.bind( "processByBeanB", new TimerBeanProcessor( "2nd" ) );
        main.addRouteBuilder( createRouteBuilder() );
        main.run( arguments );
    }

    private static RouteBuilder createRouteBuilder() {
        return new TimerBeansRouteBuilder();
    }

}
