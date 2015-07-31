package com.jpmorgan;

import java.util.List;

public interface Stock {

  public static enum StockType {
      COMMON
    , PREFERRED
  }

  public List< StockTrade > getAllTrades();
  public List< StockTrade > getTradesWithinTimeframe( final Integer minutes );

  public Double getDividendYield      ( final Double marketShare );
  public Double getPriceEarningsRatio ( final Double marketShare );

  public Double getVolumeWeightedStockPrice( final Integer minutes );

  public void recordTrade( final Integer                        quantity
                         , final StockTrade.StockTradeIndicator tradeIndicator
                         , final Double                         price
                         );

}