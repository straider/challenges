package com.github.straider.springboot.swagger.springmvc

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

@RunWith( Cucumber.class )
@CucumberOptions( features = 'classpath:features/' )
class GroovyIntegrationRunner {
}
