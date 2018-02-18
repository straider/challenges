package com.github.straider.springboot.springdata.mongodb;

import org.springframework.data.annotation.Id;

public class Person {

    @Id
    private String id;

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
