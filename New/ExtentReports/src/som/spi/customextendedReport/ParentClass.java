package som.spi.customextendedReport;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class ParentClass {
	
	public static ExtentReports extent;
	public ExtentTest test;
	final String filePath = System.getProperty("user.dir")+"\\ExtentDone.html";
    
    public synchronized static ExtentReports getReporter(String filePath) {
        if (extent == null) {
            extent = new ExtentReports(filePath, true);
            
            extent
                .addSystemInfo("Host Name", "Kingshuk")
                .addSystemInfo("Environment", "Selenium Testing");
        }
        
        return extent;
    }
	 // protected ExtentReports extent;
    
	    
	    
	   
	    @BeforeSuite
	    public void beforeSuite() {
	        extent = ParentClass.getReporter(filePath);
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
