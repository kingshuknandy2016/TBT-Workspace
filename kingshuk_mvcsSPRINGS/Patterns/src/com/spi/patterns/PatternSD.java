package com.spi.patterns;

public class PatternSD {

	/**
	 * @param args
	 */
	
	/*(height+width==7 || width-height==6) || */
	public static void main(String[] args) {
		/*for (int height=1; height<=6; height++) {
			for (int width=1; width<=12; width++){
				if((height+width==7 || width-height==6) || (height==3) && (((width>=5) && (width<=8)))) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}*/
		
		//generalise
		//(i+j==height+1) || (j-i==(height+breadth)-1)
		int height=6, width=16, breadth=3;
		
		for (int i=1; i<=height; i++) {
			for (int j=1; j<=width; j++){
				if(((i+j==height+1) || (j-i==(height+breadth)-1)) || ((i==(height/2)+1) && (((j>=height+1) && (j<=(height+breadth)-1))))) {
					for (int k=1; k<=breadth; k++) {
						System.out.print("*");
					}
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
		
	}

}
