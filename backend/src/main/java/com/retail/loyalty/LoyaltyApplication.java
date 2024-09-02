package com.retail.loyalty;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@OpenAPIDefinition
@ComponentScan("com.retail.loyalty.repository")
public class LoyaltyApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoyaltyApplication.class, args);
	}

}
