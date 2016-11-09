package com.github.straider.maven.example

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

@RunWith( Cucumber.class )
@CucumberOptions(
        glue     = 'com.github.straider.maven.example',
        features = 'classpath:resources/features/'
)
class IntegrationRunner {
}
