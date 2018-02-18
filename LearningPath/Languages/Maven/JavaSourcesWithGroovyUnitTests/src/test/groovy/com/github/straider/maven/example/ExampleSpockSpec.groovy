package com.github.straider.maven.example

import spock.lang.Specification

class ExampleSpockSpec extends Specification {

    def 'adding an element leads to size increase'() {
        setup: 'a new stack instance is created'
            Stack stack = new Stack()

        when:
            stack.push 42

        then:
            stack.size() == 1
    }

}
