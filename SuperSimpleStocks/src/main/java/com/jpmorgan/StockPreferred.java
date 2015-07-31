package com.jpmorgan;

import java.util.List;
import java.util.ArrayList;

public class StockPreferred extends StockBase implements Stock {

  private final Integer fixedDividend;

  public StockPreferred( final String  symbol
                       , final Integer lastDividend
                       , final Integer fixedDividend
                       , final Integer parValue
                       ) {
    super( symbol, lastDividend, parValue );
    this.fixedDividend = fixedDividend;
  }

  @Override
  public Double getDividendYield( final Double marketShare ) {
    final Double result = fixedDividend / 100.0 * parValue / marketShare;
    return Math.round( result * 100.0 ) / 100.0;
  }

}