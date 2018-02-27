package com.spi.practice;

public final class VariablesScope {

    final  static int i;
   
   static{
	  i=30; 
	  
   }
	
	public static void main(String[] args) {

     
     

	}
	
	
	static void abc(){
		System.out.println("Inside final method");
	}

}
