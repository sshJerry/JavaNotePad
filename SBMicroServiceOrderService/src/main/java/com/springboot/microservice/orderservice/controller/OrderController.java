package com.springboot.microservice.orderservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	@GetMapping("/hello")
	public String showHello() {
		return "Hello from Order Service";
	}
}
