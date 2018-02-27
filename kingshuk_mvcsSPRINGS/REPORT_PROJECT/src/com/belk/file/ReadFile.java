/**********************************************************************************
*                                                                                 
* @author $Author: SPI (Barsha Mohanty)    
* @version $Revision: $, $Date: $
***********************************************************************************
* Package          :  default
* Class Type       :  Class
***********************************************************************************
*
* This is the ReadFile class for APX application.
* It is acting as a ReadFile  class for ReportGeneration functionality.
***********************************************************************************
* Revision History
* 
-----------------------------------------------------------------------------------
* Created Date                :                13th November 2015
* Last Modified Date          :                13th November 2015
-----------------------------------------------------------------------------------
* Modification History
* 1. Initial creation of GenerateReport process .
***********************************************************************************
*/
package com.belk.file;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadFile {
	public Properties props = new Properties();
	public ReadFile(){
		try {
			FileReader reader=new FileReader("Report.properties");			
			props.load(reader);
			} 
		catch (FileNotFoundException fileNotFoundException) {
			throw new RuntimeException(fileNotFoundException);
		} catch (IOException ioException) {
			throw new RuntimeException(ioException);
		}
	}
	/**
	 * This method is responsible to get properties file value.
	 * @param name
	 * @return String
	 */
	public String getProperty(String name) {
		return props.getProperty(name);
	}
}
