package com.jpmorgan;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class StockExchangeTest {

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  @Test
  public void hasNoStocksAfterCreation() {
    final StockExchange newStockExchange = new StockExchange();
    Assert.assertEquals( "After creation the stock exchange is empty", 0, newStockExchange.getStocks().size() );
  }

  @Test
  public void canHoldSeveralCommonStocks() {
    final StockExchange gbce = new StockExchange();
    gbce.registerStockCommon( "TEA",  0, 100 );
    gbce.registerStockCommon( "POP",  8, 100 );
    gbce.registerStockCommon( "ALE", 23,  60 );
    gbce.registerStockCommon( "JOE", 13, 250 );
    Assert.assertEquals( "After register common stocks then the stock exchange is not empty", 4, gbce.getStocks().size() );
  }

  @Test
  public void canHoldSeveralPreferredStocks() {
    final StockExchange gbce = new StockExchange();
    gbce.registerStockPreferred( "GIN", 8, 2, 100 );
    Assert.assertEquals( "After register preferred stocks then the stock exchange is not empty", 1, gbce.getStocks().size() );
  }

  @Test
  public void canComputeStockExchangeIndexWithStockTrades() {
    final StockExchange gbce = new StockExchange();

    final Stock stock1 = gbce.registerStockCommon( "TEA",  0, 100 );
    final Stock stock2 = gbce.registerStockCommon( "POP",  8, 100 );
    final Stock stock3 = gbce.registerStockCommon( "ALE", 23,  60 );
    final Stock stock4 = gbce.registerStockCommon( "JOE", 13, 250 );

    final Stock stock5 = gbce.registerStockPreferred( "GIN", 8, 2, 100 );

    stock1.recordTrade( 1000, StockTrade.StockTradeIndicator.BUY , 5.00 );
    stock1.recordTrade(  500, StockTrade.StockTradeIndicator.BUY , 4.00 );
    stock2.recordTrade( 2000, StockTrade.StockTradeIndicator.SELL, 2.50 );
    stock3.recordTrade( 3000, StockTrade.StockTradeIndicator.BUY , 7.25 );
    stock4.recordTrade( 4000, StockTrade.StockTradeIndicator.BUY , 3.75 );
    stock5.recordTrade( 5000, StockTrade.StockTradeIndicator.BUY , 1.25 );
    stock5.recordTrade(  500, StockTrade.StockTradeIndicator.SELL, 0.75 );

    final Double delta = 0.001;
    Assert.assertEquals( "Can compute the StockExchangeIndex when the stock exchange holds stock trades", 35.70, gbce.getStockExchangeIndex(), delta );
  }

  @Test
  public void canComputeStockExchangeIndexWithoutStockTrades() {
    final StockExchange gbce  = new StockExchange();
    final Double        delta = 0.001;
    Assert.assertEquals( "Can compute the StockExchangeIndex when the stock exchange has no stock trades", 0.0, gbce.getStockExchangeIndex(), delta );
  }

}