package com.springboot.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.model.Category;
import com.springboot.backend.repository.CategoryRepository;

@RestController
public class CategoryController {
	@Autowired //<- Sping will wire it to Category Repository interface
	private CategoryRepository categoryRepository;
	// GET POST PUT DELETE
	@GetMapping("/hello")
	public String sayHello() { //REST API: Representational State Transfer
		//Takes request, does processing, transfers response back and forgets about it
		return "Hello All!! Welcome to Spring";
	}
	@PostMapping("/category")
	public void postCategory(@RequestBody Category category) {
		//We Use JPARepository Interface
		categoryRepository.save(category);
	}
	@GetMapping("/category")
	public List<Category> getAllCategories(){
		List<Category> list = categoryRepository.findAll();
		return list;
	}
	@GetMapping("/category/single/{id}")
	public Category getSingleCategoryById(@PathVariable("id") Long id) {
		Optional <Category> optional = categoryRepository.findById(id);
		if(optional.isPresent())
			return optional.get();
		throw new RuntimeException("ID is invalid");
	}
	@DeleteMapping("/category/{id}")
	public void deleteCategory(@PathVariable("id") Long id) {
		categoryRepository.deleteById(id);
	}
	@PutMapping("/category/{id}")
	public void updateCategory(@PathVariable("id") Long id,//Take the ID as Path Variable
			@RequestBody Category newCategory) {//Ask for the new values: Read as RequestBody: NR
	
		//Fetch the record from the DB using the ID
		Optional<Category> optional = categoryRepository.findById(id);
		
		if(optional.isPresent()) {
			Category existingCategory = optional.get();
			// Replace existing record with new record except ID
			existingCategory.setName(newCategory.getName());
			existingCategory.setPreference(newCategory.getPreference());
			//Save ER/NR in DB
			categoryRepository.save(existingCategory);
		}
		else
			throw new RuntimeException("ID is invalid");
	}
	
	@GetMapping("/category/pref/{pref}")
	public List<Category> getCategoriesByPref(@PathVariable("pref") Integer preference) {
		List<Category> list  = categoryRepository.findByPreference(preference);
		return list;
	}
}
