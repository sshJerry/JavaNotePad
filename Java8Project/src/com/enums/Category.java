package com.enums;

public enum Category {
	MOBILES(80),LAPTOPS(8),TABLET(15),DESTKTOP(7);
	int quantity;
	Category(int quantity) {
		this.quantity = quantity;
	}
	public int getQuantity() {
		return quantity;
	}
}
