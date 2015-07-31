package com.jpmorgan;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.Assert;

public class StockCommonTest {

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  @Test
  public void hasNoTradesAfterCreation() {
    final Stock newStock = new StockCommon( "NEW", 0, 100 );
    Assert.assertEquals( "After creation the stock trades is empty", 0, newStock.getAllTrades().size() );
  }

  @Test
  public void canComputeDividendYield() {
    final Stock  stock       = new StockCommon( "FOO", 10, 100 );
    final Double marketShare = 10.0;
    final Double delta       = 0.001;
    Assert.assertEquals( "Can Compute DividendYield", 1.0, stock.getDividendYield( marketShare ), delta );
  }

}