package com.springboot.backend.controller;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.model.Customer;
import com.springboot.backend.model.CustomerProduct;
import com.springboot.backend.model.Product;
import com.springboot.backend.repository.CustomerProductRepository;
import com.springboot.backend.repository.CustomerRepository;
import com.springboot.backend.repository.ProductRepository;

@RestController
public class CustomerProductController {
	@Autowired
	private CustomerProductRepository customerProductRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ProductRepository productRepository;
	
	@PostMapping("/customer/product/{cid}/{pid}")
	public CustomerProduct purchaseAPi(@PathVariable("cid") Long cid, @PathVariable("pid") Long pid,
			@RequestBody CustomerProduct cp) {
		Optional<Customer> optionalC = customerRepository.findById(cid);
		if(!optionalC.isPresent()) 
			throw new RuntimeException("Invalid Customer ID Given");
		
		Optional<Product> optionalP = productRepository.findById(pid);
		if(!optionalP.isPresent()) 
			throw new RuntimeException("Invalid Product ID Given");
		
		Customer c = optionalC.get();
		Product p = optionalP.get();
		
		cp.setCustomer(c);
		cp.setProduct(p);
		
		cp.setDateOfPurchase(LocalDate.now());
		return customerProductRepository.save(cp);
		
	}
}
