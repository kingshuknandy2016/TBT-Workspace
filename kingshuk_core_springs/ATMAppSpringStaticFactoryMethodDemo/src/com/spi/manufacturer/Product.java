package com.spi.manufacturer;

import java.util.Date;

public class Product {

	private int id;
	private String name;
	// private Date launchdate;
	 private String launchdate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLaunchdate() {
		return launchdate;
	}

	public void setLaunchdate(String launchdate) {
		this.launchdate = launchdate;
	}

	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", launchdate="
				+ launchdate + "]";
	}
	
	
	

}
