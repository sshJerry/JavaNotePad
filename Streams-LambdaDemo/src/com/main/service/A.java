package com.main.service;

import java.util.List;
import java.util.stream.Collectors;

import com.main.model.Product;

public class A {
	public List<Integer> filter(List<Integer> list, String filter) {
		if (filter.equalsIgnoreCase("even")) {
			return list.stream().filter(e->e %2 ==0).collect(Collectors.toList());
			
		}
			// return list.stream()  ---converts list to stream
			// .filter(e->e %2 ==0)  ---Based on this condition, If condition is true, e stays
			// .collect(Collectors.toList()); -- Converting stream back to list
		
		if (filter.equalsIgnoreCase("odd"))
			return list.stream().collect(Collectors.toList());
		return null;
	}
	
	public List<Product> filterByVendor(List<Product> listProducts, String vendor) {
		//return listProducts.stream().collect(Collector.toList());
		return listProducts.stream()
				.filter(p->p.getVendorName().equalsIgnoreCase(vendor))
				.collect(Collectors.toList());
	}

	public List<String> extractVendors(List<Product> listProducts) {
		//Filter: Checks condition, Maintains original list unchanged.
		//Map: Generates a list of only 1 property. Such as vendorName or productName;
		return listProducts.stream()
				.map(p->p.getVendorName())
				.distinct()
				.collect(Collectors.toList());
			
	}

	public double computeSumPrice(List<Product> listProducts) {
		return listProducts.stream()
				.collect(Collectors.summingDouble(p->p.getPrice()));
	}
}
