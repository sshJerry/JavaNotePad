package com.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.model.Tester;

public class TesterService {

	public List<Tester> fetchAllEmployee(EntityManager entityManager) {
		List<Tester> list =
				entityManager.createQuery("select t from Tester t", Tester.class)
				.getResultList();
		return list;
	}

	public List<Tester> fetchTesterByDepartment(EntityManager entityManager, int did) {
		Query query = entityManager
				.createQuery("select t from Tester t where t.department.id=:did", Tester.class);
		query.setParameter("did", did);
		List<Tester> list = query.getResultList();
		return list;
	}

}
