package com.github.straider.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitialiser implements CommandLineRunner {

    private final EmployeeRepository repository;

    @Autowired
    public DatabaseInitialiser( final EmployeeRepository repository ) {
        this.repository = repository;
    }

    @Override
    public void run( final String... arguments ) throws Exception {
        this.repository.save( new Employee( "Frodo", "Baggins", "ring bearer" ) );
    }

}
