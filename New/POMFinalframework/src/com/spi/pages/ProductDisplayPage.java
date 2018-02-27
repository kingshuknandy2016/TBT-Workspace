package com.spi.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDisplayPage {

	WebDriver driver;	
  
  @FindBy(xpath=PDPConstants.NoofItemsPage30)
  WebElement NoofItemsPage30;
  
  @FindBy(xpath=PDPConstants.NoofItemsPage60)
  WebElement NoofItemsPage60;
  
  @FindBy(xpath=PDPConstants.NoofItemsPage90)
  WebElement NoofItemsPage90;
  
  @FindBy(className=PDPConstants.ItemsBlock)
  List <WebElement>  ItemsBlock;
  
  
//---------------Page Navigators--------------------
  
  @FindBy(xpath=PDPConstants.TopRightArrow)
  WebElement TopRightArrow;
 
  @FindBy(xpath=PDPConstants.BottomRightArrow)
  WebElement BottomRightArrow;
  
  @FindBy(xpath=PDPConstants.TopLeftArrow)
  WebElement TopLeftArrow;
  
  @FindBy(xpath=PDPConstants.BottomLeftArrow)
  WebElement BottomLeftArrow;
  
  @FindBy(xpath=PDPConstants.TopLastPageArrow)
  WebElement TopLastPageArrow;
  
  @FindBy(xpath=PDPConstants.BottomLastPageArrow)
  WebElement BottomLastPageArrow;
  
  @FindBy(xpath=PDPConstants.TopLastPageArrow)
  WebElement TopFirstPageArrow;
  
  @FindBy(xpath=PDPConstants.BottomFirstPageArrow)
  WebElement BottomFirstPageArrow;
  
//--------------------------------------------------
  
  public ProductDisplayPage(WebDriver driver2) {
	 this.driver=driver2;
}


public void ClickOnItemsPerPage(int NoOfItems){
	  if(NoOfItems==30){
		  try{
			  NoofItemsPage30.click();
			    
			    }catch(Exception e1){
			    System.out.println("Already NoofItems/Page is 30");	
			    }
	  }else if(NoOfItems==60){
		  try{
			  NoofItemsPage60.click();
			    
			    }catch(Exception e1){
			    System.out.println("Already NoofItems/Page is 60");	
			    }
	  }
      else {
		  try{
			  NoofItemsPage90.click();
			    
			    }catch(Exception e1){
			    System.out.println("Already NoofItems/Page is 90");	
			    }
    	 
    	 
	  }
  }

public int NoOfItemsDisplayed(){
	int size=ItemsBlock.size();
    return size;
	
}

public void ClickOnRightPageArrow(){
	
}

public void ClickOnLeftPageArrow(){
	
}
public void ClickOnLastPageArrow(){
	
}
public void ClickOnFirstPageArrow(){
	
}

}
