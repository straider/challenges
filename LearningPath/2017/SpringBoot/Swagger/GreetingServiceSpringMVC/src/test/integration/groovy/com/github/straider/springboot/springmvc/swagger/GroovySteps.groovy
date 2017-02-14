package com.github.straider.springboot.springmvc.swagger

import static cucumber.api.groovy.EN.Given
import static cucumber.api.groovy.EN.Then
import static cucumber.api.groovy.EN.When

Greeter greeter
String  name
String  message

Given( ~/^the default greeting format$/ ) { ->
    greeter = new Greeter()
}

Given( ~/^the (.*) is specific$/ ) { String greeting ->
    greeter = new Greeter()
    greeter.setGreeting( greeting )
}

When( ~/^a request to speak to (.*) is issued$/ ) { String someone ->
    name    = someone
    message = greeter.speak( someone )
}

Then( ~/^the response is (.+)$/ ) { String greeting ->
    assert greeting == message
}
