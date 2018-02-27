package org.ghanta.threadprogramming;

public class MainClass4 {
	public static void main(String[] args) {
		Sequence3 s1 = new Sequence3();
		
		System.out.println("Thread ID\t:"+s1.getId());
		System.out.println("Thread Name\t:"+s1.getName());
		System.out.println("Thread Priority\t:"+s1.getPriority());
		
		System.out.println("Modifying Thread Properties..");
		
		s1.setName("My Thread");
		s1.setPriority(9);
		
		System.out.println("Thread Name\t:"+s1.getName());
		System.out.println("Thread Priority\t:"+s1.getPriority());
	}

}
