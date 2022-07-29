package com.springboot.microservice.paymentservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentContoller {
	@GetMapping("/hello")
	public String showHello() {
		return "Hello from Payment Service";
	}
}
