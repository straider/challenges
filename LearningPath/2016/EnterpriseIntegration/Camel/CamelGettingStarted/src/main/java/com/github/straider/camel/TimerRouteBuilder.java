package com.github.straider.camel;

import org.apache.camel.builder.RouteBuilder;

public class TimerRouteBuilder extends RouteBuilder {

    private final TimerProcessor processor = new TimerProcessor();

    @Override
    public void configure() throws Exception {
        from( "timer://timer1?period=1000" ).routeId( "timer.in" )
                .process( processor )
        ;
    }

}
