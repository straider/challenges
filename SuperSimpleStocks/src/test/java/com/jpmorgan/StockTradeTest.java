package com.jpmorgan;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class StockTradeTest {

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void throwsExceptionWhenQuantityLessThanZeroIfBuy() throws IllegalArgumentException {
    thrown.expect( IllegalArgumentException.class );
    thrown.expectMessage( "Quantity must be greater than zero!" );
    final StockTrade stockTrade = new StockTrade( -1, StockTrade.StockTradeIndicator.BUY, 123.45 );
  }

  @Test
  public void throwsExceptionWhenQuantityLessThanZeroIfSell() throws IllegalArgumentException {
    thrown.expect( IllegalArgumentException.class );
    thrown.expectMessage( "Quantity must be greater than zero!" );
    final StockTrade stockTrade = new StockTrade( -1, StockTrade.StockTradeIndicator.SELL, 123.45 );
  }

  @Test
  public void throwsExceptionWhenQuantityEqualToZeroIfBuy() throws IllegalArgumentException {
    thrown.expect( IllegalArgumentException.class );
    thrown.expectMessage( "Quantity must be greater than zero!" );
    final StockTrade stockTrade = new StockTrade( 0, StockTrade.StockTradeIndicator.BUY, 123.45 );
  }

  @Test
  public void throwsExceptionWhenQuantityEqualToZeroIfSell() throws IllegalArgumentException {
    thrown.expect( IllegalArgumentException.class );
    thrown.expectMessage( "Quantity must be greater than zero!" );
    final StockTrade stockTrade = new StockTrade( 0, StockTrade.StockTradeIndicator.SELL, 123.45 );
  }

  @Test
  public void throwsExceptionWhenPriceLessThanZeroIfBuy() throws IllegalArgumentException {
    thrown.expect( IllegalArgumentException.class );
    thrown.expectMessage( "Price must be greater than zero!" );
    final StockTrade stockTrade = new StockTrade( 1, StockTrade.StockTradeIndicator.BUY, -123.45 );
  }

  @Test
  public void throwsExceptionWhenPriceLessThanZeroIfSell() throws IllegalArgumentException {
    thrown.expect( IllegalArgumentException.class );
    thrown.expectMessage( "Price must be greater than zero!" );
    final StockTrade stockTrade = new StockTrade( 1, StockTrade.StockTradeIndicator.SELL, -123.45 );
  }

  @Test
  public void throwsExceptionWhenPriceLessEqualToZeroIfBuy() throws IllegalArgumentException {
    thrown.expect( IllegalArgumentException.class );
    thrown.expectMessage( "Price must be greater than zero!" );
    final StockTrade stockTrade = new StockTrade( 1, StockTrade.StockTradeIndicator.BUY, 0.0 );
  }

  @Test
  public void throwsExceptionWhenPriceLessEqualToZeroIfSell() throws IllegalArgumentException {
    thrown.expect( IllegalArgumentException.class );
    thrown.expectMessage( "Price must be greater than zero!" );
    final StockTrade stockTrade = new StockTrade( 1, StockTrade.StockTradeIndicator.SELL, 0.0 );
  }

  @Test
  public void isWithinTimeframeWhenRecordedLessThan() throws InterruptedException {
    final StockTrade stockTrade   = new StockTrade( 1, StockTrade.StockTradeIndicator.SELL, 123.45 );
    final Integer    milliseconds = 10;
    Thread.sleep( milliseconds - 5 );
    Assert.assertTrue( "StockTrade recorded less than 1 minute ago", stockTrade.isWithinTimeframe( milliseconds ) );
  }

  @Test
  public void isNotWithinTimeframeWhenRecordedGreaterThan() throws InterruptedException {
    final StockTrade stockTrade   = new StockTrade( 1, StockTrade.StockTradeIndicator.SELL, 123.45 );
    final Integer    milliseconds = 10;
    Thread.sleep( milliseconds + 5 );
    Assert.assertFalse( "StockTrade recorded less than 1 minute ago", stockTrade.isWithinTimeframe( milliseconds ) );
  }

}