package com.spi.di.constructor;

public class ConstructorInjection {
	private String name = null;
	private int roll;

	public ConstructorInjection(String name, int roll) {
		System.out.println("Name-roll");
		this.name = name;
		this.roll = roll;
	}

	
	public ConstructorInjection( int roll,String name) {
		System.out.println("roll-Name");
		this.name = name;
		this.roll = roll;
	}
	
	public String getMessage() {
		return name;
	}

	public int getValue() {
		return roll;
	}

	public String toString() {
		return "ConstructorInjection [name=" + name + ", roll=" + roll + "]";
	}
	
	
	
}
