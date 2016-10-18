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

        Assert.assertEquals( translation, "Appleway" );
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

}