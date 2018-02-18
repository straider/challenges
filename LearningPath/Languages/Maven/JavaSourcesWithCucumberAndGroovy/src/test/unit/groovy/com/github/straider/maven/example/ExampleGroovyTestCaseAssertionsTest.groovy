package com.github.straider.maven.example

import groovy.transform.NotYetImplemented

class ExampleGroovyTestCaseAssertionsTest extends GroovyTestCase {

    private Random random

    void setUp() {
        super.setUp()

        random = new Random()
    }

    void tearDown() {
    }

    void testAssertions() {
        assertTrue( 1 == 1 )
        assertEquals( 'test', 'test' )

        def value = random.nextInt( 10 ** 3 )
        assertNotNull "x must not be null", value
        assertNull null

        assertSame value, value
        assertSame 'test', 'test'
    }

    void testScriptAssertions() {
        assertScript '''
            def x = 1
            def y = 2

            assert x + y == 3
        '''
    }

    void testInvalidIndexAccess1() {
        List numbers = [ 1, 2, 3, 4 ]

        shouldFail {
            numbers.get( 4 )
        }
    }

    void testInvalidIndexAccess2() {
        List numbers = [ 1, 2, 3, 4 ]

        shouldFail IndexOutOfBoundsException, {
            numbers.get( 4 )
        }
    }

    void testInvalidIndexAccess3() {
        List numbers = [ 1, 2, 3, 4 ]

        String message = shouldFail IndexOutOfBoundsException, {
            numbers.get( 4 )
        }
        assert message.contains( 'Index: 4, Size: 4' ) || message.contains( 'Index 4 out-of-bounds for length 4' )
    }

    void testNotYetImplemented1() {
        if ( notYetImplemented() ) return

        assert 1 == 2
    }

    @NotYetImplemented
    void testNotYetImplemented2() {
        assert 1 == 2
    }

}
