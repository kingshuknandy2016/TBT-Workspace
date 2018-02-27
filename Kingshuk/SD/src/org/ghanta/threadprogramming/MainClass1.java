package org.ghanta.threadprogramming;
import java.lang.Object;

public class MainClass1 {
	public static void main(String[] args) {
		System.out.println("main() started..");
		
		Sequence1 s1 = new Sequence1();
		Sequence1 s2 = new Sequence1();
		
		Thread t1 = new Thread(s1);
		Thread t2 = new Thread(s2);
		
		t1.start();
		t2.start();
		
		System.out.println("main() ended..");
	}
}
