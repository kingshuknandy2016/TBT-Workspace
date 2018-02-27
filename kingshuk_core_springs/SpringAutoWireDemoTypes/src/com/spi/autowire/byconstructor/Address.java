package com.spi.autowire.byconstructor;

public class Address {
	private int areacode;
	private String doorno,landmark,street;
	public Address(int areacode, String doorno, String landmark, String street) {
		super();
		this.areacode = areacode;
		this.doorno = doorno;
		this.landmark = landmark;
		this.street = street;
		System.out.println("A-all Const....Address");
	}
	
	public Address() {
		System.out.println("Def Const....Address");
		// TODO Auto-generated constructor stub
	}
	
}	
