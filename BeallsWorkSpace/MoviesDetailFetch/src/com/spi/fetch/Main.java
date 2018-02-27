package com.spi.fetch;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.excellibrary.bealls.ExcelLibrary;

public class Main {
    public static String Sheetname="English";
    public static String Year=null,Catagory=null,IMDBRating=null,Duration=null,	Wrotten_Tomatoes=null,	Cast=null,	link=null,	Story=null,RogerRating=null;
   // public static StringBuffer Proper;
	
	public static void main(String[] args) throws InterruptedException {
		ExcelLibrary exe=new ExcelLibrary("C:\\WorkSpace\\BeallsWorkSpace\\MoviesDetailFetch\\Movie Details.xls");
		StringBuffer Proper=new StringBuffer();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in");
		
		int rowCout=exe.getRowCount(Sheetname);
		for (int i = 1; i <= rowCout; i++) {
		    String movie_name=(String) exe.getCellData(Sheetname, i,0);
		    driver.findElement(By.xpath("//input[@name='q']")).clear();

			driver.findElement(By.xpath("//input[@name='q']")).sendKeys(movie_name);
			driver.findElement(By.xpath("//div[@id='sblsbb']")).click();
			Thread.sleep(2000);
			Year=driver.findElement(By.xpath("(//div[@class='_OKe']//span)[4]")).getText();
			IMDBRating=driver.findElement(By.xpath("(//div[@class='_OKe']//span)[5]")).getText();
			Wrotten_Tomatoes=driver.findElement(By.xpath("(//div[@class='_OKe']//span)[9]")).getText();
			Story=driver.findElement(By.xpath("(//div[@class='_OKe']//span)[11]")).getText();
			RogerRating=driver.findElement(By.xpath("(//div[@class='_OKe']//span)[7]")).getText();
			link=driver.findElement(By.xpath("//div[@id='ires']//a[contains(text(),'IMDb')]")).getAttribute("href");
			exe.writeToCell(Sheetname, i, 3, Year);
			exe.writeToCell(Sheetname, i, 6, IMDBRating );
			exe.writeToCell(Sheetname, i, 7, RogerRating );
			exe.writeToCell(Sheetname, i, 8, Wrotten_Tomatoes );
			exe.writeToCell(Sheetname, i, 11, Story );
			exe.writeToCell(Sheetname, i, 10, link );
			List<WebElement> elements=driver.findElements(By.xpath("//div[@class='_OKe']//div[@class='_tN mod']//div[@class='_c4 _Dnh']//a"));
			for (int j = 1; j <= elements.size(); j++) {
				//System.out.println("//"+driver.findElement(By.xpath("(//div[@class='_OKe']//div[@class='_tN mod']//div[@class='_c4 _Dnh']//a)["+j+"]")).getAttribute("title"));
				String cast=driver.findElement(By.xpath("(//div[@class='_OKe']//div[@class='_tN mod']//div[@class='_c4 _Dnh']//a)["+j+"]")).getAttribute("title");
				Main.Concatenation(Proper, cast+",");
			}
			
			System.out.println("Cast::"+Proper);
			

		}
		
	}
	
	public static StringBuffer Concatenation(StringBuffer s,String str){
		  
	      s = s.append(str);
	    
		return s;
	}
}
