package com.github.straider.springboot;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue
    private Long   id;
    private String firstName;
    private String lastName;
    private String description;

    private Employee() {}

    public Employee( final String firstName, final String lastName, final String description ) {
        this.firstName   = firstName;
        this.lastName    = lastName;
        this.description = description;
    }

}
