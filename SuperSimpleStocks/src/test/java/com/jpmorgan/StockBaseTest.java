package com.jpmorgan;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.Assert;

public class StockBaseTest {

  private class StockMock extends StockBase implements Stock {

    public StockMock( final String  symbol
                    , final Integer lastDividend
                    , final Integer parValue
                    ) {
      super( symbol, lastDividend, parValue );
    }

    @Override
    public Double getDividendYield( final Double marketShare ) {
      return 1.0;
    }

  }

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  @Test
  public void canComputeDividendYield() {
    final Stock  stock       = new StockMock( "FOO", 10, 100 );
    final Double marketShare = 2.5;
    final Double delta       = 0.001;
    Assert.assertEquals( "Can Compute DividendYield", 1.0, stock.getDividendYield( marketShare ), delta );
  }

  @Test
  public void canComputePriceEarningsRatioWhenLastDividendNotZero() {
    final Stock  stock       = new StockMock( "FOO", 100, 100 );
    final Double marketShare = 10.0;
    final Double delta       = 0.001;
    Assert.assertEquals( "Can compute DividendYield when LastDividend is not Zero", 0.1, stock.getPriceEarningsRatio( marketShare ), delta );
  }

  @Test
  public void canComputePriceEarningsRatioWhenLastDividendIsZero() {
    final Stock  stock       = new StockMock( "FOO", 0, 100 );
    final Double marketShare = 10.0;
    final Double delta       = 0.001;
    Assert.assertEquals( "Can compute DividendYield when LastDividend is Zero", 0.0, stock.getPriceEarningsRatio( marketShare ), delta );
  }

  @Test
  public void canRecordTrades() {
    final Stock stock = new StockMock( "FIL", 10, 50 );
    stock.recordTrade( 1000, StockTrade.StockTradeIndicator.BUY , 10.25 );
    stock.recordTrade( 2000, StockTrade.StockTradeIndicator.BUY ,  7.50 );
    stock.recordTrade( 3000, StockTrade.StockTradeIndicator.SELL, 12.75 );
    Assert.assertEquals( "Can record trades", 3, stock.getAllTrades().size() );
  }

  @Test
  public void canRetrieveTradesWithinTimeframe() throws InterruptedException {
    final Integer elapsedMilliseconds = 10;
    final Stock stock = new StockMock( "FIL", 10, 50 );
    stock.recordTrade( 1000, StockTrade.StockTradeIndicator.BUY , 10.25 );
    stock.recordTrade( 2000, StockTrade.StockTradeIndicator.BUY ,  7.50 );
    Thread.sleep( elapsedMilliseconds + 1 );
    stock.recordTrade( 3000, StockTrade.StockTradeIndicator.SELL, 12.75 );
    Assert.assertEquals( "Can retrieve trades within a given timeframe"
                       , 1
                       , stock.getTradesWithinTimeframe( elapsedMilliseconds ).size()
                       );
  }

  @Test
  public void canComputeVolumeWeightedStockPriceWithinTimeframe() {
    final Stock stock = new StockMock( "VWP", 10, 250 );
    stock.recordTrade( 1000, StockTrade.StockTradeIndicator.BUY , 10.25 );
    stock.recordTrade( 2000, StockTrade.StockTradeIndicator.BUY ,  7.50 );
    stock.recordTrade( 3000, StockTrade.StockTradeIndicator.SELL, 12.75 );
    final Double  delta          = 0.001;
    final Integer elapsedMinutes = 1;
    Assert.assertEquals( "Can compute VolumeWeightedStockPrice given an elapsed amount of time in minutes"
                       , 10.58
                       , stock.getVolumeWeightedStockPrice( elapsedMinutes )
                       , delta
                       );
  }

  @Test
  public void canComputeVolumeWeightedStockPriceOutsideTimeframe() {
    final Stock stock = new StockMock( "VWP", 10, 250 );
    stock.recordTrade( 1000, StockTrade.StockTradeIndicator.BUY , 10.25 );
    stock.recordTrade( 2000, StockTrade.StockTradeIndicator.BUY ,  7.50 );
    stock.recordTrade( 3000, StockTrade.StockTradeIndicator.SELL, 12.75 );
    final Double  delta          = 0.001;
    final Integer elapsedMinutes = 0;
    Assert.assertEquals( "Can compute VolumeWeightedStockPrice given an elapsed amount of time in minutes"
                       , 0.0
                       , stock.getVolumeWeightedStockPrice( elapsedMinutes )
                       , delta
                       );
  }

}