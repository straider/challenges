package com.github.straider.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.processor.aggregate.AggregationStrategy;

public class CustomerEnricher implements AggregationStrategy {

    @Override
    public Exchange aggregate( final Exchange oldExchange, final Exchange newExchange ) {
        final Message oldIn = oldExchange.getIn();
        final Message newIn = newExchange.getIn();

        oldIn.setHeader( "OrigId", oldIn.getBody( String.class ) );

        oldIn.setBody( newIn.getBody( String.class ) );

        return oldExchange;
    }

}
