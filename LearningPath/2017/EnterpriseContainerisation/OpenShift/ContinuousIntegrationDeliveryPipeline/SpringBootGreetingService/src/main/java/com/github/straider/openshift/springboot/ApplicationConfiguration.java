package com.github.straider.openshift.springboot;

import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.provider.AbstractConfigurableProvider;
import org.apache.cxf.jaxrs.provider.json.JSONProvider;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.ArrayList;
import java.util.List;

@ComponentScan
@Configuration
public class ApplicationConfiguration {

    @Autowired
    private GreetingService greetingService;

    @Bean( destroyMethod = "shutdown" )
    public SpringBus cxf() {
        return new SpringBus();
    }

    @Bean( destroyMethod = "destroy" ) @DependsOn( "cxf" )
    public Server jaxRsServer() {
        final JAXRSServerFactoryBean serverFactory = new JAXRSServerFactoryBean();
        serverFactory.setServiceBean( greetingService );
        serverFactory.setBus( cxf() );
        serverFactory.setAddress( "/" );

        final JSONProvider                         jsonProvider = new JSONProvider();
        final List< AbstractConfigurableProvider > providers    = new ArrayList< AbstractConfigurableProvider >();
        providers.add( jsonProvider );
        serverFactory.setProviders( providers );

        return serverFactory.create();
    }

    @Bean
    public ServletRegistrationBean cxfServlet() {
        final ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean( new CXFServlet(), "/*" );

        servletRegistrationBean.setLoadOnStartup( 1 );

        return servletRegistrationBean;
    }

}
