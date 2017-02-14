package com.github.straider.openshift.springboot;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GreeterSimpleTest {

    private Greeter greeter;

    @Before
    public void setUp() {
        greeter = new Greeter();
    }

    @Test
    public void testGreeterCanSayHelloWorld() {
        assertEquals( "Hello, World!", greeter.speak() );
    }

    @Test
    public void testGreeterCanSayHelloToSomeone() {
        assertEquals( "Hello, José!", greeter.speak( "José" ) );
    }

}