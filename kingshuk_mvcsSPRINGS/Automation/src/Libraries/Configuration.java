/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Libraries;
import java.io.File;

import jxl.Sheet;
import jxl.Workbook;

import com.thoughtworks.selenium.Selenium;

public class Configuration {

//Global Variables & Array declaratiion and Initialization
	
public static Selenium seli;
public static String ControlScriptPath;
public static String ResultPath;
public static String Zippedfile;
public static String Browser;
public static String TDPath;
public static String FEMUrl;

public Configuration()throws Exception{
        Workbook w = Workbook.getWorkbook(new File("C:/WorkSpace/Automation/Utility/Utility.xls"));
        Sheet s=w.getSheet("Path");
        ControlScriptPath=s.getCell(1,0).getContents();
        System.out.println(ControlScriptPath);
        ResultPath=s.getCell(1,1).getContents();
        System.out.println("ResultPath = " +ResultPath);
        Zippedfile=s.getCell(1,2).getContents();
        TDPath=s.getCell(1,3).getContents();
        w.close();
        
        Workbook w1 = Workbook.getWorkbook(new File("C:/WorkSpace/Automation/Utility/Utility.xls"));
        Sheet s1=w1.getSheet("Setup");
        FEMUrl=s1.getCell(1,12).getContents();
        w.close();
    }
//Assigning URL's for the Global Variables

}
