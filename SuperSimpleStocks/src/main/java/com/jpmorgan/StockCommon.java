package com.jpmorgan;

import java.util.List;
import java.util.ArrayList;

public class StockCommon extends StockBase implements Stock {

  public StockCommon( final String  symbol
                    , final Integer lastDividend
                    , final Integer parValue
                    ) {
    super( symbol, lastDividend, parValue );
  }

  @Override
  public Double getDividendYield( final Double marketShare ) {
    final Double result = lastDividend / marketShare;
    return Math.round( result * 100.0 ) / 100.0;
  }

}