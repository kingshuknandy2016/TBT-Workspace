package com.spi.factory;

import com.spi.atm.Printer;

public class PrinterFactory {

	
	// Factory pattern demo.. It provides number of objects based on given input.
	// Factory method returns bean objects
	
	public static Printer getPrinterInstance() {
		return new Printer();
	}

	
		
	public static Printer createPrinter() {
		return new Printer();
	}
}
