package com.Pages.AllBealls;

import com.classs.usage.TestClass;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ValidatorsPage {
	
	
	public static void validatePriceSimilarity()
	{
		ExtentTest parent = TestClass.report.startTest("Similarity of prices", "Similarity of prices across PDP,QV and SDP");
		ExtentTest sdp =  TestClass.report.startTest("Price in SDP");
		ExtentTest pdp =  TestClass.report.startTest("Price in PDP");
		ExtentTest qvp =  TestClass.report.startTest("Price in QVP");
		ExtentTest cp =  TestClass.report.startTest("Price in CP");
		
		 
	 if((SearchDisplayPage.price.equalsIgnoreCase(SearchDisplayPage.qvPrice)) &&(SearchDisplayPage.qvPrice.equalsIgnoreCase(ProductDisplayPage.price)) 
			 &&(ProductDisplayPage.price.equalsIgnoreCase(ProductDisplayPage.priceCP))) 
	 {
		 sdp.log(LogStatus.INFO, "Price in SDP "+SearchDisplayPage.price);
		 sdp.log(LogStatus.PASS, "Prices are same");
		 
		 pdp.log(LogStatus.INFO, "Price in PDP "+ProductDisplayPage.price);
		 pdp.log(LogStatus.PASS, "Prices are same");
		 
		 qvp.log(LogStatus.INFO, "Price in QVP "+SearchDisplayPage.qvPrice);
		 qvp.log(LogStatus.PASS, "Prices are same");
		 
		 cp.log(LogStatus.INFO, "Price in Cart Page"+ProductDisplayPage.priceCP);
		 cp.log(LogStatus.PASS, "Prices are same");
		 parent.log(LogStatus.PASS, "Prices are similar across PDP,QV ,SDP and CP");
	 }
	 else
	 {
		 sdp.log(LogStatus.INFO, "Price in SDP "+SearchDisplayPage.price);
		 sdp.log(LogStatus.FAIL, "Prices are not same");
		 
		 pdp.log(LogStatus.INFO, "Price in PDP "+ProductDisplayPage.price);
		 pdp.log(LogStatus.FAIL, "Prices are not same");
		 
		 qvp.log(LogStatus.INFO, "Price in QVP "+SearchDisplayPage.qvPrice);
		 qvp.log(LogStatus.FAIL, "Prices are not same");
		 
		 cp.log(LogStatus.INFO, "Price in Cart Page"+ProductDisplayPage.priceCP);
		 cp.log(LogStatus.PASS, "Prices are not same");
		 parent.log(LogStatus.FAIL, "Prices are not similar across PDP,QV ,SDP and CP");
	 }
	 parent.appendChild(sdp);
	 parent.appendChild(pdp);
	 parent.appendChild(qvp);
	 parent.appendChild(cp);
	 
	 
	 TestClass.report.endTest(sdp);
	 TestClass.report.endTest(pdp);
	 TestClass.report.endTest(qvp);
	 TestClass.report.endTest(cp);
	 TestClass.report.endTest(parent);
	 
	 TestClass.report.flush();
	 
	}
	
	

}
