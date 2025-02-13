package com.example.LdEx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//localhost:8080/rooms

@SpringBootApplication
@ComponentScan(basePackages = "com.example.LdEx")
public class LdExApplication {

	public static void main(String[] args) {
		SpringApplication.run(LdExApplication.class, args);
	}

}
