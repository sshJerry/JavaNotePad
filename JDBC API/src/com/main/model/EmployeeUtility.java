package com.main.model;

import java.util.List;

public class EmployeeUtility {

	public boolean validateId(List<Employee> list, int id) {
		boolean isPresent =false;
		for(Employee e :list) {
			if(e.getId() == id) {
				isPresent = true;
				break;
			}
		}
		return isPresent;
	}
}
