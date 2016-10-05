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

}
