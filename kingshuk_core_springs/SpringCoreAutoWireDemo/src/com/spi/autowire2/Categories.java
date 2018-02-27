package com.spi.autowire2;

public class Categories {

	private String name;
	private Book bk;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Book getBk() {
		return bk;
	}

	public void setBk(Book bk) {
		this.bk = bk;
	}

	public Categories() {
		// TODO Auto-generated constructor stub
		System.out.println("Categ-Cons");
	}

	public Categories(Book book) {
		// TODO Auto-generated constructor stub
		System.out.println("Book-Constr");
	}

	public void show() {
		System.out.println("Categories name :" + name);
		System.out.println("Book name :" + bk.getBookname()
				+ " and Book Price :" + bk.getBookprice());
	}
}
