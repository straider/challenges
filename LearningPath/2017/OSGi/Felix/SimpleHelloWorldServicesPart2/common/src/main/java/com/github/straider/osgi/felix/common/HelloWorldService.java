package com.github.straider.osgi.felix.common;

public interface HelloWorldService {

    String INTERFACE_NAME = HelloWorldService.class.getName();

    void say();

}
