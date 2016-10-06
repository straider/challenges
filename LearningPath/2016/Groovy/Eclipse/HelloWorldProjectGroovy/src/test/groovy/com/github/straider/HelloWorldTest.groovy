package com.github.straider

import groovy.util.GroovyTestCase

class HelloWorldTest extends GroovyTestCase {

	void testDefaultGreeting() {
		HelloWorld instance = new HelloWorld()
		assert instance.greet() == 'Hello, World!'
	}

	void testGreetingSomeoneByName() {
		HelloWorld instance = new HelloWorld()
		assert instance.greet( 'José' ) == 'Hello, José!'
	}

}
