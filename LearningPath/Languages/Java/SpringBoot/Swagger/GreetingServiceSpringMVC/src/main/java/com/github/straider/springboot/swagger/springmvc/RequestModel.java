package com.github.straider.springboot.swagger.springmvc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement( name = "request" )
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( propOrder = { "name" } )
public class RequestModel {

    @XmlElement( required = true, name ="name" ) private String name;

    public String getName() {
        return name;
    }

    public void setName( final String name ) {
        this.name = name;
    }

}
