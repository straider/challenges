package com.github.straider.springboot;

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
                .groupName( "Spring Boot and React" )
                .apiInfo( apiInfo() )
                .select()
                .apis( RequestHandlerSelectors.basePackage( "com.github.straider.springboot" ) )
                .paths( PathSelectors.any() )
                .build()
                ;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title( "React.js and Spring Data REST" )
                .description( "https://spring.io/guides/tutorials/react-and-spring-data-rest/" )
                .version( "1.0.0" )
                .build();
    }

}
