package com.spi.circular.dependency;

public class A {

	private B b;

	public B getB() {
		return b;
	}

	public void setB(B b) {
		this.b = b;
	}
	public void showA(){
		System.out.println("A method....");
		this.b.showBMethod();
	}
}
