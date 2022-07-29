package com.springboot.microservice.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SbMicroServiceGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbMicroServiceGatewayApplication.class, args);
	}

}
