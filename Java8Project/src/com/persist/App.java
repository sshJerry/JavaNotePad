package com.persist;

import java.util.List;

import com.persist.Service.EmployeeService;

public class App {
	public static void main(String[] args) {
		EmployeeService employeeService = new EmployeeService();
		List<Employee> list = employeeService.getEmployeeList();
		for (Employee e : list) {
			System.out.println(e);
		}
		double totalSal = employeeService.totalSalary(list);
		System.out.println("Total EMp Salary: " + totalSal);
		
		System.out.println("All Employee Cities");
		// Wrote this first: employeeService.getAllCities(list)
		// Then this Second: List<String> listCity
		// Simple way of generating the method in class
		List<String> listCity = employeeService.getAllCities(list);
		listCity.stream().forEach(e->System.out.println(e));
	}
}
