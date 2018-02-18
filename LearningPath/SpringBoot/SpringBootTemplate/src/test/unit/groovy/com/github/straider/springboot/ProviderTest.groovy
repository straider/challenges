package com.github.straider.springboot

import au.com.dius.pact.provider.junit.PactRunner
import au.com.dius.pact.provider.junit.Provider
import au.com.dius.pact.provider.junit.loader.PactFolder
import au.com.dius.pact.provider.junit.target.HttpTarget
import au.com.dius.pact.provider.junit.target.Target
import au.com.dius.pact.provider.junit.target.TestTarget
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.runner.RunWith
import org.springframework.boot.SpringApplication
import org.springframework.context.ConfigurableApplicationContext

@RunWith( PactRunner.class )
@PactFolder( 'pacts' )
@Provider( '[SERVICE_ARTIFACT_ID_CAMEL_CASE]' )
class ProviderTest {

    private static ConfigurableApplicationContext application

    @TestTarget
    public final Target target = new HttpTarget( 10000 )

    @BeforeClass
    static void startSpringBootApplication() {
        application = SpringApplication.run( Application.class )
    }

    @AfterClass
    static void stopSpringBootApplication() {
        application.stop()
    }

}
