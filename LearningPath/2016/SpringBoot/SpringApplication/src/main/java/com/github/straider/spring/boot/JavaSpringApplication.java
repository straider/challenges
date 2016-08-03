package com.github.straider.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaSpringApplication {

    public static void main( final String[] arguments ) {
        SpringApplication.run( JavaSpringApplication.class, arguments );

        System.out.println( "Hello, World!" );
    }

}
