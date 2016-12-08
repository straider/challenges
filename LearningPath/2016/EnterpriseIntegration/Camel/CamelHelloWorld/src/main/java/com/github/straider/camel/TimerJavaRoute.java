package com.github.straider.camel;

import org.apache.camel.builder.RouteBuilder;

public class TimerJavaRoute extends RouteBuilder {

    private static final String  TIMER_TAG    = "timer";
    private static final String  ROUTE_BEAN   = "timerBean";
    private static final Integer TIMER_PERIOD = 1000;

    private static final String INBOUND_ROUTE_NAME  = String.format( "%s://%s?period=%d", TIMER_TAG, ROUTE_BEAN, TIMER_PERIOD );
    private static final String OUTBOUND_ROUTE_NAME = "stream:out";

    @Override
    public void configure() throws Exception {
        from( INBOUND_ROUTE_NAME )
                .setBody()
                .simple( "Camel fired an event at ${header.firedTime}" )
                .to( OUTBOUND_ROUTE_NAME )
        ;
    }

}
