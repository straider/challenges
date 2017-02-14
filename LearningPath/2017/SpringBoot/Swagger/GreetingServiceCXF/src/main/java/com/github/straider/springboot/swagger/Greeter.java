package com.github.straider.springboot.swagger;

public class Greeter {

    private static final String DEFAULT_GREETING = "Hello";
    private static final String DEFAULT_NAME     = "World";
    private static final String MESSAGE_FORMAT   = "%s, %s!";

    private String greeting;

    public Greeter() {
        greeting = DEFAULT_GREETING;
    }

    public String speak( final String name ) {
        final String nameOrWorld = ( name == null || name.length() == 0 ) ? DEFAULT_NAME : name ;

        return String.format( MESSAGE_FORMAT, greeting, nameOrWorld );
    }

    public String speak() {
        return speak( DEFAULT_NAME );
    }

    public void setGreeting( final String greeting ) {
        this.greeting = ( greeting == null || greeting.length() == 0 ) ? DEFAULT_GREETING : greeting;
    }

}
