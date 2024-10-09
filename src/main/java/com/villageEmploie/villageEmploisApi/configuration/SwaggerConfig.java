package com.villageEmploie.villageEmploisApi.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API village emploie Swagger")
                        .version("1.0")
                        .description("api pour bute un crud sur la base de données vdeCrudManagement"));
    }
}
