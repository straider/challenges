package com.github.straider.springboot.springmvc.swagger

import spock.lang.Specification
import spock.lang.Unroll

class GreeterSpec extends Specification {

    Greeter greeter

    void setup() {
        greeter = new Greeter()
    }

    void cleanup() {
    }

    def "Greeter can say 'Hello, World!'"() {
        given:
        String message = 'Hello, World!'

        expect:
        message == greeter.speak()
    }

    @Unroll
    def "Greeter can greet #name"() {
        expect:
        message == greeter.speak( name )

        where:
        name          | message
        'José'        | 'Hello, José!'
        'José Carlos' | 'Hello, José Carlos!'
    }

    @Unroll
    def "Greeter can greet #name with #format"() {
        expect:
        greeter.setGreeting( format )
        message == greeter.speak( name )

        where:
        format      | name        | message
        null        | null        | 'Hello, World!'
        ''          | ''          | 'Hello, World!'
        'Hi'        | 'José'      | 'Hi, José!'
        'Greetings' | 'earthling' | 'Greetings, earthling!'
    }

}
