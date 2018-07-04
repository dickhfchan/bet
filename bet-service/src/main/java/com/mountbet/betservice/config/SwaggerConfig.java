package com.mountbet.betservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("Mountbet Bet Micro Service",
                "Provide micro services via REST APIs for processing any bet requests",
                "version 1.0.0",
                "http://www.mountbet.com",
                new Contact("Dick Hing Fung Chan", "http://www.mountbet.com", "dickchan@knode.co"),
                "License of API",
                "http://www.mountbet.com",
                Collections.emptyList());
    }
}