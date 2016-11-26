package com.github.straider.fuse.camel

import org.apache.camel.builder.RouteBuilder

/**
 * A Camel Groovy DSL Router
 */
class MyRouteBuilder extends RouteBuilder {

    /**
     * Let's configure the Camel routing rules using Groovy code...
     */
    void configure() {
        from("jetty:http://0.0.0.0:8080")
          .transform { 'Today is ' + new Date() }
    }

}
