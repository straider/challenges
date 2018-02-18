package com.github.straider.springboot

import cucumber.api.groovy.EN
import cucumber.api.groovy.Hooks
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.context.ConfigurableApplicationContext

import static org.springframework.boot.SpringApplication.exit
import static org.springframework.boot.SpringApplication.run

this.metaClass.mixin( Hooks )
this.metaClass.mixin( EN    )

World {
}

ConfigurableApplicationContext context

Before {
    if ( ! context ) {
        context = run Application

        context.addShutdownHook {
            exit context
        }
    }

    restTemplate = new TestRestTemplate()
}
