package com.spi.test;

import java.util.ArrayList;
import java.util.Iterator;

class A{
	
}

class B extends A{
	
}

public class TestThis {

	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		A a=new B(); // Implicit type casting,  or upcasting
		
		// B b=new A(); // Downcasting or Expicit typecasting.
		
		ArrayList list=new ArrayList<String>(); // wont applies generic to list2 variable
		
		Iterator it=list.iterator();
		it.next();
		list.add(345);		
		list.add("e5");	
		list.add(true);
		
		ArrayList<String> list1=new ArrayList<String>(); // applies generic to list1 variable
		list1.add("34r"); 
		// list1.add(34); // Wont take
		
		list1.get(0); // Get Method returns String only since its generic
		
		
		ArrayList<String> list2=new ArrayList(); // applies generic to list2 variable
		list2.add("sdf");
		System.out.println(list2.get(0000));
		
		
	}

}

