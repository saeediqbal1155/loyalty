package com.retail.loyalty;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@EnableR2dbcRepositories
@OpenAPIDefinition
public class LoyaltyApplication {
	public static void main(String[] args) {
		SpringApplication.run(LoyaltyApplication.class, args);
	}

}
