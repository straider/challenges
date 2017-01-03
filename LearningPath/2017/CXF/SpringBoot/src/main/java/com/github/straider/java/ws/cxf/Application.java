package com.github.straider.java.ws.cxf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    public static void main( final String[] arguments ) {
        SpringApplication.run( Application.class, arguments );
    }

    @Override
    protected SpringApplicationBuilder configure( final SpringApplicationBuilder application ) {
        return application.sources( Application.class );
    }

}