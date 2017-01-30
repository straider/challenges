package com.github.straider.springboot.springdata.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private CustomerRepository repository;

    public static void main( final String[] arguments ) {
        SpringApplication.run( Application.class, arguments );
    }

    @Override
    public void run( final String... arguments ) throws Exception {
        repository.deleteAll();

        // save a couple of customers
        repository.save( new Customer( "Alice", "Smith" ) );
        repository.save( new Customer( "Bob"  , "Smith" ) );

        // fetch all customers
        System.out.println( "Customers found with findAll():" );
        System.out.println( "-------------------------------" );
        for ( final Customer customer : repository.findAll() ) {
            System.out.println( customer );
        }
        System.out.println();

        // fetch an individual customer
        System.out.println( "Customer found with findByFirstName('Alice'):" );
        System.out.println( "---------------------------------------------" );
        System.out.println( repository.findByFirstName( "Alice" ) );
        System.out.println();

        System.out.println( "Customers found with findByLastName('Smith'):" );
        System.out.println( "---------------------------------------------" );
        for ( final Customer customer : repository.findByLastName( "Smith" ) ) {
            System.out.println( customer );
        }
        System.out.println();
    }

}
