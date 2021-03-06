package com.github.straider;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PigLatinerTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void translationOfLowercaseWordStartingWithVowel() throws Exception {
        PigLatiner translator = new PigLatiner();
        final String translation = translator.translate( "apple" );

        Assert.assertEquals( "appleway", translation );
    }

    @Test
    public void translationOfTitlecaseWordStartingWithVowel() throws Exception {
        PigLatiner translator = new PigLatiner();
        final String translation = translator.translate( "Apple" );

        Assert.assertEquals( "Appleway", translation );
    }

    @Test
    public void translationOfLowercaseWordStartingWithConsonant() throws Exception {
        PigLatiner translator = new PigLatiner();
        final String translation = translator.translate( "hello" );

        Assert.assertEquals( "ellohay", translation );
    }

    @Test
    public void translationOfTitlecaseWordStartingWithConsonant() throws Exception {
        PigLatiner translator = new PigLatiner();
        final String translation = translator.translate( "Hello" );

        Assert.assertEquals( "Ellohay", translation );
    }

    @Test
    public void translationOfTitlecaseWordStartingWithConsonantAndHavingAccentedCharacters() throws Exception {
        PigLatiner translator = new PigLatiner();
        final String translation = translator.translate( "José" );

        Assert.assertEquals( "Oséjay", translation );
    }

    @Test
    public void translationOfLowercaseWordStartingWithConsonants() throws Exception {
        PigLatiner translator = new PigLatiner();
        final String translation = translator.translate( "chest" );

        Assert.assertEquals( "estchay", translation );
    }

    @Test
    public void translationOfTitlecaseWordStartingWithConsonants() throws Exception {
        PigLatiner translator = new PigLatiner();
        final String translation = translator.translate( "CheEse" );

        Assert.assertEquals( "EEsechay", translation );
    }

    @Test
    public void translationOfLowercaseWordWithoutVowels() throws Exception {
        PigLatiner translator = new PigLatiner();
        final String translation = translator.translate( "sky" );

        Assert.assertEquals( "sky", translation );
    }

    @Test
    public void translationOfUppercaseWordWithoutVowels() throws Exception {
        PigLatiner translator = new PigLatiner();
        final String translation = translator.translate( "SKY" );

        Assert.assertEquals( "SKY", translation );
    }

    @Test
    public void translationOfTitlecaseWordWithoutVowels() throws Exception {
        PigLatiner translator = new PigLatiner();
        final String translation = translator.translate( "Sky" );

        Assert.assertEquals( "Sky", translation );
    }

    @Test
    public void translationOfSingleVowel() throws Exception {
        PigLatiner translator = new PigLatiner();

        String translation;

        translation = translator.translate( "I" );
        Assert.assertEquals( "Iway", translation );

        translation = translator.translate( "a" );
        Assert.assertEquals( "away", translation );
    }

    @Test
    public void translationOfEmptyString() throws Exception {
        PigLatiner translator = new PigLatiner();
        final String translation = translator.translate( "" );

        Assert.assertEquals( "", translation );
    }

    @Test
    public void translationOfNullString() throws Exception {
        PigLatiner translator = new PigLatiner();
        final String translation = translator.translate( null );

        Assert.assertNull( translation );
    }

}