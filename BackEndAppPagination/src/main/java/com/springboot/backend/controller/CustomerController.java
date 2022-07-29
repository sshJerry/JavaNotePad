package com.springboot.backend.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.model.Customer;
import com.springboot.backend.repository.CustomerRepository;

@RestController
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepository;
	
	@PostMapping("/customer")
	public void postCustomer(@RequestBody Customer customer){
		customerRepository.save(customer);
	}
	@GetMapping("/customer")
	public List<Customer> getAllCustomer(@RequestBody Customer customer){
		List<Customer> list =customerRepository.findAll();
		return list;
	}
	@GetMapping("/customer/{cid}")
	public Customer getCustomerByID(@PathVariable("cid") Long id){
		Optional<Customer> optional = customerRepository.findById(id);
		if(!optional.isPresent())
			throw new RuntimeException("ID Doesn't Exist");
		return optional.get();
	}
	@DeleteMapping("/customer/{cid}")
	public void deleteCustomerByID(@PathVariable("cid") Long id){
		customerRepository.deleteById(id);
	}
	@PutMapping("/customer/{cid}")
	public void updateCustomerByID(@PathVariable("cid") Long id,
			@RequestBody Customer updateCustomer){
		Optional<Customer> optional = customerRepository.findById(id);
		if(!optional.isPresent())
			throw new RuntimeException("ID Doesn't Exist");
		Customer currentRepository = optional.get();
		currentRepository.setName(updateCustomer.getName());
		currentRepository.setAge(updateCustomer.getAge());
		currentRepository.setAccount(updateCustomer.getAccount());
		customerRepository.save(currentRepository);
	}
	@GetMapping("/customer/account/{aid}")
	public Customer getCustomerByAccountID(@PathVariable("aid") Long aid){
		return null;
	}
	@GetMapping("/customer/account/{atype}")
	public List<Customer> getCustomersByAccountType(@PathVariable("atype") String atype){
		List<Customer> list = customerRepository.getCustomersByAccountType(atype);
		return list;
	}
}
