package com.spi.autowire;

public class Employee {

	private String firstname, lastname;
	private Address address;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	
	public void show(){
		System.out.println(firstname+"\t"+lastname);
		System.out.println(this.address.getDoorno());
	}
}
