package com.spi.basics;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TestCase1 {

	public static void main(String[] args) throws InterruptedException {

    WebDriver driver=null;
    driver=new FirefoxDriver();
    driver.get("http://q3.beallsflorida.com/");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    
    Actions actions = new Actions(driver);
    WebElement mainMenu = driver.findElement(By.xpath("//nav[@class='main-nav primary']/a[2]"));
    actions.moveToElement(mainMenu).build().perform();
    
    
    WebElement SubMenu=driver.findElement(By.xpath("//div[@class='homeCol']/span[@class='LeftColumn']/li/a[@href='/online/shop/womens-dresses?orderBy=6']"));
    SubMenu.click();
   // System.out.println("compleated------");
    Thread.sleep(4000);
   /* driver.findElement(By.xpath("//a[@href='http://www.beallsflorida.com/online/shop/bath-accessories']")).click();
    Thread.sleep(2000);
    int i=0;
    for(int j=0;j<7;j++){
    List <WebElement> prod=driver.findElements(By.xpath("//div[@class='item-name match-height-element']"));
    
    int k=0;
    for(WebElement list:prod){
   	 
   	 if(list.getText().isEmpty()){
   		 driver.findElement(By.xpath("//a[@class='fsrCloseBtn']")).click();
   	 }else{
   	 ++i;
   	 ++k;
   	 
   	 String Price=driver.findElement(By.xpath("(//div[@class='item-price match-height-element']/div[@class='price'])["+k+"]")).getText();
   	 System.out.println(i+":"+list.getText()+"  Price::"+Price);
   	 
   	 }
    }
    Thread.sleep(1000);
   // System.out.println("No:"+j);
    if(j==6){
   	System.out.println("All data collected"); 
    }else{
    driver.findElement(By.xpath("(//span[@class='icon-page-next'])[1]")).click();
    }
    }*/

	}

}
