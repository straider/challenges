package com.github.straider;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringManipulatorTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void convertToTitlecase() throws Exception {
        StringManipulator manipulator = new StringManipulator( "hello" );
        Assert.assertEquals( "Hello", manipulator.toTitlecase() );
    }

    @Test
    public void convertToTitlecaseWithAccentedCharacters() throws Exception {
        StringManipulator manipulator = new StringManipulator( "água" );
        Assert.assertEquals( "Água", manipulator.toTitlecase() );
    }

    @Test
    public void convertToTitlecaseWithMixedcaseCharacters() throws Exception {
        StringManipulator manipulator = new StringManipulator( "camelCase" );
        Assert.assertEquals( "CamelCase", manipulator.toTitlecase() );
    }

    @Test
    public void getIndexOfFirstVowel() throws Exception {
        StringManipulator manipulator;

        manipulator= new StringManipulator( "apple" );
        Assert.assertEquals( "Index should be 0", 0, manipulator.getIndexOfFirstVowel() );

        manipulator = new StringManipulator( "hello" );
        Assert.assertEquals( "Index should be 1", 1, manipulator.getIndexOfFirstVowel() );

        manipulator = new StringManipulator( "cheese" );
        Assert.assertEquals( "Index should be 2", 2, manipulator.getIndexOfFirstVowel() );
    }

    @Test
    public void getIndexOfFirstVowelFromEmptyString() throws Exception {
        StringManipulator manipulator;

        manipulator= new StringManipulator( "" );
        Assert.assertEquals( -1, manipulator.getIndexOfFirstVowel() );
    }

}