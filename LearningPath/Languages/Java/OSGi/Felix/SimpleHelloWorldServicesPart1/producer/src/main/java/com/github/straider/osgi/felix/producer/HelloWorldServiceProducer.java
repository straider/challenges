package com.github.straider.osgi.felix.producer;

import com.github.straider.osgi.felix.common.HelloWorldService;

public class HelloWorldServiceProducer implements HelloWorldService {

    public void say() {
        System.out.println( "Hello, World!" );
    }

}
