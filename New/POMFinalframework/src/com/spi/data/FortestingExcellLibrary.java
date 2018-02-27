package com.spi.data;

public class FortestingExcellLibrary {

	public static void main(String[] args) {
		ExcelLibrary ex=new ExcelLibrary("C:\\WorkSpace\\New\\POMFinalframework\\Lib\\KSRTC TestCase.xls");
		int Columncount=ex.getColumnCount("CriticalPathFlow", 1);
		System.out.println("Columncount:"+Columncount);
	}
	
	
}
