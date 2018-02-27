/**********************************************************************************
*                                                                                 
* @author $Author: SPI(Barsha Mohanty)                                       
* @version $Revision: $, $Date: $
***********************************************************************************
* Package          :  default
* Class Type       :  Class
***********************************************************************************
*
* This is the Query class for APX ReportGeneration application.
* It is acting as a class for executing the sql query used with required fetched pop ids..
***********************************************************************************
* Revision History
* 
-----------------------------------------------------------------------------------
* Created Date                :               13th November 2015
* Last Modified Date          :               13th November 2015
-----------------------------------------------------------------------------------
* Modification History
* 1. Initial execution of query process.
***********************************************************************************
*/
package com.belk.sql;

import com.belk.file.ReadFile;

public class Query {
	/**This method execute the query with fetched po ids for the report
	 * @param file
	 * @return
	 */
	public static String getReportQuery(ReadFile file){
	    String poIds =file.getProperty("poIds");
	    String db2schema=file.getProperty("DB2SCHEMA");
	    //poIds = Fetchpo_id.GetPO_id();
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append(" SELECT DISTINCT AP.DEPT_NBR, AP.PLAN_NAME, SPD.VENDOR_STYLE_TXT, ");
		queryBuilder.append(" SPD.COLOR_DESCR,SPD.STORE_IMPORT_ID STORE_IMPORT_ID,SPD.ECOM_IMPORT_ID ECOM_IMPORT_ID, SEL.ERR_MSG ");
		queryBuilder.append(" FROM ");
		queryBuilder.append(db2schema);
	    queryBuilder.append(" SPO_PLAN_DETAIL AS SPD JOIN ");
	    queryBuilder.append(db2schema);
	    queryBuilder.append(" SPO_ERR_LOG AS SEL ON SPD.SPO_ITEM_ID = SEL.SPO_ITEM_ID AND SPD.PLAN_ID = SEL.PLAN_ID JOIN ");
	    queryBuilder.append(db2schema);
	    queryBuilder.append(" ASSORTMENT_PLAN AS AP ON SPD.PLAN_ID = AP.PLAN_ID ");
		queryBuilder.append(" WHERE SPD.PRIVATE_BRAND = 'Belk International' AND SPD.PO_STATUS_CD = 4 ");
		queryBuilder.append(" AND SPD.STORE_POP_ID IN ( ");
		queryBuilder.append(poIds);
		queryBuilder.append(" ) UNION ");
		queryBuilder.append(" SELECT DISTINCT AP.DEPT_NBR, AP.PLAN_NAME, SPD.VENDOR_STYLE_TXT, ");
		queryBuilder.append(" SPD.COLOR_DESCR,SPD.STORE_IMPORT_ID STORE_IMPORT_ID,SPD.ECOM_IMPORT_ID ECOM_IMPORT_ID, SEL.ERR_MSG ");
		queryBuilder.append(" FROM ");
		queryBuilder.append(db2schema);
	    queryBuilder.append(" SPO_PLAN_DETAIL AS SPD JOIN ");
	    queryBuilder.append(db2schema);
	    queryBuilder.append(" SPO_ERR_LOG AS SEL ON SPD.SPO_ITEM_ID = SEL.SPO_ITEM_ID AND SPD.PLAN_ID = SEL.PLAN_ID JOIN ");
	    queryBuilder.append(db2schema); 
	    queryBuilder.append(" ASSORTMENT_PLAN AS AP ON SPD.PLAN_ID = AP.PLAN_ID ");
		queryBuilder.append(" WHERE SPD.PRIVATE_BRAND = 'Belk International' AND SPD.ECOM_PO_STATUS_CD = 4 ");
		queryBuilder.append(" AND SPD.ECOM_POP_ID IN ( ");
		queryBuilder.append(poIds);
		queryBuilder.append(" ) UNION ");
		queryBuilder.append(" SELECT DISTINCT AP.DEPT_NBR, AP.PLAN_NAME, SPD.VENDOR_STYLE_TXT, ");
	    queryBuilder.append(" SPD.COLOR_DESCR,SPD.STORE_IMPORT_ID STORE_IMPORT_ID,SPD.ECOM_IMPORT_ID ECOM_IMPORT_ID, SEL.ERR_MSG ");
	    queryBuilder.append(" FROM ");
	    queryBuilder.append(db2schema);
	    queryBuilder.append(" SPO_PLAN_DETAIL_CLSVEN AS SPD JOIN ");
	    queryBuilder.append(db2schema);
	    queryBuilder.append(" SPO_ERR_LOG AS SEL ON SPD.SPO_ITEM_ID = SEL.SPO_ITEM_ID AND SPD.PLAN_ID = SEL.PLAN_ID JOIN ");
	    queryBuilder.append(db2schema);
	    queryBuilder.append(" ASSORTMENT_PLAN AS AP ON SPD.PLAN_ID = AP.PLAN_ID ");
	    queryBuilder.append(" WHERE SPD.PRIVATE_BRAND = 'Belk International' AND SPD.PO_STATUS_CD = 4 ");
	    queryBuilder.append(" AND SPD.STORE_POP_ID IN ( ");
	    queryBuilder.append(poIds);
	    queryBuilder.append(" ) UNION ");
	    queryBuilder.append(" SELECT DISTINCT AP.DEPT_NBR, AP.PLAN_NAME, SPD.VENDOR_STYLE_TXT, ");
	    queryBuilder.append(" SPD.COLOR_DESCR,SPD.STORE_IMPORT_ID STORE_IMPORT_ID,SPD.ECOM_IMPORT_ID ECOM_IMPORT_ID, SEL.ERR_MSG ");
	    queryBuilder.append(" FROM ");
	    queryBuilder.append(db2schema);
	    queryBuilder.append(" SPO_PLAN_DETAIL_CLSVEN AS SPD JOIN ");
	    queryBuilder.append(db2schema);
	    queryBuilder.append(" SPO_ERR_LOG AS SEL ON SPD.SPO_ITEM_ID = SEL.SPO_ITEM_ID AND SPD.PLAN_ID = SEL.PLAN_ID JOIN ");
	    queryBuilder.append(db2schema);
	    queryBuilder.append(" ASSORTMENT_PLAN AS AP ON SPD.PLAN_ID = AP.PLAN_ID ");
	    queryBuilder.append(" WHERE SPD.PRIVATE_BRAND = 'Belk International' AND SPD.ECOM_PO_STATUS_CD = 4 ");
	    queryBuilder.append(" AND SPD.ECOM_POP_ID IN (");
	    queryBuilder.append(poIds);
	    queryBuilder.append(")");
	    System.out.println("Inside query---->"+queryBuilder.toString());
		return queryBuilder.toString();
	}
}
