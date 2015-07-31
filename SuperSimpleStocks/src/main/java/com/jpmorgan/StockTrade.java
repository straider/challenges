package com.jpmorgan;

import java.util.Date;

public class StockTrade {

  public static enum StockTradeIndicator {
      BUY
    , SELL
  }

  private final Date                timestamp     ;
  private final Integer             quantity      ;
  private final StockTradeIndicator tradeIndicator;
  private final Double              price         ;

  public StockTrade( final Integer             quantity
                   , final StockTradeIndicator tradeIndicator
                   , final Double              price
                   ) {
    if ( quantity <= 0 ) {
      throw new IllegalArgumentException( "Quantity must be greater than zero!" );
    }
    if ( price <= 0.0 ) {
      throw new IllegalArgumentException( "Price must be greater than zero!" );
    }

    this.timestamp      = new Date()    ;
    this.quantity       = quantity      ;
    this.tradeIndicator = tradeIndicator;
    this.price          = price         ;
  }

  public Boolean isWithinTimeframe( final Integer milliseconds ) {
    final Date now = new Date();

    return timestamp.getTime() > now.getTime() - milliseconds;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public Double getPrice() {
    return price;
  }

}