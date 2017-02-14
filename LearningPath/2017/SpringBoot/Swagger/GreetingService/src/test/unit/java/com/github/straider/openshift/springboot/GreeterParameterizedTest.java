package com.github.straider.openshift.springboot;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith( Parameterized.class )
public class GreeterParameterizedTest {

    private Greeter greeter;

    private String name;
    private String message;
    private String greeting;

    public GreeterParameterizedTest( final String greeting, final String name, final String message ) {
        this.name     = name;
        this.message  = message;
        this.greeting = greeting;
    }

    @Before
    public void setUp() {
        greeter = new Greeter();
    }

    @Test
    public void testGreeterCanGreetSomeoneInDifferentFormats() {
        greeter.setGreeting( greeting );
        assertThat( greeter.speak( name ), is( message ) );
    }
    @Parameterized.Parameters
    public static Iterable< Object[] > nameAndMessageWithFormat() {
        return Arrays.asList(
                new Object[][] {
                        { null       , null       , "Hello, World!"         },
                        { ""         , ""         , "Hello, World!"         },
                        { "Hi"       , "José"     , "Hi, José!"             },
                        { "Greetings", "earthling", "Greetings, earthling!" }
                }
        );
    }

}