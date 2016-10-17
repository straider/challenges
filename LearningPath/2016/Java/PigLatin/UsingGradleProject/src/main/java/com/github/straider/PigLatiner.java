package com.github.straider;

public class PigLatiner {

    private static final String VOWELS = "aeiou";

    public String translate( String word ) {
        if ( word == null ) {
            return null;
        }

        final String reword;
        final String suffix;

        int index = new StringManipulator( word ).getIndexOfFirstVowel();

        if ( index < 0 ) {
            suffix = "";
            reword = word;
        } else if ( index == 0 ) {
            suffix = "way";
            reword = word;
        } else {
            suffix = "ay";

            final String cutConsonants = word.substring( 0, index ).toLowerCase();
            if ( Character.isUpperCase( word.charAt( 0 ) ) ) {
                reword = new StringManipulator( word.substring( index ) ).toTitlecase() + cutConsonants;
            } else {
                reword = word.substring( index ) + cutConsonants;
            }
        }

        return String.format( "%s%s", reword, suffix );
    }

}
