package com.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Arraylistdemo {

	
	public static void main(String[] args) {
		  
		
		//Arraylist is an implementation class
		  List<String> al=new ArrayList<String>();  
		  al.add("Ravi");  
		  al.add("Vijay");  
		  al.add("Ajay");  
		  List<String> al2=new ArrayList<String>();  
		  al2.add("Pat");  
		  al2.add("Hanumat");  
		  
		  ArrayList<String> res=new ArrayList<String>();
		  res.addAll(al);
		  res.addAll(al2);
		  
		  for (int i = 0; i < res.size(); i++) {
			System.out.println("///"+res.get(i));
		}
		  
		  
		/*//--is used to delete all the elements of specified collection from the invoking collection.
		 *  res.removeAll(al2);
		  System.out.println("-----------");
		  for (int j = 0; j < res.size(); j++) {
				System.out.println("///"+res.get(j));
			}*/
		  
		  
		  //----is used to delete all the elements of invoking collection except the specified collection.
		  res.retainAll(al2);
		  System.out.println("-----------");
		  for (int j = 0; j < res.size(); j++) {
			 // System.out.println("-----*********------");
				System.out.println("///"+res.get(j));
			}
		  sortFunctiolity();
		 
	}
	
	public static void sortFunctiolity(){
		System.out.println("==="+"sortFunctiolity");
		  List<String> al=new ArrayList<String>();  
		  al.add("Ravi");  
		  al.add("Vijay");  
		  al.add("Ajay");
		  
		  
		  System.out.println("==========Before Sorting==============");
		  for (int i = 0; i < al.size(); i++) {
				System.out.println("///"+al.get(i));
			}
		  
		  System.out.println("==========After Sorting==============");
		  Collections.sort(al);
		  for (int i = 0; i < al.size(); i++) {
				System.out.println("///"+al.get(i));
			}
	}
}
