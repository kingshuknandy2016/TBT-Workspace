package com.spi.testngdemo;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class FinalClass    {

	  protected ExtentReports extent;
	    protected ExtentTest test;
	    final String filePath = System.getProperty("user.dir")+"\\ExtentDone.html";
	    @BeforeSuite
	    public void beforeSuite() {
	        extent = ExtentManager.getReporter(filePath);
	    }
	    
	   
		 @Test
		    public void passTest() {
		        test = extent.startTest("passTest");
		        //test=extent.startTest("  Pat", "color");
		        test.log(LogStatus.PASS, "ItemsPerPage30", "Execution started");
		        
		      //  Assert.assertEquals(test.getRunStatus(), LogStatus.FAIL);
		    }
		    
		    @Test
		    public void intentionalFailure() throws Exception {
		        test = extent.startTest("intentionalFailure");
		        throw new Exception("intentional failure");        
		    }
		    
		    
		    @Test
		    public void PassTest2() throws Exception {
		        test = extent.startTest("PassTest2");
		        test.assignCategory("category-2", "category-3", "category-4", "cagegory-5");
		      ExtentTest child1=extent.startTest("Child1");
		      child1.log(LogStatus.PASS, "passed");
		    
		    
		      
		      ExtentTest child2=extent.startTest("Child2");
		     // child2.log(LogStatus.FAIL, "Failed");
		      child2.log(LogStatus.SKIP, "skipped");
		      
		      ExtentTest child3=extent.startTest("Child3");
		      child3.log(LogStatus.SKIP, "skipped");
		      
		      test.appendChild(child1).appendChild(child2).appendChild(child3);
		    }
		    
		        
		    

		    
		    
		    @AfterMethod
		    protected void afterMethod(ITestResult result) {
		        if (result.getStatus() == ITestResult.FAILURE) {
		            test.log(LogStatus.FAIL, result.getThrowable());
		        } else if (result.getStatus() == ITestResult.SKIP) {
		            test.log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
		        } else {
		            test.log(LogStatus.PASS, " ","Passed successfully");
		        }
		        
		        extent.endTest(test);        
		        extent.flush();
		    }
	    
	    @AfterSuite
	    protected void afterSuite() {
	        extent.close();
	    }

}
