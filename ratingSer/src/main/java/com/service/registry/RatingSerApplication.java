package com.service.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RatingSerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingSerApplication.class, args);
	}

}
