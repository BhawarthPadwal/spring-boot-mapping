package com.bhawarth.springBootMapping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootMappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMappingApplication.class, args);
	}

}
