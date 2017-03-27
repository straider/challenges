package com.github.straider.springboot.swagger.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Application {

    public static void main( final String[] arguments ) {
        SpringApplication.run( Application.class, arguments );
    }

}