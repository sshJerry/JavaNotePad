package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
// Drop Customer or something droppable to test this.
@Entity	// -> This will create a table in the DB
@Table(name= "Customer")
public class Customer {
	
	@Id //this makes id a primary key
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	
	private String employeeId;
	
	private String firstName;
	
	private String lastName;
	
	private String username;
	
	private String password;
	
	private float balance;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int customerId, String employeeId, String firstName, String lastName, String username,
			String password, float balance) {
		super();
		this.customerId = customerId;
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.balance = balance;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	
	
}

/*
 * CREATE TABLE IF NOT EXISTS `quickbytesteam`.`Customer` ( 

  `customerId` INT NOT NULL AUTO_INCREMENT, 

  `employeeId` VARCHAR(45) NOT NULL, 

  `firstName` VARCHAR(45) NOT NULL, 

  `lastName` VARCHAR(45) NOT NULL, 

  `username` VARCHAR(45) NOT NULL, 

  `password` VARCHAR(45) NOT NULL, 

  `balance` FLOAT NOT NULL, 

  PRIMARY KEY (`customerId`)) */
 