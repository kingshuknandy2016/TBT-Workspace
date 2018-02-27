package org.ghanta.exceptionhandlingprac;

public class Demo2 {
	public static void main(String[] args) {
		int i = 12, j=0, k=0;
		
		try {
			j=i/4;
			k=Integer.parseInt("32651G");
		} catch(ArithmeticException ae) {
			System.out.println("can't divide by zero");
		} catch (NumberFormatException nfe) {
			System.out.println("invalid number format");
		}
		
		System.out.println("i="+i);
		System.out.println("j="+j);
		System.out.println("k="+k);
	}
}
