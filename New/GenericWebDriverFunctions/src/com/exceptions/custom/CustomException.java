package com.exceptions.custom;

public class CustomException extends Exception{
	 
	private static final long serialVersionUID = 1L;
	
	public String errorMessage; 
	
	public CustomException(String message){
		errorMessage = message;
	}
	
	@Override
	public String toString() {
	 
		return super.toString();
	}
	
	public void getErrorMessage()
	{
		System.out.println(errorMessage);
	}
	

}
