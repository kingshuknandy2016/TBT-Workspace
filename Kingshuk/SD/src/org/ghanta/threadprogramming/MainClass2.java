package org.ghanta.threadprogramming;

public class MainClass2 {
	public static void main(String[] args) {
		Sequence1 s1 = new Sequence1();
		Sequence2 s2 = new Sequence2();
		
		Thread t1 = new Thread(s1);
		Thread t2 = new Thread(s2);
		
		t1.start();
		t2.start();
	}
}
