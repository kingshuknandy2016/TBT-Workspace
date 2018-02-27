package com.spi.practice;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Main {
 
    private static ExtentReports extent;

    public static void main(String[] args) {
    	String file_path=System.getProperty("user.dir")+"\\ExtentRRReport.html";
    			
        extent = new ExtentReports(file_path, true);
       // extent.addSystemInfo("Selenium Version", "2.46");
       // extent.addSystemInfo("Environment", "Prod");
        //start Test
        // creates a toggle for the given test, adds all log events under it    
        ExtentTest test = extent.startTest("My First Test", "Sample description");
        
        
        // log(LogStatus, details)
        test.log(LogStatus.INFO, "This step shows usage of log(logStatus, details)");

        // report with snapshot
        String img = test.addScreenCapture("img-path");
        test.log(LogStatus.INFO, "Image", "Image example: " + img);
        
        // end test
        extent.endTest(test);
        
        // calling flush writes everything to the log file
        extent.flush();
    }
}
