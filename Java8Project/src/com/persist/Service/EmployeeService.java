package com.persist.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.main.db.DB;
import com.persist.Employee;

public class EmployeeService {
	List<Employee> list;
	DB db;

	public List<Employee> getEmployeeList() {
		db = new DB();
		list = db.getEmployeeList();
		return list;
	}
	public double totalSalary(List<Employee> list) {
		double sum = list.stream().collect(Collectors.summingDouble(e->e.getSalary()));
		return sum;
	}
	public List<String> getAllCities(List<Employee> list2) {
		List<String> cities = list.stream().map(e->e.getCity()).collect(Collectors.toList());
		//e -> e.getCity()
		return cities;
	}
}
