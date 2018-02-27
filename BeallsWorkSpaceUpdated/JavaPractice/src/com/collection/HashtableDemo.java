package com.collection;

import java.util.Hashtable;
import java.util.Map;

public class HashtableDemo {

	/**
	 * A Hashtable is an array of list.Each list is known as a bucket.The position of bucket is identified by calling 
	 * the hashcode() method.A Hashtable contains values based on the key. It implements the Map interface and extends
	 *  Dictionary class
	 * 
	 * It contains only unique elements.
		It may have not have any null key or value.
		It is synchronized.
	 */
	public static void main(String[] args) {
		Hashtable<Integer,String> hm=new Hashtable<Integer,String>(); 
		
		// hm.put(null,"Amit"); 
		
		// hm.put(100,null);  
		// hm.put(200,null); 
		 hm.put(120,"Amit");  
		  hm.put(102,"Ravi");  
		  hm.put(101,"Vijay");  
		  hm.put(103,"Rahul");  
		  
		  for(Map.Entry m:hm.entrySet()){  
		   System.out.println(m.getKey()+" "+m.getValue());  
		  }  
	}

}
