package com.spi.model;

public class Employee {
	
	private String name,emailid;
	private int pincode;
	private int empid;
	private long cellno;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public long getCellno() {
		return cellno;
	}
	public void setCellno(long cellno) {
		this.cellno = cellno;
	}

}
