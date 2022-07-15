package com.enums;

public class EmployeeEnums {
	private int id;
	private String city;
	private String name;
	private double salary;
	private Gender gender;
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "EmployeeEnums [id=" + id + ", city=" + city + ", name=" + name + ", salary=" + salary + ", gender="
				+ gender + "]";
	}
	
}
