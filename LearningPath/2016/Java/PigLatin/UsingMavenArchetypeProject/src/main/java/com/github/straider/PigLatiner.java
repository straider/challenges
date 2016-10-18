package com.github.straider;

public class PigLatiner {

    private static final String VOWELS = "aeiou";

    public String translate( String word ) {
        final String reword;
        final String suffix;

        final Character firstLetter = word.charAt( 0 );
        if ( VOWELS.contains( firstLetter.toString() ) ) {
            suffix = "way";
            reword = word;
        } else {
            suffix = "ay";
            reword = word.substring( 1 ) + firstLetter;
        }

        return String.format( "%s%s", reword, suffix );
    }

}
