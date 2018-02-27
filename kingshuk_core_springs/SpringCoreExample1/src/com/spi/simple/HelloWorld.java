


package com.spi.simple;

public class HelloWorld {
	private String message;

	public void setMessage(String message) {
		this.message = message;
	}

	public void getMessage() {
		System.out.println("Your Message : " + message);
	}
	
	public HelloWorld() {
		// TODO Auto-generated constructor stub
		System.out.println("Hello World Bean Constructor..");
	}
}