package com.spi.constructor.di;

public class Employee {

	private int age,pincode;
	private String firstname,lastname,address;
	
	
	public Employee(int age) {
		super();
		this.age = age;
	}

	public Employee(int age, int pincode) {
		super();
		this.age = age;
		this.pincode = pincode;
		
	}

	public Employee(int age, int pincode, String lastname) {
		super();
		this.age = age;
		this.pincode = pincode;
		this.lastname = lastname;
	}


	public Employee(int age, int pincode, String firstname, String lastname,
			String address) {
		super();
		this.age = age;
		this.pincode = pincode;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
	}
	
	public Employee(String firstname,int age, int pincode, String lastname,
			String address) {
		super();
		this.age = age;
		this.pincode = pincode;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
	}



	public String toString() {
		return "Employee [age=" + age + ", pincode=" + pincode + ", firstname="
				+ firstname + ", lastname=" + lastname + ", address=" + address
				+ "]";
	}
	
	
	
}
