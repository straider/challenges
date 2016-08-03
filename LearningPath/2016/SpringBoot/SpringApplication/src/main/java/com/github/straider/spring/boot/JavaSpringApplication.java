package com.github.straider.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JavaSpringApplication {

    public static void main( final String[] arguments ) {
        final ApplicationContext context = SpringApplication.run( JavaSpringApplication.class, arguments );

        System.out.println( "Hello, World!" );
    }

}
