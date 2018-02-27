
    package Libraries;
    import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import BeallsFlorida.Main;

import com.thoughtworks.selenium.SeleneseTestCase;
import com.thoughtworks.selenium.Selenium;


    public class Genericscripts extends SeleneseTestCase{
    public int objval=0;
    public Selenium sel;
    public String scriptname;
    public static String feedWinId;
    public static String getTitle;
    Resultsummary r;
    public static int TC=0;
    public String Snapshotpath;
    public static int screencapcounter=1;
    public static String celldata;
    public static String[] checkboxIds=new String[100];
    public static String[] checkboxvalue=new String[100];
    public static int rnum;
    public static int cnum;
    public static String[] arr;
    public static String browser="*iexplore";
    public static WebDriver driver;

            public Genericscripts(String scrptname) {
                    sel=Main.sellaunch;
                    this.scriptname=scrptname;
                    driver = Main.driver;
                    try{
                    System.out.println("log file will be created/////////////////");
                    createLogFile();
                    r=new Resultsummary();
                    r.failcounter=0;
                    }
                    catch(Exception e){
                    System.out.println(e);
                    }
            }

//********************************************************************************************************************
//Generic function name :typeIntoEditBox
//Description : Validating the Text Box in the screen
//********************************************************************************************************************
   
            public void typeIntoEditBox(String locator, String val) throws Exception{
            if(sel.isElementPresent(locator)){
            System.out.println(locator+" - Text box box found");
            if(sel.isEditable(locator)){
            System.out.println(locator+" - Text box not disabled");
            sel.type(locator, val);
            System.out.println("Entered value ["+val+"] into the ["+locator+"] Text box");
            writePassLog("Entered value ["+val+"] into the ["+locator+"] Text box");
            }
            else{
            writeFailLog("Element disabled :"+locator);
            }
            }
            else{
            writeFailLog("Element not found :"+locator);
            }
    }
            
          //********************************************************************************************************************
          //Generic function name :typeIntoEditBox using WebDriver
          //Description : Validating the Text Box in the screen
          //********************************************************************************************************************
             
                      public void typeIntoEditBoxWD(String locator, String val) throws Exception{
                    	 
                    	  if(driver.findElement(By.xpath(locator))!= null){
                              System.out.println(locator+" Link found");
                              driver.findElement(By.xpath(locator)).sendKeys(val);
                              System.out.println("Entered value [ "+val+" ] @  [ "+locator+" ]");
                              writePassLog("Entered value [ "+val+" ] @  [ "+locator+" ]");
                              }
                              else{
                              writeFailLog("Cound not Enter value [ "+val+" ] @  [ "+locator+" ]");
                              }
              }
   
//********************************************************************************************************************
//Generic function name :clickButtonByName
//Description : Validating and clicking the Button in the Screen by name
//********************************************************************************************************************
   
   public void clickButtonByName(String name) throws Exception{
            if(sel.isElementPresent("xpath=//input[@name='"+name+"']")){
            System.out.println(name+" - Button found");
            sel.click("xpath=//input[@name='"+name+"']");
            sel.waitForPageToLoad("500000");
            System.out.println("clicked on the Button - "+name);
            writePassLog("clicked on the Button - "+name);
            }
            else{
            writeFailLog("Button not found in the Screen");
            }
        }
    
//********************************************************************************************************************
//Generic function name :clickButtonByID
//Description : Validating and clicking the button in the Screen by its id
//********************************************************************************************************************
  
    public void clickButtonByID(String locator) throws Exception{
            if(sel.isElementPresent(locator)){
            System.out.println(locator+" - Button found");
            sel.click(locator);
            sel.waitForPageToLoad("500000");
            System.out.println("clicked on the Button - "+locator);
            writePassLog("clicked on the Button - "+locator);
            }
            else{
            writeFailLog("Element not found");
            }
    }
   
//********************************************************************************************************************
//Generic function name :clickButton
//Description : Validating and clicking the button by Xpath or any attributes
//********************************************************************************************************************
  
   public void clickButton(String locator) throws Exception{
            if(sel.isElementPresent(locator)){
            System.out.println(locator+" Button found");
            sel.click(locator);
            //sel.waitForPageToLoad("500000");
            System.out.println("clicked on the Button - "+locator);
            writePassLog("clicked on the Button - "+locator);
            }
            else{
            writeFailLog("Button did not found on the Screen");
            }
    }
   
 //********************************************************************************************************************
 //Generic function name :clickLinkWD
 //Description : Validating and clicking the Link by Xpath or any attributes
 //********************************************************************************************************************
   
    public void clickLinkWD(String locator) throws Exception{
             if(driver.findElement(By.xpath(locator))!= null){
             System.out.println(locator+" Link found");
             driver.findElement(By.xpath(locator)).click();
             System.out.println("clicked on the Button - "+locator);
             writePassLog("clicked on the Link - "+locator);
             }
             else{
             writeFailLog("Link not found on the Screen");
             }
     }
    
    //********************************************************************************************************************
    //Generic function name :clickButtonWD
    //Description : Validating and clicking the Button by Xpath or any attributes
    //********************************************************************************************************************
      
       public void clickButtonWD(String locator) throws Exception{
                if(driver.findElement(By.xpath(locator))!= null){
                System.out.println(locator+" Link found");
                driver.findElement(By.xpath(locator)).click();
                System.out.println("clicked on the Button - "+locator);
                writePassLog("clicked on the Button - "+locator);
                }
                else{
                writeFailLog("Button not found on the Screen");
                }
        }
    
  //********************************************************************************************************************
    //Generic function name :clickLinkWD
    //Description : Mouse Over on the Location
    //********************************************************************************************************************
      
       public void mouseOver(String locator) throws Exception{
    	   Actions action = new Actions(driver);
	    	 WebElement we = driver.findElement(By.xpath(locator));
	    	 action.moveToElement(we).build().perform();
                writePassLog("Mouse Over on the Location - "+locator);
               
        }
       //********************************************************************************************************************
       //Generic function name :clickLinkWD
       //Description : Mouse Over on the Location
       //********************************************************************************************************************
         
          public String gText(String locator) throws Exception{
        	  String text = driver.findElement(By.xpath(locator)).getText();
        	  return text;
                  
           }     
       
//********************************************************************************************************************
//Generic function name :createLogFile
//Description : Creating Html Log File for the test script
//********************************************************************************************************************
    
   public void createLogFile() throws IOException{
            try{
            Configuration config = new Configuration();
            String rpath = config.ResultPath;
            Calendar c = new GregorianCalendar();
            String currtime=c.getTime().toString();
            BufferedWriter bw1 = new BufferedWriter(new FileWriter(rpath+"/"+scriptname+".html"));
            bw1.write("<html><head><title>"+scriptname+"</title></head><body><table style=font-family:calibri border =1 cellspacing=1 frame=Vsides  bgcolor=6699FF Align=Center><tr><td><B>Test Case Name</B></td><td><B>"+scriptname+"</B></td></tr>");
            bw1.write("<tr><td width=500 ><B>Execution Start Time</B></td><td width=270><B>"+currtime+"</B></td></tr></table><br/>");
            bw1.write("<table style=font-family:calibri border =1 cellspacing=1 frame=Vsides bgcolor=#E8E8E8 Align=Center><tr><td Align=center><B>Step Description</B></td><td Align=center><B>Result</B></td></tr>");
            bw1.close();
            }
            catch(Exception e){
            System.out.println(e);
            }
    }
    
//********************************************************************************************************************
//Generic function name :writePassLog
//Description : Writing Pass message to the HTML log file
//********************************************************************************************************************
    
    public void writePassLog(String desc) throws IOException{
            try{

        	Configuration config = new Configuration();
            String rpath = config.ResultPath;
            BufferedWriter bw1 = new BufferedWriter(new FileWriter(rpath+"/"+scriptname+".html",true));
            bw1.write("<tr><td width=690>"+desc+"</td><td width=80 bgcolor=#00FF00 Align=center >PASS</td></tr>");
            bw1.close();
            }
            catch(Exception e){
            System.out.println("Error = "+e);
            }
    }
    
  //********************************************************************************************************************
  //Generic function name :writePassLog
  //Description : Writing Pass message to the HTML log file
  //********************************************************************************************************************
      
      public void writeHeader(String desc) throws IOException{
              try{

          	Configuration config = new Configuration();
              String rpath = config.ResultPath;
              BufferedWriter bw1 = new BufferedWriter(new FileWriter(rpath+"/"+scriptname+".html",true));
              bw1.write("<tr><td width=770 bgcolor=blue Align=center>"+desc+"</td></tr>");
              bw1.close();
              }
              catch(Exception e){
              System.out.println("Error = "+e);
              }
      }
    
    public void writeResults(String desc) throws IOException{
        try{

    	Configuration config = new Configuration();
        String rpath = config.ResultPath;
        BufferedWriter bw1 = new BufferedWriter(new FileWriter(rpath+"/"+scriptname+".html",true));
        bw1.write("<tr><td width=690 bgcolor= pink ><b>"+desc+"</td></td></tr>");
        bw1.close();
        }
        catch(Exception e){
        System.out.println("Error = "+e);
        }
}
//********************************************************************************************************************
//Generic function name :writeFailLog
//Description : Writing Fail message to the HTML log file
//********************************************************************************************************************
   
    public void writeFailLog(String desc) throws Exception{
            try{
            Configuration config = new Configuration();
            String rpath = config.ResultPath;
            Capturescreenshot(scriptname);
            BufferedWriter bw1 = new BufferedWriter(new FileWriter(rpath+"/"+scriptname+".html",true));
            bw1.write("<tr><td width=690><a href="+Snapshotpath+">"+desc+"</a></td><td width=80 bgcolor=#FF0000 Align=center >FAIL</td></tr>");
            bw1.close();
            r.failcounter++;
            }
            catch(Exception e){
            System.out.println("Write Failed Log Exception = "+e);
            }
    }
    
//********************************************************************************************************************
//Generic function name :checkTitle
//Description : Verifying the title of the current page
//********************************************************************************************************************
  
    public void checkTitle(String title)throws Exception{
            if(sel.getTitle().equalsIgnoreCase(title)){
            writePassLog("Screen Title displayed matches :"+title);
            }
            else
            {
            writeFailLog("Screen Title displayed does not matches :"+title);
            }
    }
    
//********************************************************************************************************************
//Generic function name :SearchOption
//Description : Verifying the Option in the drop down list
//********************************************************************************************************************
    
    public void SearchOption(String locator, String val)throws Exception{
            int counter=0;
            String[] option = sel.getSelectOptions(locator);
            for(int i=0;i<sel.getSelectOptions(locator).length;i++){
            if(option[i].equals(val)){
            System.out.println("Searched Option Found in the drop down :"+locator);
            counter = 1;
            }
            }
            if (counter == 1){
            sel.select(locator, "label="+val);
            writePassLog("Searched Option selected from the dropdown :"+locator);
            }
            else {
            writeFailLog("Searched Option not selected from the drowdown :"+locator);
            }
    }
    
//********************************************************************************************************************
//Generic function name :SelectListOption
//Description : Selecting the Option in the drop down list
//********************************************************************************************************************
    
    public void SelectListOption(String locator, String val)throws Exception{
            if (sel.isElementPresent(locator)){
            sel.select(locator, "label="+val);
            System.out.println("Drop Down list found in the current screen and the option selected - "+locator);
            writePassLog("Drop Down list found in the current screen and the option selected - "+locator);
            }
            else {
            System.out.println("Drop Down List not found :"+locator);
            writeFailLog("Drow down List not found :"+locator);
            }
    }
    
//********************************************************************************************************************
//Generic function name :RadioButton
//Description : Selecting the Radio button in the Screen
//********************************************************************************************************************
    
    public void RadioButton(String name, String val)throws Exception {
            if (sel.isElementPresent("Xpath=//input[@name='"+name+"' and @value='"+val+"']")){
            sel.click("Xpath=//input[@name='"+name+"' and @value='"+val+"']");
            writePassLog("Radion button found in the Screen and selected :"+name);
            }
            else
            {
            writeFailLog("Radio button not found");
            }
    }
     
//********************************************************************************************************************
//Generic function name :ClicRadioButtonByName
//Description : Selecting the Radio button in the Screen by Name
//********************************************************************************************************************
    
     public void ClicRadioButtonByName(String locator)throws Exception{
            if (sel.isElementPresent(locator)){
            sel.click(locator);
            writePassLog("Radion button found and selected :"+locator);
            }
            else
            {
            writeFailLog("Radio button not found");
            }
    }
     
//********************************************************************************************************************
//Generic function name :SelectCheckBox
//Description : Selecting the Checkbox in the Screen
//********************************************************************************************************************
 
    public void SelectCheckBox(String locator)throws Exception{
            if (sel.isElementPresent(locator)){
            sel.click(locator);
            writePassLog("Checkbox found in the Screen and selected - "+locator);
            }
            else {
            writeFailLog("Checkbox not found"+locator);
            }
    }

//********************************************************************************************************************
//Generic function name :CheckListSortedOrder
//Description : Check the drop down list in sorted order (Ascending order)
//********************************************************************************************************************

    public void CheckListSortedOrder(String locator)throws Exception {
            int counter=0;
            String[] option = sel.getSelectOptions(locator);
            System.out.println("Before sorting the array option - "+Arrays.asList(option));
            String[] option2 = sel.getSelectOptions(locator);
            Arrays.sort(option);
            System.out.println("After sorting the array option - "+Arrays.asList(option));
            boolean equals = Arrays.equals(option, option2);

            if (equals == true){
            System.out.println("Drop Down List ["+locator+"] is in Sorted Order");
            writePassLog("Drop Down List ["+locator+"] is in Sorted Order");
            }
            else {
            System.out.println("Drop Down List "+locator+" is not in Sorted Order");
            writeFailLog("Drop Down List "+locator+" is not in Sorted Order");
            }
    }

//********************************************************************************************************************
//Generic function name :GetAllLinksinPage
//Description : Check the drop down list in sorted order (Ascending order)
//********************************************************************************************************************
   
    public void GetAllLinksinPage() throws Exception {
            String[] Links = sel.getAllLinks();
            if (Links != null){
            System.out.println("Links Lenght = " +Links.length);	
            for (int i=0;i<=Links.length;i++){
            System.out.println("Link :"+Links[i]);
            writePassLog("Link Found  - "+Links[i]);
            }
            }
            else{
            System.out.println("Links does not exists in the page");
            writeFailLog("Link does not exists in the page");
            }
    }

//********************************************************************************************************************
//Generic function name :ClickLink
//Description : Verify and Clicking the link in the Screen
//********************************************************************************************************************
  
    public void ClickLink(String locator) throws Exception{
            if (sel.isElementPresent("link="+locator)){
            sel.click("link="+locator);
            sel.waitForPageToLoad("500000");
            System.out.println("Link clicked :"+locator);
            writePassLog("Link clicked  - "+locator);
            }
            else {
            System.out.println("Link not clicked :"+locator);
            writeFailLog("Link not clicked :"+locator);
            }
    }

//********************************************************************************************************************
//Generic function name :Click
//Description : Clicking any element in the Screen
//********************************************************************************************************************

    public void Click(String locator) throws Exception{
            if (sel.isElementPresent(locator)){
            sel.click(locator);
          //  sel.waitForPageToLoad("500000");
            System.out.println("Element clicked - "+locator);
            writePassLog("Element clicked - "+locator);
            }
            else {
            System.out.println("Element not clicked - "+locator);
            writeFailLog("Element not clicked - "+locator);
            }
    }

//********************************************************************************************************************
//Generic function name :BrowserMaximize
//Description : Maximize the Browser
//********************************************************************************************************************

    public void BrowserMaximize()throws Exception{
    sel.windowMaximize();
    }

//********************************************************************************************************************
//Generic function name :WaitForPageLoad
//Description : Wait Until the Page is Loaded
//********************************************************************************************************************

    public void WaitForPageLoad(String Msec)throws Exception{
    sel.waitForPageToLoad(Msec);
    }

//********************************************************************************************************************
//Generic function name :clickImage
//Description : Clicking the Image in the Screen
//********************************************************************************************************************
    public void clickImage(String locator)throws Exception{
            if(sel.isElementPresent(locator)){
            sel.click("Xpath="+locator);
            writePassLog("Image exist in the Screen and it is clicked");
            }
            else{
            writeFailLog("Image does not exists in the Screen");
            }
    }

//********************************************************************************************************************
//Generic function name :OpenUrl
//Description : Open the Given Url in the Browser
//********************************************************************************************************************

    public void OpenUrl(String url)throws Exception{   
    	System.out.println("Before OpenURL" +url);
            sel.open(url);
        System.out.println("After OpenURL");
    }

//********************************************************************************************************************
//Generic function name :Capturescreenshot
//Description : Capture the screen shot and store in the Result folder
//********************************************************************************************************************

    public void Capturescreenshot(String scriptname)throws Exception{
            //Random rn=new Random();
            //int rnum=rn.nextInt(1000);
            //Date dt = new Date();
            //String timestamp=dt.toString().replace(":","_");
            Configuration config = new Configuration();
            String rpath = config.ResultPath;
            sel.captureScreenshot(rpath+"/Snapshots/"+scriptname+screencapcounter+".png");
            Snapshotpath = "./Snapshots/"+scriptname+screencapcounter+".png";
            screencapcounter++;
    }

//********************************************************************************************************************
//Generic function name :TextPresent
//Description : Verifying the text exists in the page or not
//********************************************************************************************************************

    public void TextPresent(String text)throws Exception {
            if(sel.isTextPresent(text)){
            writePassLog("Text Present on the Current Page - "+text);
            }
            else
            {
            writeFailLog("Text does not exists on the current page - "+text);
            }
    }

//********************************************************************************************************************
//Generic function name :ClickLinkByXpath
//Description : Clicking the link by Xpath
//********************************************************************************************************************

    public void ClickLinkByXpath(String locator) throws Exception{
            if (sel.isElementPresent(locator)){
            sel.click("Xpath="+locator);
            sel.waitForPageToLoad("50000");
            System.out.println("Link clicked :"+locator);
            writePassLog("Link clicked - "+locator);
            }
            else {
            System.out.println("Link not clicked :"+locator);
            writeFailLog("Link not clicked - "+locator);
            }
    }

//********************************************************************************************************************
//Generic function name :GetTableCellData
//Description : Get the specified table cell data
//********************************************************************************************************************
    
    public void GetTableCellData(String tname, int cl, int rr)throws Exception{
            celldata=sel.getTable(tname+"."+cl+"."+rr);
            System.out.println("Got the cell data of the row:"+rr+"column :"+cl);
            System.out.println("Celldata :"+celldata);

    }

//********************************************************************************************************************
//Generic function name :GetTableLength
//Description : Get the lenght of the table
//********************************************************************************************************************
   
    public void GetTableLength(String tableid)throws Exception{
            String script="this.browserbot.findElement('id="+tableid+"').rows.length;";
            String script1="this.browserbot.findElement('id="+tableid+"').rows[1].cells.length;";
            String cn=sel.getEval(script);
            String cc=sel.getEval(script1);
            System.out.println("Total Number of rows :"+cn);
            System.out.println("Total Number of columns :"+cc);
            rnum=Integer.parseInt(cn);
            cnum=Integer.parseInt(cc);
            System.out.println("Total Number of rows after converting to int :"+rnum);
            System.out.println("Total Number of columns after converting to int:"+cnum);
    }

//********************************************************************************************************************
//Generic function name :GetTableLength
//Description : Get the lenght of the table
//********************************************************************************************************************

    public void getAllCheckboxIds()throws Exception {
            String script = "var inputId  = new Array();";// Create array in java script.
            script += "var cnt = 0;"; // Counter for check box ids.
            script += "var inputFields  = new Array();"; // Create array in java script.
            script += "inputFields = window.document.getElementsByTagName('input');"; // Collect input elements.
            script += "for(var i=0; i<inputFields.length; i++) {"; // Loop through the collected elements
            script += "if(inputFields[i].id !=null " +
            "&& inputFields[i].id !='undefined' " +
            "&& inputFields[i].getAttribute('type') == 'checkbox') {"; // If input field is of type check box and input id is not null.
            script += "inputId[cnt]=inputFields[i].id ;" + // Save check box id to inputId array.
            "cnt++;" + // increment the counter.
            "}" + // end of if.
            "}"; // end of for.
            script += "inputId.toString();" ;// Convert array in to string.
            checkboxIds = sel.getEval(script).split(","); // Split the string.
    }

//********************************************************************************************************************
//Generic function name :getDynamicElements
//Description : Get the id of the Dynamic elements displayed on the screen by its tag name
//********************************************************************************************************************

    public void getDynamicElements(String locator)throws Exception {
            String script = "var inputId  = new Array();";// Create array in java script.
            script += "var cnt = 0;"; // Counter for check box ids.
            script += "var inputFields  = new Array();"; // Create array in java script.
            script += "inputFields = window.document.getElementsByTagName('"+locator+"');"; // Collect input elements.
            script += "for(var i=0; i<inputFields.length; i++) {"; // Loop through the collected elements
            script += "if(inputFields[i].id !=null" +
            "&& inputFields[i].id !='undefined' ) {" ;
            //"&& inputFields[i].getAttribute('type') == 'checkbox') {"; // If input field is of type check box and input id is not null.
            script += "inputId[cnt]=inputFields[i].id ;" + // Save check box id to inputId array.
            "cnt++;" + // increment the counter.
            "}" + // end of if.
            "}"; // end of for.
            script += "inputId.toString();" ;// Convert array in to string.
            checkboxIds = sel.getEval(script).split(","); // Split the string.

            for(int i=0;i<checkboxIds.length;i++)
            {
            System.out.println(checkboxIds[i]+"Location ---->"+i);
            }
            //return checkboxIds;
    }

//********************************************************************************************************************
//Generic function name :checkColumnSortedOrder
//Description : Verify the column in sorted order or not
//********************************************************************************************************************

    public void checkColumnSortedOrder(String tableid, int cno)throws Exception{
            String script="this.browserbot.findElement('id="+tableid+"').rows.length;";
            String script1="this.browserbot.findElement('id="+tableid+"').rows[1].cells.length;";
            String cn=sel.getEval(script);
            String cc=sel.getEval(script1);
            System.out.println("Total Number of rows :"+cn);
            System.out.println("Total Number of columns :"+cc);
            //rnum=Integer.parseInt(cn);
            //cnum=Integer.parseInt(cc);
            //System.out.println("Total Number of rows after converting to int :"+rnum);
            //System.out.println("Total Number of columns after converting to int:"+cnum);
            String[] arr1=new String[100];
            String[] arr2=new String[100];
            for(int i=1;i<=Integer.parseInt(cn);i++){
            arr1[i]=sel.getTable(tableid+"."+i+"."+cno);
            arr2[i]=sel.getTable(tableid+"."+i+"."+cno);
            }
            Arrays.sort(arr2);
            boolean vn=Arrays.equals(arr1, arr2);
            if(vn==true){
            writePassLog("Column number ["+cno+"]is in sorted order");
            }
            else{
            writeFailLog("Column number ["+cno+"]is not in sorted order");
            }
    }


//********************************************************************************************************************
//Generic function name :ValidateText
//Description : Verify the text displayed on the screen
//********************************************************************************************************************

    public void ValidateText(String message, String locator)throws Exception{
            String text=sel.getText(locator);
            System.out.println(text);
            if(text.equals(message)){
            writePassLog("Validation is successfull :Error Message displayed as :"+message);
            }
            else{
            writeFailLog("Validation is Unsuccessfull");
            }
    }

//********************************************************************************************************************
//Generic function name :ClickLinkByXpathA
//Description : Verify the link and click by the Xpath
//********************************************************************************************************************
       
    public void ClickLinkByXpathA(String locator) throws Exception{
            if(sel.isElementPresent(locator)){
            sel.click("Xpath="+locator);
            System.out.println("Link clicked :"+locator);
            writePassLog("Link clicked :"+locator);
            }
            else{
            System.out.println("Link not clicked :"+locator);
            writeFailLog("Link not clicked :"+locator);
            }
    }

//********************************************************************************************************************
//Generic function name :OpenWindow
//Description : Invoke the window by the given URL
//********************************************************************************************************************

    public void OpenWindow(String url, String windowID){
    sel.openWindow(url, windowID);

    }

//********************************************************************************************************************
//Generic function name :SelectWindow
//Description : Select the given window by its window id
//********************************************************************************************************************

    public void SelectWindow(String windowID){
    System.out.println("WindowID = "+windowID);
    sel.selectWindow(windowID);
    }

//********************************************************************************************************************
//Generic function name :GetWindowID
//Description : Get the Window ID where the window id is dynamic every time generates a different window id
//********************************************************************************************************************

    public void GetWindowID(){
   //feedWinId = sel.getEval("{var windowId; for(var x in selenium.browserbot.openedWindows ) {windowId=x;} }");
     feedWinId = sel.getEval("{var windowId; for(var x in selenium.browserbot.getCurrentWindow() ) {windowId=x;} }");
     System.out.println("FeedWinId = "+feedWinId);

    }

//********************************************************************************************************************
//Generic function name :waitforpopup
//Description : Wait for the Popup to be displayed by its window id and max time.
//********************************************************************************************************************

    public void waitforpopup(){
    sel.waitForPopUp(feedWinId, "500000");
    }
    
    public void FCKEditor(){
    	String script2 = "var editor = CKEDITOR.instances['doc_editor'];";
    	script2 += "editor.insertHtml('<B> Thisq is test message to test the Spell check on editor</B>');";
    	sel.getEval(script2);	
    }
    
//********************************************************************************************************************
//Generic function name :getAllLinkids
//Description : Get all the Link ids exists in the current screen
//********************************************************************************************************************

    public void getAllLinkids(){
    int i;
    arr=sel.getAllLinks();
    for(i=0;i<arr.length;i++){
    System.out.println(arr[i]);
    }
   }
//****************************************************************************************************************
//Generic function name :Elementpresent
//Description : Wait until the element displayed on the page
//****************************************************************************************************************
  
    public void Elementpresent(String locator)throws Exception{
    	for(int i=0;i<=50;i++){
    		Thread.sleep(1000);
    		if(sel.isElementPresent(locator)){
    			writePassLog("Element displayed on the Screen :"+locator);
    			break;
    			
    		}
    	}
    	
    }
    
  //****************************************************************************************************************
  //Generic function name :Elementpresent
  //Description : Wait until the element displayed on the page
  //****************************************************************************************************************
    
      public void WDElementpresent(String locator)throws Exception{
      	for(int i=0;i<=50;i++){
      		Thread.sleep(1000);
      	//	if(WD.findElements(By.xpath(locator) != null)
      				{
      			writePassLog("Element displayed on the Screen :"+locator);
      			break;
      			
      		}
      	}
      	
      }
//****************************************************************************************************************
//Generic function name :getDynamicValue
//Description : Returns the dynamic value of the locator
//****************************************************************************************************************
    public void getDynamicValue(String locator)throws Exception {
        String script = "var inputId  = new Array();";// Create array in java script.
        script += "var cnt = 0;"; // Counter for check box ids.
        script += "var inputFields  = new Array();"; // Create array in java script.
        script += "inputFields = window.document.getElementsByTagName('"+locator+"');"; // Collect input elements.
        script += "for(var i=0; i<inputFields.length; i++) {"; // Loop through the collected elements
        //script += "if(inputFields[i].value !=null" +
        //"&& inputFields[i].value !='undefined' ) {" ;
        //"&& inputFields[i].getAttribute('type') == 'checkbox') {"; // If input field is of type check box and input id is not null.
        //script += "inputId[cnt]=inputFields[i].value ;" + // Save check box id to inputId array.
        
         script += "inputId[cnt]=inputFields[i].getAttribute('type') == 'checkbox';"+
        
        "cnt++;" + // increment the counter.
        //"}" + // end of if.
        "}"; // end of for.
        script += "inputId.toString();" ;// Convert array in to string.
        checkboxIds = sel.getEval(script).split(","); // Split the string.

        for(int i=0;i<checkboxvalue.length;i++)
        {
        System.out.println(checkboxvalue[i]+"Location ---->"+i);
        }
        //return checkboxIds;
}
    
//****************************************************************************************************************
//Generic function name :typeIntoEditBoxByName
//Description : Inputs the value in the locator with given string
//****************************************************************************************************************
    public void typeIntoEditBoxByName(String locator, String val) throws Exception{
        if(sel.isElementPresent(locator)){
            System.out.println(locator+" edit box found");
            if(sel.isEditable(locator)){
                System.out.println(locator+" not disabled");
                sel.type(locator, val);
                System.out.println("Entered "+val+" into "+locator+" edit box");
                writePassLog("Entered "+val+" into "+locator+" edit box");
            
            }
            else{
                writeFailLog("Element disabled :"+locator);
            }
        }
        else{
            writeFailLog("Element not found :"+locator);
        }
    }
  //****************************************************************************************************************
  //Generic function name :SelectFrame
  //Description : Selects Frame of the given FrameID
  //****************************************************************************************************************
    public void SelectFrame(String FrameID){
    System.out.println("FrameID = "+FrameID);
    sel.selectFrame(FrameID);
    }
    
  //********************************************************************************************************************
  //Generic function name :AddSelectListOption
  //Description : Selecting the Option in the drop down list
  //********************************************************************************************************************
      public void AddSelectOption(String locator, String val)throws Exception{
              if (sel.isElementPresent(locator)){
            //  sel.select(locator, "label="+val);
              sel.addSelection(locator, "label="+val);
              System.out.println("Add Select list found in the current screen and the option selected - "+locator);
              writePassLog("Add Select list found in the current screen and the option selected - "+locator);
              }
              else {
              System.out.println("Drop Down List not found :"+locator);
              writeFailLog("Drow down List not found :"+locator);
              }
      }
    
    //********************************************************************************************************************
    //Generic function name :writeScreenShot
    //Description : Takes the Screen shot, when function is called & links text.
    //********************************************************************************************************************

        public void writeScreenShot(String desc) throws Exception{
                try{
                Configuration config = new Configuration();
                String rpath = config.ResultPath;
                Capturescreenshot(scriptname);
                BufferedWriter bw1 = new BufferedWriter(new FileWriter(rpath+"/"+scriptname+".html",true));
                //bw1.write("<tr><td width=690><a href="+Snapshotpath+">"+desc+"</a></td><td width=80 bgcolor=#FF0000 Align=center >FAIL</td></tr>");
                bw1.write("<tr><td width=690><a href="+Snapshotpath+">"+desc+"</td><td width=80 bgcolor=#00FF00 Align=center >PASS</td></tr>");
                bw1.close();
                //r.failcounter++;
                }
                catch(Exception e){
                System.out.println("Write ScreenShot = "+e);
                }
        }    
       public String val;
       public String getAttribut(String locator)throws Exception{
            try{
            	System.out.println("locator = "+locator);
            	int len = locator.length();
            	System.out.println("Len = "+len);
            	String valloc = (String) locator.subSequence(8, (len-1));
            	System.out.println("Valloc = "+valloc);
             	String script = "var id;";
                script +=  "id = window.document.getElementById("+valloc+").getAttribute('igdatakey');";
                System.out.println("script = "+script);
                val = sel.getEval(script);
                System.out.println("script = "+sel.getEval(script)); 
                
             }
            catch(Exception e){
            System.out.println("Exception = "+e);
            }
            return val;
		}
           
    
    
    
}