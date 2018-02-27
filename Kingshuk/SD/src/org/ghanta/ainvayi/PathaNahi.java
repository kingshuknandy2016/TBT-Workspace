package org.ghanta.ainvayi;

import java.util.Scanner;

public class PathaNahi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.print("Enter height: ");
		Scanner scn = new Scanner(System.in);
		int height = scn.nextInt();
		//System.out.println();
		System.out.print("Enter width: ");
		int width = scn.nextInt();
		System.out.println();

		for(int i=height; i>=1; i--) {
			for(int j=1; j<=2*(height+(width-1)); j++) {
				if(i==j) {
					for(int x=1; x<=width; x++) {
						System.out.print("*");
					}
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	
		scn.close();
		
	}

}
