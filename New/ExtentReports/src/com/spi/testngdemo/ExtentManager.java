package com.spi.testngdemo;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	 private static ExtentReports extent;
	    
	    public synchronized static ExtentReports getReporter(String filePath) {
	        if (extent == null) {
	            extent = new ExtentReports(filePath, true);
	            
	            extent
	                .addSystemInfo("Host Name", "Kingshuk")
	                .addSystemInfo("Environment", "Selenium Testing");
	        }
	        
	        return extent;
	    }

}
