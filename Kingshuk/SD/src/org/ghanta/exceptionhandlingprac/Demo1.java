package org.ghanta.exceptionhandlingprac;

public class Demo1 {
	public static void main(String[] args) {
		int i=12, j=0 ;
		
		System.out.println("i="+i);
		System.out.println("j="+j);
		
		try {
			int k = i/j;
			System.out.println("k="+k);
		} catch(ArithmeticException ae) {
			System.out.println("a number cannot be divided by zero");
		}
	}
}
