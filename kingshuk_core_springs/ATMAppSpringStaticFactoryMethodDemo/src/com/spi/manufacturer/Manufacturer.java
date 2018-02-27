package com.spi.manufacturer;

import java.util.Arrays;

public class Manufacturer {
	private String name;
	
	private Product product[];

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Product[] getProduct() {
		return product;
	}

	public void setProduct(Product[] product) {
		this.product = product;
	}
	
	public void show(){
		// Converts Arrays to String...
		System.out.println(Arrays.toString(this.getProduct()));
	}
	
	
}
