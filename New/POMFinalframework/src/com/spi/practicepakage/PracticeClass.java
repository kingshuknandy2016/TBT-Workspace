package com.spi.practicepakage;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.spi.extendedReport.SingleLogTest;

public class PracticeClass extends SingleLogTest {
	SingleLogTest st=new SingleLogTest();
	
	 public void pat(){
    	 
	    	//ExtentTchild1 = extent.startTest("First");
		 st.getChild1().log(LogStatus.PASS, "pass1");
	    	//st.setChild1(child1);
			//return child1;
	    	
	    }
	    
	    public void cat(){
	    	//ExtentTest child1 = null;
	    	 st.getChild1().log(LogStatus.PASS, "pass2");
	    	
	    }
}
