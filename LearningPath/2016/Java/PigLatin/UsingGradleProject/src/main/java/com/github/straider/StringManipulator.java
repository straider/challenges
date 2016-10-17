package com.github.straider;

public class StringManipulator {

    private final String string;

    public StringManipulator( String string ) {
        this.string = string;
    }

    public String toTitlecase() {
        return string.substring( 0, 1 ).toUpperCase() + string.substring( 1 );
    }

}
