package com.github.straider.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class TimerBeanProcessor implements Processor {

    private static final Logger logger = LoggerFactory.getLogger( TimerBeanProcessor.class );

    private final String name;

    TimerBeanProcessor( final String name ) {
        this.name = name;
    }

    @Override
    public void process( final Exchange exchange ) throws Exception {
        logger.info( "{} process {}", name, exchange );
    }

}
