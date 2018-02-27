package com.spi.atm;

public class Printer {

	private int id;
	private String name;

	public Printer() {
		super();
	}

	public Printer(int id, String name) {
		super();
		System.out.println("Arg -Const..");
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void printBalanceInformation(String accountNumber) {
		System.out
				.println("The printer has printed the balance information for the account number "
						+ accountNumber);

	}
}
