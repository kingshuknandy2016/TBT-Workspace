package com.spi.atm;

public class ATM {
	private Printer printer;

	
	
	// Here we have getters & setters methods..
	public Printer getPrinter() {
		return printer;
	}

	public void setPrinter(Printer printer) {
		this.printer = printer;
	}

	public void printBalanceInformation(String accountNumber) {
		getPrinter().printBalanceInformation(accountNumber);

	}
	
	public void show(){
		System.out.println(this.printer.getId());
		System.out.println(this.getPrinter().getName());
	}
	
	
}
