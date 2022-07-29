package com.springboot.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Categories")
public class Category { //category
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(length = 99, nullable = false)
	private String name; //varchar(255)
	@Column(nullable = false)
	private Integer preference;
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(Long id, String name, Integer preference) {
		super();
		this.id = id;
		this.name = name;
		this.preference = preference;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPreference() {
		return preference;
	}

	public void setPreference(Integer preference) {
		this.preference = preference;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", preference=" + preference + "]";
	}
	
}
