package com.mvpjava.demo;

public class Product {
	private String description;
	private double price;

	public Product (String description, double price) {
		this.description = description;
		this.price = price;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

}
