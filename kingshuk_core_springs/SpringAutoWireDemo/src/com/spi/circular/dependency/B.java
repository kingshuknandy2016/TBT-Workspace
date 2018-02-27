package com.spi.circular.dependency;

public class B {

	private A a;

	public A getA() {
		return a;
	}

	public void setA(A a) {
		this.a = a;
	}
	
	void showBMethod(){
		System.out.println("B class.");
		
	}
}
