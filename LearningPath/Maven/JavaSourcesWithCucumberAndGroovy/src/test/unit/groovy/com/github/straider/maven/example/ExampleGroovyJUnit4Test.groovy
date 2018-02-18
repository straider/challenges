package com.github.straider.maven.example

import org.junit.Test

import static groovy.test.GroovyAssert.shouldFail

class ExampleGroovyJUnit4Test {

    @Test
    void indexOutOfBoundsAccess() {
        List numbers = [ 1, 2, 3, 4 ]
        shouldFail {
            numbers.get( 4 )
        }
    }

    @Test
    void shouldFailReturn() {
        def exception = shouldFail {
            throw new RuntimeException( 'foo', new RuntimeException( 'bar' ) )
        }

        assert exception instanceof RuntimeException
        assert exception.message == 'foo'
        assert exception.cause.message == 'bar'
    }

}
