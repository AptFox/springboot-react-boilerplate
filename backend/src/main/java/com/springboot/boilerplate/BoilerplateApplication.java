package com.springboot.boilerplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BoilerplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoilerplateApplication.class, args);
	}

	// Access DB at:  http://localhost:8080/h2-console
		// Once there, DB URL: jdbc:h2:mem:testdb
		//Note: H2, In-memory DB. cleared each time app restarts. Re-populated from data.sql
}
