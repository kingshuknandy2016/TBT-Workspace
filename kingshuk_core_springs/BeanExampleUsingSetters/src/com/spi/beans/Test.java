package com.spi.beans;

public class Test {

	private String pan;
	
	
	
	
	public String getPan() {
		System.out.println("get Pan");
		
		return pan;
	}




	public void setPan(String pan) {
		System.out.println("set Pan");
		this.pan = pan;
	}




	public Test() {
		// TODO Auto-generated constructor stub
		System.out.println("Test Const..");
		
	}
}
