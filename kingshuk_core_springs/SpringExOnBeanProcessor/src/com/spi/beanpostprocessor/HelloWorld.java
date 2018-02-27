package com.spi.beanpostprocessor;


public class HelloWorld {
	
	public HelloWorld() {
		// TODO Auto-generated constructor stub
		System.out.println("Bean Constr..");
	}

	private String message;

	public void setMessage(String message) {
		System.out.println("set Message");
		this.message = message;
	}

	public void getMessage() {
		System.out.println("ge Message");
		System.out.println("Your Message : " + message);
	}

	/*public void init() {
		System.out.println("Bean is going through init.");
	}

	public void destroy() {
		System.out.println("Bean will destroy now.");
	}
*/
}
