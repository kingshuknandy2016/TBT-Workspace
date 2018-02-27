package com.spi.basics;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.spi.screenRecorder.VideoRecord;

public class GoogleApp {

		static WebDriver driver=null;
		public static String recording="Yes";

	public static void main(String[] args) throws Exception {
		
		VideoRecord vr = new VideoRecord();
		if(recording.equalsIgnoreCase("Yes"))
		{vr.startRecording();
		}
		Thread.sleep(5000);
		System.out.println("Connecting to appium server");
		DesiredCapabilities capabilities=new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Nexus_4_API_19");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "4.4.2");
		capabilities.setCapability("app", "C:\\Users\\kingshuk.nandy\\AppData\\Local\\Android\\Sdk\\com.android.chrome_50.0.2661.89-266108910_minAPI16(x86)(nodpi).apk");
		driver=new AndroidDriver(new URL("http://10.0.102.168:4723/wd/hub"),capabilities);
		System.out.println("Connection Was successfull.");
		System.out.println("Opening m.beallsflorida.com ");
	//	final String deviceID = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
		driver.get("https://m.beallsflorida.com");
		Thread.sleep(15000);
		System.out.println("Bealls Florida site has been Successfully Opened");
		System.out.println("Clicking on Home Feature E-Spot");
		driver.findElement(By.xpath("//div[@class='home-feature']")).click();
		Thread.sleep(10000);
		
		
		
		
		if(recording.equalsIgnoreCase("Yes"))
		{
		        vr.stopRecording();        
		}
	}

}
