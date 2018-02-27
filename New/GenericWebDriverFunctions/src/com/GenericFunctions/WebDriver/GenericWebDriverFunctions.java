package com.GenericFunctions.WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Pages.AllBealls.PopUpPage;
import com.collection.garbage.Constants;
import com.constants.string.StringConstants;
import com.exceptions.custom.CustomException;

public class GenericWebDriverFunctions {

	public static WebDriver driver = null;
	public static WebElement element = null;
	public static String getText=null;
	public static WebDriverWait wait= null;

	public static void loadDriver(String driverName) {
		switch (driverName.toLowerCase()) {
		case StringConstants.CHROME:
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")
							+ "\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case StringConstants.IE:
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir")
							+ "\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			break;

		case StringConstants.FIREFOX:
			

			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;

		default:
			try {
				throw new CustomException("Invalid driver");
			} catch (CustomException e) {
				e.getErrorMessage();
			}
			break;

		}

	}

	public static void startServer(String environmentURL) {
		driver.get(environmentURL);
	}

	public static void performAction(String actionName, WebElement element,
			String data) {
		getText =null;
		Select option= null;
		wait = new WebDriverWait(driver, 30);
		try
		{
		switch (actionName.toLowerCase()) {

		case StringConstants.CLICK:
			element=wait.until(ExpectedConditions.visibilityOf(element));
			 element.click();
			break;
		case StringConstants.SENDKEYS:
			element=wait.until(ExpectedConditions.visibilityOf(element));
		 element.sendKeys(data);
			break;
		case StringConstants.SUBMIT:
			element=wait.until(ExpectedConditions.visibilityOf(element));
			 element.submit();
			break;
		case StringConstants.SELECTVALUE:
			element=wait.until(ExpectedConditions.visibilityOf(element));
			 option= new Select(
					 element);
			option.selectByVisibleText(data);
			break;
		case StringConstants.SELECTINDEX:
			element=wait.until(ExpectedConditions.visibilityOf(element));
			option = new Select(
					 element);
			option.selectByIndex(Integer.parseInt(data));
			break;
		case StringConstants.MOUSEOVER:
			Actions builder = new Actions(driver);
			element=wait.until(ExpectedConditions.visibilityOf(element));
			Action mouseOver = builder.moveToElement(
					element).build();
			mouseOver.perform();
			break;
			
		case StringConstants.GETTEXT:
			element=wait.until(ExpectedConditions.visibilityOf(element));
			  getText=element.getText();
			  break;
		default:
			try {
				throw new CustomException("Invalid action name");
			} catch (CustomException e) {
				e.getErrorMessage();
			}
		}
		}
		catch(NoSuchElementException  | ElementNotVisibleException ex)
		{
			ex.printStackTrace();
		}
		catch(WebDriverException exception)
		{
			 PopUpPage.closePopUp();
			 GenericWebDriverFunctions.performAction(actionName, element, data);
		}

	}


	public static void stopServer() {
		driver.quit();
	}
	
	
	public static boolean isDisplayed(WebElement element)
	{
		
		wait = new WebDriverWait(driver, 30);
		element=wait.until(ExpectedConditions.visibilityOf(element));
		return element.isDisplayed();
		
	}

}
