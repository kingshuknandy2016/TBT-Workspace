package com.spi.circular.dependency;

public class A1 {

	private B1 b1;

	public A1(B1 b1) {
		super();
		this.b1 = b1;
	}
	
	void showA(){
		System.out.println("show-A Method......");
	}
}
