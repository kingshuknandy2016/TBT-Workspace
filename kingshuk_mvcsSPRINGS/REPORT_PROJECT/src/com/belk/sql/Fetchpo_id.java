/**********************************************************************************
*                                                                                 
* @author $Author: SPI(Barsha Mohanty)                                      
* @version $Revision: $, $Date: $
***********************************************************************************
* Package          :  default
* Class Type       :  Class
***********************************************************************************
*
* This is the Fetchpo_id class for APX ReportGeneration application.
* It is acting as a class for fetching the po ids from log of DPO_Batch Process
***********************************************************************************
* Revision History
* 
-----------------------------------------------------------------------------------
* Created Date                :               13th November 2015
* Last Modified Date          :               13th November 2015
-----------------------------------------------------------------------------------
* Modification History
* 1. Initial creation of fetching po ids process .
***********************************************************************************
*/
package com.belk.sql;

public class Fetchpo_id {
		public static String GetPO_id()
	{
		//Execute persistence logic and get po_id and return as string array.
		//String ar1="";
		//ar1=ar1+"'"+rs.getid("DB2SCHEMA")+"',";
		String ar="'274437','276180','276190','276191','276192','276194','276195'";
		return ar;
	}
}
