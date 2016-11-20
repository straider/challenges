package com.github.straider.camel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;

public class OrderRouter extends RouteBuilder {

    private static final String  HOST = "0.0.0.0";
    private static final Integer PORT = 10000;
    private static final String  PATH = "placeorder";

    static final String SERVICE_URL          = String.format( "http://%s:%d/%s", HOST, PORT, PATH );
    static final String INBOUND_ROUTE_HTTP   = String.format( "jetty:%s", SERVICE_URL );
    static final String INBOUND_ROUTE_FILE   = String.format( "file:target/%s?noop=true", PATH );
    static final String INTERNAL_ROUTE_QUEUE = "jms:orderQueue.in";
    static final String OUTBOUND_ROUTE_QUEUE = "jms:orderQueue.out";

    @Override
    public void configure() throws Exception {
        JaxbDataFormat jaxb = new JaxbDataFormat( "com.github.straider.camel" );

        from( INBOUND_ROUTE_FILE )
                .to( INTERNAL_ROUTE_QUEUE )
        ;

        from( INBOUND_ROUTE_HTTP )
                .inOnly()
                .to( INTERNAL_ROUTE_QUEUE )
                .transform().constant( "OK" )
        ;

        from( INTERNAL_ROUTE_QUEUE )
                .convertBodyTo( String.class )
                .choice()
                    .when().method( "helper", "isXml" )
                        .unmarshal( jaxb )
                    .when().method( "helper" , "isCsv" )
                        .unmarshal().csv()
                        .to( "bean:normalizer" )
                .end()
                .to( OUTBOUND_ROUTE_QUEUE )
        ;
    }

}
