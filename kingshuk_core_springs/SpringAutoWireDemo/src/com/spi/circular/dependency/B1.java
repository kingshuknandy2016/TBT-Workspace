package com.spi.circular.dependency;

public class B1 {
	
	private A1 a1;

	public B1(A1 a1) {
		super();
		this.a1 = a1;
	}
	
	public void show(){
		System.out.println("show caled from B-class");
	}

}
