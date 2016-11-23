package com.github.straider.felix.producer;

public class HelloWorldServiceImplementation implements HelloWorldService {

    @Override
    public void say() {
        System.out.println( "Hello, World!" );
    }

}
