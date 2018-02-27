package com.spi.autowire;

public class Employee {
	private Address address;
	private String firstname,lastname;
	private int empid;
	
	public Employee() {
		System.out.println("Employee default constructor.....");
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
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
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public void showEmpDetails(){
		System.out.println(firstname+"\t"+lastname);
		System.out.println(this.address.getDoorno());
		System.out.println(this.address.getLandmark());
	}
	

}
