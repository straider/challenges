package com.github.straider.camel;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement( name = "Customer" )
public class CustomerModel {

    private long   id;
    private String name;
    private Date   lastUpdated;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

}
