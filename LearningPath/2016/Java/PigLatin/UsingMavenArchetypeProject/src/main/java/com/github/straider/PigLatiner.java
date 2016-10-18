package com.github.straider;

public class PigLatiner {

    private static final String VOWELS = "aeiou";

    public String translate( String word ) {
        final String reword;
        final String suffix;

        final String firstLetter = word.substring( 0, 1 ).toLowerCase();
        if ( VOWELS.contains( firstLetter ) ) {
            suffix = "way";
            reword = word;
        } else {
            suffix = "ay";
            reword = word.substring( 1 ) + firstLetter;
        }

        return String.format( "%s%s", reword, suffix );
    }

}
