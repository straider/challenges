package com.github.straider.springboot

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

@RunWith( Cucumber.class )
@CucumberOptions(
        features = 'classpath:features/',
        format   = [ 'json:target/cucumber-IT.json' ]
)
class GroovyIntegrationRunner {
}
