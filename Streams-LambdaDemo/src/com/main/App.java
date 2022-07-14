package com.main;

import java.util.Arrays;
import java.util.List;

import com.main.model.Product;
import com.main.service.A;

public class App {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(5,3,7,1,2,6,8,4);
		A a = new A();
		List<Integer> listEven = a.filter(list,"even"); 
		List<Integer> listOdd = a.filter(list,"odd");
		System.out.println(listEven);
		System.out.println(listOdd);
		System.out.println("*********************************");
		Product p1 = new Product(1,"Apple iPhone 8",450,"ABC Electronics");
		Product p2 = new Product(2,"MacbookPro",1500,"XYZ Electronics");
		Product p3 = new Product(3,"HP Laser 6",1450,"ABC Electronics");
		Product p4 = new Product(4,"Dell Latitude L3",1200,"XYZ Electronics");
		Product p5 = new Product(5,"IMB Lenovo 35",1150,"ABC Electronics");
		
		List<Product> listProducts = Arrays.asList(p1,p2,p3,p4,p5);
		for (Product p:listProducts) {
			System.out.println(p);
		}
		System.out.println("********Filter by Vendor: ABC********");
		List<Product> listVendorABC = a.filterByVendor(listProducts, "ABC Electronics");
		List<Product> listVendorXYZ = a.filterByVendor(listProducts, "XYZ Electronics");
		for (Product p:listVendorABC) {
			System.out.println(p);
		}
		System.out.println("*********************************");
		for (Product p:listVendorXYZ) {
			System.out.println(p);
		}
		System.out.println("********Extract Only Vendors********");
		List<String> listVendors = a.extractVendors(listProducts);
		for (String vendor:listVendors) {
			System.out.println(vendor);
		}
		System.out.println("********Sum of Salries********");
		double sum = a.computeSumPrice(listProducts);
		System.out.println(sum);
		
	}
}
