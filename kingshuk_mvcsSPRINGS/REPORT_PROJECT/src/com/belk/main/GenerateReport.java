/**********************************************************************************
*                                                                                 
* @author $Author: SPI(Barsha Mohanty)                                    
* @version $Revision: $, $Date: $
***********************************************************************************
* Package          :  default
* Class Type       :  Class
***********************************************************************************
*
* This is the GenerateReport class for APX application.
* It is acting as a Main  class for Generating the report functionality.
***********************************************************************************
* Revision History
* 
-----------------------------------------------------------------------------------
* Created Date                :               13th November 2015
* Last Modified Date          :               13th November 2015
-----------------------------------------------------------------------------------
* Modification History
* 1. Initial creation of GenerateReport process .
***********************************************************************************
*/
package com.belk.main;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.belk.dtos.ReportDTO;
import com.belk.email.Email;
import com.belk.excel.GenerateExcelFile;
import com.belk.file.ReadFile;

import com.belk.sql.Query;

public class GenerateReport {
	private static ReadFile file = null;
	private static FileWriter logWriter = null;
	/**
	 * This method is responsible to generate the report from the query with pop ids 
	 * in an excel sheet and send the email with this attached spreadsheet. 
	 * @param args
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static void main(String[] po_ids) throws IOException, SQLException, ClassNotFoundException {
		try {
			file = new ReadFile();
			logWriter = new FileWriter(file.getProperty("logFileName"),false);
			logWriter.write("Generate Report with data from DB process starts execution.....\n");
           	List<ReportDTO> reportDTOList = getReportDetailsFromDB(file);
           	logWriter.write("Generate Report with data in excel sheet process starts execution.....\n");
           	GenerateExcelFile.generateExcelFile(reportDTOList,file,logWriter);
           	logWriter.write(" Sending email with the attached report process starts execution.....\n");
			Email.sendEmail(file);
		} finally {
			 if (logWriter != null) {
					logWriter.close();
			}
		 }
      } 
	/**This method is getting results from the query
	 * @param file 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	private static List<ReportDTO> getReportDetailsFromDB(ReadFile file) throws SQLException, ClassNotFoundException, IOException {
		List<ReportDTO> reportDetailsList = new ArrayList<ReportDTO>();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getDB2Conn();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(Query.getReportQuery(file));

			while (resultSet.next()) {
				ReportDTO reportDto = new ReportDTO();
				reportDto.setDeptNbr(resultSet.getInt("DEPT_NBR"));
				reportDto.setPlanName(resultSet.getString("PLAN_NAME"));
				reportDto.setVendorStyleTxt(resultSet.getString("VENDOR_STYLE_TXT"));
				reportDto.setColorDescr(resultSet.getString("COLOR_DESCR"));
				reportDto.setStoreImportId(resultSet.getInt("STORE_IMPORT_ID"));
				reportDto.setEcomImportId(resultSet.getInt("ECOM_IMPORT_ID"));
				reportDto.setErrMsg(resultSet.getString("ERR_MSG"));
				reportDetailsList.add(reportDto);
				System.out.println(reportDetailsList);
				logWriter.write("Report data fetching from DB process ends.....\n");
			}
		}finally {
			closeDBResources(statement, connection,resultSet);
		}
		return reportDetailsList;
}
	 /**This method works for the Connection with the database 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	private static Connection getDB2Conn() throws ClassNotFoundException, SQLException, IOException {
    Properties props = new Properties();
    String url = file.getProperty("DB2DriverUrl");
    String user = file.getProperty("DB2DriverUserName");
    String pwd = file.getProperty("DB2DriverPassword");
    props.setProperty("user", user);
    props.setProperty("password", pwd);
    Class.forName(file.getProperty("DB2DriverClassName"));
    Connection connect = DriverManager.getConnection(url, props);
    logWriter.write("\nDB URL : " + url + "\nDB USER NAME : " + user + "\nPassword : " + pwd + "\n");
    return connect;
    }
    /**This method works for the Closing of Database connection 
	 * @param statement
	 * @param connection
	 * @param resultSet
	 * @throws IOException
	 */
	private static void closeDBResources(Statement statement,
			Connection connection, ResultSet resultSet) throws IOException {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException sqleException) {
				logWriter
						.write("\nUnexpected Exception in closeDBResources()/ GenerateReport:: "
								+ sqleException.toString() + "\n");
			  }
		}if (statement != null) {
			try {
				statement.close();
			} catch (SQLException sqleException) {
				logWriter
						.write("\nUnexpected Exception in closeDBResources()/GenerateReport :: "
								+ sqleException.toString() + "\n");
			  }
		 }if (statement != null) {
			try {
				statement.close();
			} catch (SQLException sqleException) {
				logWriter
						.write("\nUnexpected Exception in closeDBResources()/GenerateReport:: "
								+ sqleException.toString() + "\n");
			  }
		  }if (connection != null) {
			try {
				connection.close();
			} catch (SQLException sqleException) {
				logWriter
						.write("\nUnexpected Exception in closeDBResources()/GenerateReport :: "
								+ sqleException.toString() + "\n");
			  }
		   }
	}
}
