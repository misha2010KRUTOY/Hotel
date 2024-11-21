package com.hotelbooking.touroperatorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableFeignClients
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.hotelbooking.touroperatorservice.repository")
@EntityScan(basePackages = "com.hotelbooking.touroperatorservice.model")

public class TourOperatorServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(TourOperatorServiceApplication.class, args);
	}
}
