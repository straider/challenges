package com.github.straider.springboot.springmvc.swagger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

@XmlRootElement( name = "ResponseModel" )
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( propOrder = { "message", "requestOn", "responseOn" } )
public class ResponseModel {

    @XmlElement( required = true, name ="request-on"  ) private Date   requestOn;
    @XmlElement( required = true, name ="response-on" ) private Date   responseOn;
    @XmlElement( required = true, name ="message"     ) private String message;

    public ResponseModel() {
        requestOn = new Date();
    }

    public void setResponseOn() {
        responseOn = new Date();
    }

    public void setMessage( final String message ) {
        this.message = message;
    }

}
