package com.asafeorneles.gym_stock_control;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Swagger Gym Stock Control", version = "1", description = "API for stock control of a gym equipment store."))
public class GymStockControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(GymStockControlApplication.class, args);
	}

}
