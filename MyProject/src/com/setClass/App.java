package com.setClass;

import java.util.List;
import java.util.Scanner;
import com.main.db.DB;
import com.main.model.Employee;
import com.main.model.EmployeeUtility;
import com.main.model.Product;

public class App {
	public static void main(String[] args){
		DB db =new DB();
		
		Employee employee = new Employee();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("**** DB OPS");
		System.out.println("1. Insert E");
		System.out.println("2. Show all E");
		System.out.println("3. Delete E");
		System.out.println("4. Update E");
		System.out.println("0. TO Exit");
		System.out.println("Enter your Input");
		int input = sc.nextInt();
		
		if(input ==0) {
			System.out.println("Exiting.. bye");
		}
		switch(input){
			case 1:
				System.out.println("Enter Employee Name");
				sc.nextLine(); //skip this
				String name = sc.nextLine();
				System.out.println("Enter Employee Salary");
				double salary = sc.nextDouble();
				System.out.println("Enter Employee City");
				String city = sc.next();
				System.out.println("Enter Employee Depamrtnet Name");
				String department = sc.next();
				
				employee.setName(name);
				employee.setSalary(salary);
				employee.setCity(city);
				employee.setDepartment(department);
				db.insertEmployee(employee);
				System.out.println("Employee Added to DB");
				break;
			case 2:
				List<Employee> list = db.fetchEmployee();
				for(Employee e :list) {
					System.out.println(e);
				}
				break;
			case 3:
				System.out.println("Enter Employee ID");
				int id = sc.nextInt();
				EmployeeUtility util = new EmployeeUtility();
				boolean isValid = util.validateId(db.fetchEmployee(),id);
				if(!isValid) {
					System.out.println("Invalid ID try again");
					break;
				}
				db.deleteEmployee(id);
				System.out.println("Emplyee Delete from DB");
				break;
			case 4:
				System.out.println("Enter Employee ID");
				id = sc.nextInt();
				util = new EmployeeUtility();
				isValid = util.validateId(db.fetchEmployee(),id);
				if(!isValid) {
					System.out.println("Invalid ID try again");
					break;
				}
				Employee emp = db.fetchEmployee(id);
				System.out.println("Existing Record of ID: " + id);
				System.out.println(emp);
				sc.nextLine(); //skip this
				name = sc.nextLine();
				System.out.println("Enter Employee Salary");
				salary = sc.nextDouble();
				System.out.println("Enter Employee City");
				city = sc.next();
				System.out.println("Enter Employee Depamrtnet Name");
				department = sc.next();
				employee.setName(name);
				employee.setSalary(salary);
				employee.setCity(city);
				employee.setDepartment(department);
				db.updateEmployee(employee);
				System.out.println("Employee record updated!");
				break;
			case 5:
				List<Product> plist = db.fetchAllProductsWithVendor();
				for(Product p: plist) {
					System.out.println(p);
				}
				break;
		}
		sc.close();
	}
}
