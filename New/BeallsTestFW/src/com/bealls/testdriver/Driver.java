package com.bealls.testdriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bealls.data.ExcelLibrary;
import com.bealls.testexec.TestExecutor;
import com.bealls.videorecording.VideoRecord;

public class Driver {

	public static WebDriver driver;
	//public static String 

	public static VideoRecord vr ;
	@BeforeClass
	public void openApplication() {
		
		ExcelLibrary el = new ExcelLibrary("C:\\WorkSpace\\New\\BeallsTestFW\\TestCaseOne.xls");
		
		String url = (String) el.getCellData("Configuration", 1, 1);
		String browser = (String) el.getCellData("Configuration", 0, 1);
		filePath = (String) el.getCellData("Configuration", 2, 1);

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")+"\\Lib\\chromedriver.exe");
		vr = new VideoRecord();
			driver = new ChromeDriver();
			try {
				vr.startRecording();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")+"\\Lib\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
	}

	
	public static String filePath="C:\\WorkSpace\\New\\BeallsTestFW\\TestCaseOne.xls";

	@DataProvider
	public Object[][] getSheetName() {
		List<String> sheetNameList = getSheetNameList();
		Object[][] data = new Object[sheetNameList.size()][1];
		for (int i = 0; i < sheetNameList.size(); i++) {
			data[i][0] = sheetNameList.get(i);
		}
		return data;
	}

	@Test(dataProvider = "getSheetName")
	public void testMethod(String sheetName) {
		TestExecutor te = new TestExecutor();
		te.run(sheetName);
	}

	public List<String> getSheetNameList() {
		List<String> sheetNameList = new ArrayList<String>();
		ExcelLibrary el = new ExcelLibrary(filePath);
		int rowCount = el.getRowCount("Scenarios");
		for (int i = 1; i <= rowCount; i++) {
			String exeStatus = (String) el.getCellData("Scenarios", i, 1);
			if (exeStatus.equalsIgnoreCase("yes")) {
				String sheetName = (String) el.getCellData("Scenarios", i, 0);
				sheetNameList.add(sheetName);
			} else {
				el.writeToCell("Scenarios", i, 2, "Skipped");
			}
		}
		return sheetNameList;
	}

	@AfterClass
	public void closeBrowser() {
		driver.close();
		driver.quit();
		try {
			vr.stopRecording();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
