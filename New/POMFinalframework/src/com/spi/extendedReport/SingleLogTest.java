package com.spi.extendedReport;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.spi.practicepakage.PracticeClass;

public class SingleLogTest extends BaseExample  {
	    private  ExtentTest child1;
	/*  @Test 
	    public void passTest() {
	        test = extent.startTest("passTest");
	        test.log(LogStatus.PASS, "Pass");
	        
	        Assert.assertEquals(test.getRunStatus(), LogStatus.PASS);
	    }
	    
	    @Test
	    public void intentionalFailure() throws Exception {
	        test = extent.startTest("intentionalFailure");
	        throw new Exception("intentional failure");        
	    }*/
	    
	    public ExtentTest getChild1() {
			return child1;
		}

		public void setChild1(ExtentTest child1) {
			this.child1 = child1;
		}

		@Test
	    public void a() throws Exception{
	    	 test = extent.startTest("a()","successfully lunched");//This will come at the top
	    	 test.log(LogStatus.PASS,"Step1", "Started successfully");
	    	 try {
				int i=5/0;
			} catch (Exception e) {
				test.log(LogStatus.FAIL,"Step2", "Error:"+e);
				// throw new Exception("Failure"+e);
			}
	    	 //test.log(LogStatus.FAIL,"Step2","FAoiled");
	    	// Assert.assertEquals(test.getRunStatus(), LogStatus.PASS);
	    }
	    
	    @Test
	    public void b() throws Exception{
	    	 test = extent.startTest("b()","successfully lunched");
	    	 test.log(LogStatus.PASS, "Step1", "Started successfully");
	    	 throw new Exception("intentional failure");
	    }
	    
	    @Test
	    public void c(){
	    	 test = extent.startTest("c()");
	    	 test.log(LogStatus.FAIL, "Pass");
	    	 LogStatus status = test.getRunStatus();
	    	 System.out.println("run Status::" +status);
	    	AssertJUnit.assertEquals(test.getRunStatus(), LogStatus.FAIL);
	    }
	    
	    @Test
	    public void d(){
	    	 test = extent.startTest("Parent");
	    	 
	    	 ExtentTest child1 = extent.startTest("Child 1");
	    	 child1.log(LogStatus.SKIP, "Info");
	    	
	    	 ExtentTest child2 = extent.startTest("Child 2");
	    	 child2.log(LogStatus.PASS, "Failed");

	    	 test
	    	     .appendChild(child1)
	    	     .appendChild(child2);
	    	     
	    	 //Assert.assertEquals(test.getRunStatus(), LogStatus.FATAL);
	    }
	    
    @Test
	    public void e(){
	    	 test = extent.startTest("Parent");
	    	 PracticeClass  spp=new PracticeClass();
	    	
	    	// ExtentTest child1 = null;
	    	 for (int i = 1; i < 7; i++) {
	    		 ExtentTest child1 = extent.startTest("First");
	   
					
			
	    		 
	    		 test.appendChild(child1);
			}

	    }
    
    
  

    
	    
	   
	}