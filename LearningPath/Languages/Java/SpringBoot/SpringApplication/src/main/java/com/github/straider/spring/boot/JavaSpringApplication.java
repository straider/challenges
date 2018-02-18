package com.github.straider.spring.boot;

import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JavaSpringApplication {

    private Logger log = Logger.getLogger( JavaSpringApplication.class );

    public static void main( final String[] arguments ) {
        final ConfigurableApplicationContext context = new SpringApplicationBuilder()
                .sources( JavaSpringApplication.class )
                .run( arguments );

        JavaSpringApplication application = context.getBean( JavaSpringApplication.class );
        application.start();
    }

    private void start() {
        log.info( "Hello, World!" );
    }

}
