package com.github.straider.camel;

import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

class TimerRouteBuilder extends RouteBuilder {

    private Processor processor;

    @Override
    public void configure() throws Exception {
        from( "timer://timer1?period=1000" ).routeId( "timer.in" )
                .process( processor )
        ;
    }

    public void setProcessor( final Processor processor ) {
        this.processor = processor;
    }

}
