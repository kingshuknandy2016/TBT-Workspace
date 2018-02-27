package com.spi.criticalPathApproach;

import com.spi.data.ExcelLibrary;

public class MainChecker {


	static String InputSheet="TestData";
	
	public static void main(String[] args) {
		ExcelLibrary exe=new ExcelLibrary("C:\\Users\\kingshuk.nandy\\Desktop\\BeallsPOMModel.xls");
		Double zip=(Double) exe.getCellData(InputSheet, 10, 1);
		String v = zip.toString().trim();
		//String ar[] = v.split(".");
		
		System.out.println(v.substring(0, v.indexOf("."))+","+v.length());
//        System.out.println(ar[0]);
		
		
		
		
         Long Phone=Double.valueOf( exe.getCellData(InputSheet, 11, 1).toString()).longValue();
		
		System.out.println(Phone.toString());
//		String PhoneNo=v.substring(0, use.indexOf("."));
//		System.out.println(PhoneNo);
		
		
	    Long CardNumber=Double.valueOf( exe.getCellData(InputSheet, 14, 1).toString()).longValue();
		String CardNo=CardNumber.toString();
		System.out.println("Card no:"+CardNo);
		Double Security=(Double) exe.getCellData(InputSheet, 15, 1);
		String sec = Security.toString().trim();
		System.out.println("////:"+sec.substring(0, sec.indexOf(".")));
		
		
	    String ExpiresOn=(String) exe.getCellData(InputSheet, 16, 1);
	    Double Year=(Double) exe.getCellData(InputSheet, 17, 1);
	    String ye = Year.toString().trim();
		System.out.println("////:"+ye.substring(0, ye.indexOf(".")));
	}

}
