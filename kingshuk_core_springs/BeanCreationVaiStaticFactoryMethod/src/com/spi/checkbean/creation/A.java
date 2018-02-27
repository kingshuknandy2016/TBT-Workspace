package com.spi.checkbean.creation;

public class A {

	private int id;
	private String name,address;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public A() {
		// TODO Auto-generated constructor stub
		System.out.println("A Def Class Constructor...");
	}
}
