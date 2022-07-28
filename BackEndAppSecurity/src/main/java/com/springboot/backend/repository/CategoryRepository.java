package com.springboot.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.backend.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	@Query("select c from Category c where c.preference=?1")
	// ? is a wild card, 1 is the position of the argument (preference)
	List<Category> findByPreference(Integer preference);
}
//JPQL: Game Changer
