package com.github.straider.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class TimerProcessor implements Processor {

    private static final Logger logger = LoggerFactory.getLogger( TimerRouteBuilder.class );

    @Override
    public void process(final Exchange exchange ) throws Exception {
        logger.info( "Processing {}", exchange );
    }

}
