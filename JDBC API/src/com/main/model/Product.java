package com.main.model;

public class Product {
	private int id;
	private String name;
	private double price;
	private Vendor vendor;
	
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", vendor=" + vendor + "]";
	}
	public Product(int id, String name, double price, Vendor vendor) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.vendor = vendor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Vendor getVendor() {
		return vendor;
	}
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	
	
}
