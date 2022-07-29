package com.springboot.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.backend.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	@Query("select c from Customer c where c.account.id=?1")
	Customer getCustomerByAccountID(Long aid);
	@Query("select c from Customer c where c.account.type=?1")
	List<Customer> getCustomersByAccountType(String atype);
}
