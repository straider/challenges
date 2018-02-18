package com.github.straider;

public class StringManipulator {

    private static final String VOWELS = "aeiou";

    private final String string;

    public StringManipulator( String string ) {
        this.string = string;
    }

    public String toTitlecase() {
        return string.substring( 0, 1 ).toUpperCase() + string.substring( 1 );
    }

    public int getIndexOfFirstVowel() {
        int index = -1;

        for ( int at = 0; at < string.length(); at++ ) {
            if ( VOWELS.contains( Character.toString( string.charAt( at ) ).toLowerCase() ) ) {
                index = at;
                break;
            }
        }

        return index;
    }

}
