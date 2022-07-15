package com.dataTransferObject;

public class App {
	public static void main(String[] args) {
		Product p = new Product(1,"HP Laptop", 1500);
		Vendor v = new Vendor(1,"ABC"); 
		PVDto dto = new PVDto();
		dto.setpName(p.getName());
		dto.setvName(v.getName());
		System.out.println(dto);
	}
	
}

class Product{
	int id;
	String name;
	double price;

	public Product(int id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
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
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
}

class Vendor{
	int id;
	String name;
	
	public Vendor(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	@Override
	public String toString() {
		return "Vendor [id=" + id + ", name=" + name + "]";
	}
	
}

class PVDto{ //Data Transfer Object
	String pName;
	String vName;
	
	public PVDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getvName() {
		return vName;
	}
	public void setvName(String vName) {
		this.vName = vName;
	}
	@Override
	public String toString() {
		return "PVDto [pName=" + pName + ", vName=" + vName + "]";
	}
	
}