package com.github.straider.java.ws.cxf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Server {

    private static final String  DEFAULT_HOST = "localhost";
    private static final Integer DEFAULT_PORT = 10000;

    public static void main( final String[] arguments ) {
        SpringApplication.run( Server.class, arguments );
    }

}
