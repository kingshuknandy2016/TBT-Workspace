/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TestScripts;
import java.io.PrintWriter;
import java.io.StringWriter;

import BeallsFlorida.Main;
import Libraries.Genericscripts;
import Libraries.ProjectSpecific;
import Libraries.Resultsummary;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.SeleniumException;

public class TC1_BeallsFlorida_Access {
	
	ProjectSpecific rt = new ProjectSpecific();
	Resultsummary rs = new Resultsummary();
	public static Selenium sel;
	Genericscripts gs = new Genericscripts(getClass().getSimpleName());
	//public static Xpath xp;
	
	public TC1_BeallsFlorida_Access ()throws Exception{
		sel=Main.sellaunch;
//		xp = Main.xpath;	
	}
     
     public void TC1_BeallsFlorida_Access()throws Exception{
    	 try
 		{	
    	 System.out.println("*******----- TC1_BeallsFlorida_Access -----*******");	
    	Genericscripts gs = new Genericscripts(getClass().getSimpleName());
    	sel.windowMaximize();
    	
    	gs.Elementpresent("//*[@id='SimpleSearchForm_SearchTerm']");
    	
    	gs.TextPresent("Hello Guest");
    	
    	if(sel.isTextPresent("Hello Guest"))
		{
			gs.writePassLog(sel.getTitle()+"<B> | Bealls Florida Access is Successful</B>");
		}
		else
		{
			gs.writeFailLog(sel.getTitle()+"<B> | Bealls Florida Access is Failed</B>");
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