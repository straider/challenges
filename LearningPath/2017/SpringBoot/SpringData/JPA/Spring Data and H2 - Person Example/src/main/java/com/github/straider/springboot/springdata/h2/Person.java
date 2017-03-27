package com.github.straider.springboot.springdata.h2;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Person {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long id;

    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName( final String firstName ) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName( final String lastName ) {
        this.lastName = lastName;
    }

}
