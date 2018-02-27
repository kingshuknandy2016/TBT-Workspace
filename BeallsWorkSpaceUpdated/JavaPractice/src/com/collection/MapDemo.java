package com.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapDemo {


	public static void main(String[] args) {
		
		HashMapDemo();	
		TreeMapDemo();
		

	}
	
	/**
	 * It implements the Map interface and extends HashMap class.
	 * It contains only unique elements.
	 * It may have one null key and multiple null values.
	 * It is same as HashMap instead maintains insertion order.
	 */
	public static void HashMapDemo(){
		Map< Integer,String> map=new HashMap< Integer,String>();
		map.put(null, "Zoo");
		map.put(1, "pat");
		map.put(7, "king");
		map.put(4, "At");
		map.put(6, "king");
		map.put(100,null); 
		//map.put(null, "ZooLo");
		
		for (Map.Entry<Integer, String> m:map.entrySet()) {
			System.out.println("---"+m.getKey()+"---"+m.getValue());
		}
		System.out.println("------------------");
	}
	
	
	/**
	 *  It implements the NavigableMap interface and extends AbstractMap class.
	 * It contains only unique elements.
	 * It cannot have null key but can have multiple null values.
	 * It is same as HashMap instead maintains ascending order.
	 */
	public static void TreeMapDemo(){
		Map< Integer,String> map=new TreeMap< Integer,String>();
		//map.put(null, "Zoo");
		map.put(1, "pat");
		map.put(7, "king");
		map.put(4, "At");
		map.put(6, "king");
		map.put(100,null); 
		//map.put(null, "Zoo");
		
		for (Map.Entry<Integer, String> m:map.entrySet()) {
			System.out.println("---"+m.getKey()+"---"+m.getValue());
		}
	}
	

}
