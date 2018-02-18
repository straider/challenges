package com.github.straider.spring.boot

import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class GroovySpringApplication {

    Logger log = Logger.getLogger( GroovySpringApplication.class );

    static main( arguments ) {
        final ConfigurableApplicationContext context = new SpringApplicationBuilder()
                .sources( GroovySpringApplication.class )
                .run( arguments );

        GroovySpringApplication application = context.getBean( GroovySpringApplication.class );
        application.start();
    }

    def start() {
        log.info( 'Hello, World!' );
    }

}
