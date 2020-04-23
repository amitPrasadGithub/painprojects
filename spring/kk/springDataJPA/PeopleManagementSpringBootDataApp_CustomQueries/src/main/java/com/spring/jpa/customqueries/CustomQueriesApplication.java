package com.spring.jpa.customqueries;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomQueriesApplication implements CommandLineRunner {
	
	
	@Override
	public void run(String... args) throws Exception {
		com.spring.jpa.customqueries.byMethodNames.Client methodNames = new com.spring.jpa.customqueries.byMethodNames.Client();
		methodNames.singleParameter();
		methodNames.multipleParameter();
	}

	public static void main(String[] args) {
		SpringApplication.run(CustomQueriesApplication.class, args);
	}

}
