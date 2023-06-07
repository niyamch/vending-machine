package com.vending.machine.domain;

public class Product {
	private String name;
	private int quantity;
	private int priceInStotinki;

	public Product(String name, int priceInStotinki, int quantity) {
		this.name = name;
		this.quantity = quantity;
		this.priceInStotinki = priceInStotinki;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPriceInStotinki() {
		return priceInStotinki;
	}

	public void setPriceInStotinki(int priceInStotinki) {
		this.priceInStotinki = priceInStotinki;
	}
}
