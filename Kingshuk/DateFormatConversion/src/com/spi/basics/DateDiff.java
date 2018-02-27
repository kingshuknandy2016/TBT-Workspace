package com.spi.basics;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDiff {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
		String inputString1 = "19 11 2015";
		String inputString2 = "20 11 2015";

	 
		    Date date1 = myFormat.parse(inputString1);
		    Date date2 = myFormat.parse(inputString2);
		    long diff =daysBetween( date2 , date1);
		    System.out.println(diff);
		 
	}
	
	private static long daysBetween(Date one, Date two) { long difference = (one.getTime()-two.getTime())/86400000; return Math.abs(difference); }


}
