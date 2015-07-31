package com.jpmorgan;

import java.util.List;
import java.util.ArrayList;

public class StockExchange {

  private final List< Stock > stocks;

  public StockExchange() {
    stocks = new ArrayList< Stock >();
  }

  public List< Stock > getStocks() {
    return stocks;
  }

  public Stock registerStockCommon( final String  symbol
                                  , final Integer lastDividend
                                  , final Integer parValue
                                  ) {
    final Stock stock = new StockCommon( symbol, lastDividend, parValue );
    stocks.add( stock );

    return stock;
  }

  public Stock registerStockPreferred( final String  symbol
                                     , final Integer lastDividend
                                     , final Integer fixedDividend
                                     , final Integer parValue
                                     ) {
    final Stock stock = new StockPreferred( symbol, lastDividend, fixedDividend, parValue );
    stocks.add( stock );

    return stock;
  }

  public Double getStockExchangeIndex() {
    Integer tradeCounter = 0;
    Double  product      = 1.0;
    for ( final Stock stock : stocks ) {
      for ( final StockTrade trade : stock.getAllTrades() ) {
        product *= trade.getPrice();
        tradeCounter++;
      }
    }
    
    if ( tradeCounter > 0 ) {
      return Math.round( Math.sqrt( product ) * 100.0 ) / 100.0;
    } else {
      return 0.0;
    }
  }
  
}