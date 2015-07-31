package com.jpmorgan;

import java.util.List;
import java.util.ArrayList;

public abstract class StockBase implements Stock {

  protected final String          symbol      ;
  protected final Stock.StockType type        ;
  protected final Integer         lastDividend;
  protected final Integer         parValue    ;

  private final List< StockTrade > trades;

  protected StockBase( final String  symbol
                     , final Integer lastDividend
                     , final Integer parValue
                     ) {
    this.symbol       = symbol                ;
    this.type         = Stock.StockType.COMMON;
    this.lastDividend = lastDividend          ;
    this.parValue     = parValue              ;

    trades = new ArrayList< StockTrade >();
  }

  @Override
  public List< StockTrade > getAllTrades() {
    return trades;
  }

  @Override
  public List< StockTrade > getTradesWithinTimeframe( final Integer milliseconds ) {
    final List< StockTrade > result = new ArrayList< StockTrade >();

    for ( final StockTrade trade : trades ) {
      if ( trade.isWithinTimeframe( milliseconds ) ) {
        result.add( trade );
      }
    }

    return result;
  }

  @Override
  public abstract Double getDividendYield( final Double marketShare );

  @Override
  public Double getPriceEarningsRatio( final Double marketShare ) {
    return ( lastDividend == 0.0 ) ? 0.0 : Math.round( marketShare / lastDividend * 100.0 ) / 100.0;
  }

  @Override
  public Double getVolumeWeightedStockPrice( final Integer minutes ) {
    Double sumStockPrice = 0.0;
    Double sumQuantity   = 0.0;

    for ( final StockTrade trade : getTradesWithinTimeframe( minutes * 60 * 1000 ) ) {
      sumStockPrice += trade.getPrice() * trade.getQuantity();
      sumQuantity   += trade.getQuantity();
    }

    if ( sumQuantity > 0.0 ) {
      final Double volumeWeightedStockPrice = Math.round( sumStockPrice / sumQuantity * 100.0 ) / 100.0;
      return volumeWeightedStockPrice;
    } else {
      return 0.0;
    }
  }

  @Override
  public void recordTrade( final Integer                        quantity
                         , final StockTrade.StockTradeIndicator tradeIndicator
                         , final Double                         price
                         ) {
    final StockTrade trade = new StockTrade( quantity, tradeIndicator, price );
    trades.add( trade );
  }

}