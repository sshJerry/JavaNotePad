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
	}
}
