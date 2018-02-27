/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BeallsFlorida;

import java.io.File;

import jxl.Sheet;
import jxl.Workbook;
import Libraries.Configuration;
import Libraries.ProjectSpecific;
import TestScripts.TC1_BeallsFlorida_Access;
import TestScripts.TC2_BeallsFlorida_Search;
import TestScripts.TC3_BeallsFlorida_Search_Fail;
import TestScripts.TC4_BeallsFlorida_ShoppingCart;
import TestScripts.TC5_ShoppingItems;
import TestScripts.Contents.Verification.TC_PlaceOrder_Guest;

public class SubDriver {

	ProjectSpecific ps = new ProjectSpecific();
	public SubDriver ()throws Exception{
		//Constructor	
		}
	public void GetTestScriptName() throws Exception {

		String CSpath = Configuration.ControlScriptPath;
		Workbook w = Workbook.getWorkbook(new File(CSpath));
		Sheet s = w.getSheet("Sanity");

		int rc = s.getRows();
		ps.rowCount = rc-1;
		System.out.println("Control Script row count : " + rc);
		System.out.println("+++++++++++");
		try {
			for (int i = 1; i < rc; i++) {
				String executionstatus = s.getCell(2, i).getContents();
				String TestScriptid = s.getCell(0, i).getContents();
				String TestScriptName = s.getCell(1, i).getContents();
				int Tid = Integer.parseInt(TestScriptid);

				System.out.println(Tid);

				if (executionstatus.equalsIgnoreCase("Run")) {
					switch (Tid) {
					case 1:
						System.out.println("*******--TC1 SubDriver--*******");
						Main.Tname = TestScriptName;
						System.out.println("/////////BeallsFlorida_Access");
						//Main.StartSelenium();
						Main.StartSeleniumWD();
						//System.out.println("/////////BeallsFlorida_Access112");
						TC1_BeallsFlorida_Access ts1 = new TC1_BeallsFlorida_Access();
						ts1.TC1_BeallsFlorida_Access();
						Main.sellaunch.close();
						Main.StopSelenium();
						break;
					case 2:
						System.out.println("*******--TC2 SubDriver--*******");
						Main.Tname = TestScriptName;
						//Main.StartSelenium();
						Main.StartSeleniumWD();
						TC2_BeallsFlorida_Search ts2 = new TC2_BeallsFlorida_Search();
						ts2.TC2_BeallsFlorida_Search();
						Main.sellaunch.close();
						Main.StopSelenium();
						break;
					case 3:
						System.out.println("*******--TC3 SubDriver--*******");
						Main.Tname = TestScriptName;
						Main.StartSelenium();
						TC3_BeallsFlorida_Search_Fail ts3 = new TC3_BeallsFlorida_Search_Fail();
						ts3.TC3_BeallsFlorida_Search_Fail();
						Main.sellaunch.close();
						Main.StopSelenium();
						break;
					case 4:
						System.out.println("*******--TC4 SubDriver--*******");
						Main.Tname = TestScriptName;
						Main.StartSelenium();
						TC4_BeallsFlorida_ShoppingCart ts4 = new TC4_BeallsFlorida_ShoppingCart();
						ts4.TC4_BeallsFlorida_ShoppingCart();
						Main.sellaunch.close();
						Main.StopSelenium();
						break;
					case 5:
						System.out.println("*******--TC5 SubDriver--*******");
						Main.Tname = TestScriptName;
						Main.StartSeleniumWD();
						TC5_ShoppingItems ts5 = new TC5_ShoppingItems();
						ts5.TC5_ShoppingItems();
						Main.sellaunch.close();
						Main.StopSelenium();
						break;
					case 6:
						System.out.println("*******--TC_PlaceOrder_Guest SubDriver--*******");
						Main.Tname = TestScriptName;
						//System.out.println("+++++The script that started is::"+Main.Tname);
						//Main.StartSelenium();
						Main.StartSeleniumWD();
						TC_PlaceOrder_Guest tsPG = new TC_PlaceOrder_Guest();
						tsPG.TC_PlaceOrder_Guest();
						//-----use of this function
						Main.sellaunch.close();
						Main.StopSelenium();
						break;
						
					
					}
				} else if (executionstatus.equalsIgnoreCase("Ignore")) {
					System.out.println("Execution not started for the TestScript id : "+ Tid);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		w.close();
	}
}
