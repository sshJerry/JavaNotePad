package com.service;

import java.util.List;

import javax.persistence.EntityManager;

import com.model.Department;

public class DepartmentService {

	public Department fetchDeptObject(List<Department> listDept, int did) {
		for (Department d: listDept) {
			if(d.getId()== did)
				return d;
		}
		return null;
	}

	public List<Department> fetchAllDepartments(EntityManager entityManager) {
		List<Department> list =
				entityManager.createQuery("select d from Department d", Department.class)
				.getResultList();
		return list;
	}

}
