package com.spi.constructordi;

public class Employee {

	private int age;
	private int empId;
	private String name,address;
	private int x;
	
	
	public Employee(int age, char ch,String str,boolean flag,float f,double d) {		
		System.out.println("int age, char ch,String str,boolean flag,float f,double d");		
	}
	
	public Employee(double d, char ch,String str,boolean flag,float f,int age) {		
		System.out.println("double d, char ch,String str,boolean flag,float f,age");		
	}
	
	public Employee(int age, int empId, String name, String address) {		
		super();
		System.out.println("I,I,S,S");
		this.age = age;
		this.empId = empId;
		this.name = name;
		this.address = address;
	}	
	
	
	public Employee() {
		// TODO Auto-generated constructor stub
		System.out.println("Def-Const..");
	}
	
	public Employee(int age, int x,int empId) {
		// TODO Auto-generated constructor stub
		System.out.println("I,I,I");
		this.age = age;
		this.empId = empId;
		this.x=x;			
	}
	
	public Employee( String name1,  String name, String name2) {
		// TODO Auto-generated constructor stub
		System.out.println("SSS");
			
	}
	
	
	public Employee(int age,  String name,int empId) {
		// TODO Auto-generated constructor stub
		System.out.println("I,S,I");
		this.age = age;
		this.empId = empId;
		this.name = name;		
	}
	public Employee(int age, int empId, String name) {
		System.out.println("I,I,S");
		// TODO Auto-generated constructor stub
		this.age = age;
		this.empId = empId;
		this.name = name;		
	}


	public String toString() {
		return "Employee [age=" + age + ", empId=" + empId + ", name=" + name
				+ ", address=" + address + ", x=" + x + "]";
	}
	

	public Employee(int age, int empId){
		System.out.println("II");
	}
	
	public Employee(String s, String s1){
		System.out.println("SS");
	}
	
}
