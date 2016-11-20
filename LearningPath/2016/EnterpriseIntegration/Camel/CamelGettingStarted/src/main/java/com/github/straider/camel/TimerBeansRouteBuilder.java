package com.github.straider.camel;

import org.apache.camel.builder.RouteBuilder;

public class TimerBeansRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from( "timer://timer2?period=1000" )
                .to( "bean:processByBeanA" )
                .to( "bean:processByBeanB" )
        ;
    }

}
