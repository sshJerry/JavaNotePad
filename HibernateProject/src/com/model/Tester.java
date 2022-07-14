package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
// WORKS
@Entity	// -> This will create a table in the DB
@Table(name= "Tester")
public class Tester {
	@Id //this makes id a primary key
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String firstName;
	private String lastName;
	@OneToOne //This will create department_id (FK) in Tester table in DB
	private Department department;
	public Tester() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tester(int id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Tester [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", department=" + department
				+ "]";
	}

}
