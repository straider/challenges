package com.github.straider.springboot.springmvc.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Application {

    public static void main( final String[] arguments ) {
        SpringApplication.run( Application.class, arguments );
    }

    @Bean
    public Docket swaggerSettings() {
        return new Docket( DocumentationType.SWAGGER_2 )
                .groupName( "GreetingService" )
                .apiInfo( apiInfo() )
                .select()
                .apis( RequestHandlerSelectors.any() )
                .paths( PathSelectors.regex( "/ws/rest/.*" ) )
                .build()
                ;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title( "REST Greeting Service with Swagger" )
                .description( "Spring MVC REST Greeting Service documented by Swagger." )
                .contact( "Jose Carlos Monteiro" )
                .version( "2.0" )
                .build();
    }

}