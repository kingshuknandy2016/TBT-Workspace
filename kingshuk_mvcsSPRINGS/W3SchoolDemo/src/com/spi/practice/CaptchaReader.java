package com.spi.practice;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CaptchaReader {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
		driver.manage().window().maximize();
		
		WebElement element = driver.findElement(By.xpath("//img[@id='cimage']"));
		
		String elementTest = element.getAttribute("src");
	    System.out.println("Element : " + elementTest);
		
/*		byte[] arrScreen = ((FirefoxDriver) driver).getScreenshotAs(OutputType.BYTES);
		BufferedImage imageScreen = ImageIO.read(new ByteArrayInputStream(arrScreen));
		WebElement cap = driver.findElementById("captcha");*/
		//Dimension capDimension = cap.getSize();
		//Point capLocation = cap.getLocation();
		//BufferedImage imgCap = imageScreen.getSubimage(capLocation.x, capLocation.y, capDimension.width, capDimension.height);
		//ByteArrayOutputStream os = new ByteArrayOutputStream();
		//ImageIO.write(imgCap, "png", os);
	}

}
