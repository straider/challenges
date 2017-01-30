package com.github.straider.springboot.springdata.mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main( final String[] arguments ) {
        System.getProperties().put( "server.port", 10000 );
        SpringApplication.run( Application.class, arguments );
    }

}
