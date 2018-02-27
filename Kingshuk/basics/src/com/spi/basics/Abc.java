package com.spi.basics;
public class Abc {
	public Abc() {
		System.out.println("default");
	}
	public Abc(int i) {
		this();
		System.out.println("para");
	}
	public static void main(String[] args) {
		Abc a = new Abc();
	}
}
