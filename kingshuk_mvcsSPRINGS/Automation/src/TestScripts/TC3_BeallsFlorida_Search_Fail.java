/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TestScripts;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

import jxl.Sheet;
import jxl.Workbook;
import BeallsFlorida.Main;
import Libraries.Genericscripts;
import Libraries.ProjectSpecific;
import Libraries.Resultsummary;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.SeleniumException;

public class TC3_BeallsFlorida_Search_Fail {
	
	ProjectSpecific rt = new ProjectSpecific();
	Resultsummary rs = new Resultsummary();
	public static Selenium sel;
	Genericscripts gs = new Genericscripts(getClass().getSimpleName());
	//public static Xpath xp;
	
	public TC3_BeallsFlorida_Search_Fail ()throws Exception{
		sel=Main.sellaunch;
//		xp = Main.xpath;	
	}
     
     public void TC3_BeallsFlorida_Search_Fail()throws Exception{
    	 try
 		{	
    	 System.out.println("*******----- TC3_BeallsFlorida_Search_Fail -----*******");	
    	Genericscripts gs = new Genericscripts(getClass().getSimpleName());
    	sel.windowMaximize();
    	
    	gs.Elementpresent("//*[@id='SimpleSearchForm_SearchTerm']");
    	
            
    	//Read the Search data
    	Workbook w = Workbook.getWorkbook(new File("C:/WorkSpace/Automation/TestData/TestData.xls"));
		Sheet s = w.getSheet("TC2_BeallsFlorida_Search");

		int rc = s.getRows();
		System.out.println("Search Data row count : " + rc);
		
		if(sel.isElementPresent("//*[@id='SimpleSearchForm_SearchTerm1']"))
		{
			for (int i = 1; i < rc; i++) {
				String searchData = s.getCell(0, i).getContents();
				System.out.println(searchData);
				
				gs.typeIntoEditBox("//*[@id='SimpleSearchForm_SearchTerm1']", searchData);
				gs.clickButton("//*[@id='search-btn']");
				gs.Elementpresent("//*[@id='Search_Result_Summary']/span[2]");
				String searchIteam = sel.getText("//*[@id='Search_Result_Summary']/span[2]");
				System.out.println(searchIteam);
				gs.writeResults(searchIteam);
				searchIteam=null;
								
			}
		}
		else {
			gs.Elementpresent("");
			gs.writeFailLog("Search Element '//*[@id='SimpleSearchForm_SearchTerm1']' Not Found");
		}
		
        if(rs.failcounter>0){        	
            rs.writeFailSummary(getClass().getSimpleName(), "FAIL");
            Main.fail++; 
            Main.failTestScript.add(getClass().getSimpleName()); 
        }
        else{
        	 rs.writePassSummary(getClass().getSimpleName(), "PASS");
        	 Main.pass++;
        }
      }
    	 catch(SeleniumException e){
 			System.out.println(e);
 			StringWriter sw = new StringWriter();
 			e.printStackTrace(new PrintWriter(sw));
 			String st=sw.toString();
 			gs.writeFailLog(st);
 			rs.writeFailSummary(getClass().getSimpleName(), "FAIL");
 		}
     }
     
 }