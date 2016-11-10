package com.github.straider.maven.example

import static cucumber.api.groovy.EN.Given
import static cucumber.api.groovy.EN.Then
import static cucumber.api.groovy.EN.When

int valueA, valueB, valueC

Given(~/^two numbers: (\d+), (\d+)$/) { int a, int b ->
    ( valueA, valueB ) = [ a, b ]
}

When(~/^added together$/) { ->
    valueC = valueA + valueB
}

Then(~/^the result is (\d+)$/) { int c ->
    assert c == valueC
}