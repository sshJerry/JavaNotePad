package com.enums;

public class AppEnums {
	public static void main(String[] args) {
		College college = College.ABC;
		System.out.println(college);
		
		String colVal = college.toString();
		colVal.toLowerCase();
		
		EmployeeEnums ee = new EmployeeEnums();
		/*
		 * From DB we get value as String
		 * */
		
		String genDB = "MALE"; //WONT WORK BY ITSELF
		/* 
		 * Converting from Stringer to Enum and print from value*/
		ee.setGender(Gender.valueOf(genDB));
		System.out.println(genDB);
		
		// Category and Product
		Product p = new Product();
		p.setId(1);
		p.setName("HP Laser L5 Laptop");
		p.setPrice(1300);
		p.setCategory(Category.LAPTOPS);
		System.out.println(p);
		System.out.println("No of products under category: " + p.getCategory());
		System.out.println(p.getCategory().getQuantity());
		}
}
