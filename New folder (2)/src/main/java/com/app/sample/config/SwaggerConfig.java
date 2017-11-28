package com.app.sample.config;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    @Profile("swagger")
    public Docket connectorApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(new ApiInfo(
                "User Crud Server",
                "User Crud Server to perform event level operations"
                , "1.0", null, "User Crud", null, null))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.app.sample.controllers"))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .directModelSubstitute(LocalDate.class,
                        String.class)
                .genericModelSubstitutes(ResponseEntity.class)

                .useDefaultResponseMessages(false);
    }
}
