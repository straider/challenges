package com.github.straider.camel;

import org.apache.camel.main.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimerMain extends Main {

    private static final Logger logger = LoggerFactory.getLogger( TimerMain.class );

    public static void main( final String[] arguments ) {
        Main main = new TimerMain();
    }

}
