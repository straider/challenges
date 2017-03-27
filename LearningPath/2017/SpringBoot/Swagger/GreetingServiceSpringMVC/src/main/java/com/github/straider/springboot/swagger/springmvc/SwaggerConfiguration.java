package com.github.straider.springboot.swagger.springmvc;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket swaggerSettings() {
        return new Docket( DocumentationType.SWAGGER_2 )
                .groupName( "GreetingService" )
                .apiInfo( apiInfo() )
                .select()
                .apis( RequestHandlerSelectors.any() )
                .paths( selectedPaths() )
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

    @SuppressWarnings( "unchecked" )
    private Predicate< String > selectedPaths() {
        return Predicates.or( PathSelectors.regex( "/ws/rest/.*" ) );
    }

}
