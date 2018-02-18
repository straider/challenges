package com.github.straider

class HelloWorldTest extends GroovyTestCase {

    void setUp() {
        super.setUp()
    }

    void tearDown() {
    }

    void testDefaultGreeting() {
        HelloWorld instance = new HelloWorld()
        assert instance.greet() == 'Hello, World!'
    }

    void testGreetingSomeoneByName() {
        HelloWorld instance = new HelloWorld()
        assert instance.greet( 'José' ) == 'Hello, José!'
    }

}
