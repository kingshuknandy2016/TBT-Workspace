package com.bealls.testcases;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.Ordering;

public class Check {

	 
	public static void main(String[] args) {
		 
		List<Double> names = new ArrayList<Double>();
		names.add(34.55);
		names.add(100.2);
		names.add(23.0);
		
		
		
		List <Double>tnames = new ArrayList<Double>(names);
		Collections.sort(tnames);
		
		Collections.reverse(names);
		
		for(int i=0;i<names.size();i++)
			System.out.println(names.get(i)+"\t\t\t"+tnames.get(i));
		
		//Collections.sort(names);
		System.out.println("The strings in list sorted "+Ordering.natural().isOrdered(names));
	}

}
