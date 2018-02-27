package com.spi.extendedReport;

import org.openqa.selenium.remote.server.SystemClock;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseExample {
	protected ExtentReports extent;
    protected ExtentTest test;
   // protected ExtentTest child1;
    
    final String filePath = System.getProperty("user.dir")+"\\Lib\\ExtentRe.html";

    @AfterMethod
    protected void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(LogStatus.FAIL, " ",result.getThrowable());
        } else if (result.getStatus() == ITestResult.STARTED) {
        	test.log(LogStatus.PASS," ", "Test passed");
        }
        else if (result.getStatus() == ITestResult.SUCCESS) {
        	test.log(LogStatus.PASS," ", "Test passed");
        }
        else if (result.getStatus() == ITestResult.SUCCESS_PERCENTAGE_FAILURE) {
        	test.log(LogStatus.PASS," ", "Test passed");;
        }
        else {
           // test.log(LogStatus.PASS," ", "Test passed");
            test.log(LogStatus.SKIP, " ","Test skipped " + result.getThrowable());
        }
        
         extent.endTest(test);        
        extent.flush();
    }
    
    @BeforeSuite
    public void beforeSuite() {
        extent = ExtentManager.getReporter(filePath);
    }
    
    @AfterSuite
    protected void afterSuite() {

        extent.close();
    }
}
