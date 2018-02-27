package com.spi.basics;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJunit {

/*	@Test
	 public void testAdd() {
	      String str= "Junit is working fine";
	      assertEquals("Junit is working ",str);
	   }*/
	
	public static int findMax(int arr[]){   
        int max=0;  
        for(int i=1;i<arr.length;i++){  
            if(max<arr[i])  
                max=arr[i];  
        }  
        return max;  
    }  
	
	
    @Test  
    public void testFindMax(){  
        assertEquals(4,TestJunit.findMax(new int[]{1,3,4,2}));  
        assertEquals(-1,TestJunit.findMax(new int[]{-12,-1,-3,-4,-2}));  
    }  

}
