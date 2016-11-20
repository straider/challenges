package com.github.straider.camel;

public class OrderHelper {

    public boolean isXml(String body) {
        return body.startsWith( "<?xml" );
    }

    public boolean isCsv(String body) {
        return ! body.startsWith( "<?xml" );
    }

}
