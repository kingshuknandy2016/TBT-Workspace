package com.spi.springbasic;

public class Employee {
	private int eid;
	private String ename;
	
	public Employee() {
		System.out.println("def cons");
	}
	
	public Employee(int eid) {
		this.eid = eid;
	}
	
	public Employee(String ename) {
		this.ename = ename;
	}
	
	public Employee(int eid, String ename) {
		this.eid = eid;
		this.ename = ename;
	}
	
	void show() {
		System.out.println("ID\t: "+eid);
		System.out.println("Name\t: "+ename);
	}
}
