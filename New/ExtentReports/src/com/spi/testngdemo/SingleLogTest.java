package com.spi.testngdemo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class SingleLogTest extends BaseExample {
    public static String SP="SearchPage";  
	
	 @Test
	    public void passTest() {
	        test = extent.startTest(SP);
	        //test=extent.startTest("  Pat", "color");
	        test.log(LogStatus.PASS, "ItemsPerPage30", "Execution started");
	        
	        Assert.assertEquals(test.getRunStatus(), LogStatus.FAIL);
	    }
	    
/*	    @Test
	    public void intentionalFailure() throws Exception {
	        test = extent.startTest("intentionalFailure");
	        throw new Exception("intentional failure");        
	    }*/
	    
	    
	    @Test
	    public void Customtest(){
	    	test=extent.startTest(SP);
	    	test.log(LogStatus.PASS, "ItemsPerPage60","Execution started");
	    	
	    }
}
