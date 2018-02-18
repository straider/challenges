package com.github.straider.camel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
@XmlAccessorType( XmlAccessType.FIELD )
public class Order implements Serializable {

    @XmlAttribute private String  name;
    @XmlAttribute private Integer amount;

    public Order() {
    }

    public Order( final String name, final Integer amount) {
        this.name   = name;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format( "Order[%s: %d]", name, amount );
    }

}
