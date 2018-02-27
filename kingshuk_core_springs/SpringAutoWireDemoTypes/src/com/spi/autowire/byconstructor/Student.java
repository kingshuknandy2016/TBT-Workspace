package com.spi.autowire.byconstructor;

public class Student {

	private int rollno;
	private String name;
		
	private Address address;

	
	public Student() {
		// TODO Auto-generated constructor stub
		System.out.println("def-Student Cons..");
	}
	
	
	public Student(Address address) {
		// TODO Auto-generated constructor stub
		this.address=address;
		System.out.println("Arg-Student Cons..");
	}
	
	
	
	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		System.out.println("setters..");
		this.address = address;
	}

	

}
