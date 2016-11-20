package com.github.straider.camel;

import java.util.List;

public class OrderNormalizer {

    public Order fromCsvToOrder( List< List< String > > body ) {
        final List< String > orderHeaders = body.get( 0 );
        final List< String > orderValues  = body.get( 1 );

        return new Order( orderValues.get( 0 ), Integer.parseInt( orderValues.get( 1 ).trim() ) );
    }

}
