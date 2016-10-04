package com.github.straider

class HelloWorldTest extends GroovyTestCase {

    void testDefaultGreeting() {
        HelloWorld instance = new HelloWorld()
        assert instance.greet() == 'Hello, World!'
    }

}