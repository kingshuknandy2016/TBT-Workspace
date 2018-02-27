package com.spi.test;

public class EmployeeException extends Exception {
	
String msg;
public EmployeeException(String msg)
{
	super(msg);
	this.msg =msg; 
}



public String toString() {
		// TODO Auto-generated method stub
		return msg;
	}

}
