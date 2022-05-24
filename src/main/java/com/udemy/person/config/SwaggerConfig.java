package com.udemy.person.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
        info = @Info(
                title = "CRUD Person/Book",
                description = "Rest API - Udemy Course",
                version = "0.0.0",
                contact = @Contact(
                        name = "Igor de Souza Bezerra",
                        email = "igor.souza1.bezerra@gmail.com",
                        url = "http://localhost:8080/swagger-ui/index.html"
                ),
                license = @License(name = "MIT")
        ))
public class SwaggerConfig {

}
