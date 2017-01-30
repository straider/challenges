package com.github.straider.springboot.springdata.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository< Customer, String > {

    public Customer findByFirstName( final String firstName );

    public List< Customer > findByLastName(final String lastName );

}
