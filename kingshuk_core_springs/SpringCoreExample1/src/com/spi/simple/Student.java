package com.spi.simple;

import org.springframework.beans.factory.annotation.Autowired;

public class Student {
	private String name;

	
	private Address address;
	
	
	
	public Address getAddress() {
		return address;
	}
  
	public void setAddress(Address address) {
		System.out.println("setter called Addres");
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("setter called Name");
		this.name = name;
	}

	public void displayInfo() {
		System.out.println("Hello: " + name);
		System.out.println(this.address.getCity() +"\t"+this.address.getName());
	}
	
	public void tryThis(){
		System.out.println("try This called");
	}
	
	public Student() {
		// TODO Auto-generated constructor stub
		System.out.println("Student constructor..");
	}
	
	public void closeAllResources(){
		System.out.println("close all the resources....");
	}
}