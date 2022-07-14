package com.persist.Service;

import java.util.List;

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

}
