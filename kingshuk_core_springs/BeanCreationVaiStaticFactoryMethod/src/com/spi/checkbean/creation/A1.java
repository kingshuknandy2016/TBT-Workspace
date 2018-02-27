package com.spi.checkbean.creation;

public class A1 {

	private B1 b1;

	public B1 getB1() {
		return b1;
	}

	public void setB1(B1 b1) {
		this.b1 = b1;
	}
	
	public void show(){
		System.out.println(this.getB1().getC1());
	}

	public String toString() {
		return "A1 [b1=" + b1.getC1() + "]";
	}
	
	
	
}
