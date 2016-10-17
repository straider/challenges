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

}