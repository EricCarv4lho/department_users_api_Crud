package com.example.myproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI customAPI() {
		return new OpenAPI().info(new Info().version("Version 1.0.0").title("API CRUD Users and Department")
				.description("API para gestão de usuários e departamentos."));
	}

}
