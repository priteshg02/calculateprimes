package com.rest.find.primes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class FindPrimesApplication {

	public static void main(String[] args) {
		SpringApplication.run(FindPrimesApplication.class, args);
	}

}
