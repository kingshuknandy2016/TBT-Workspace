/**************************************************************************************.
*
* @author $Author: SPI(Barsha Mohanty)
* @version $Revision: $, $Date: $
************************************************************************************
* Package          :  com.belk.apx.dtos.ActualizationDTO
* Class Type       :  class
************************************************************************************
*
* This is the ReportDTO class for APX ReportGeneration application.
* It is acting as a DTO for Reportgeneration functionality in excelsheet format.
************************************************************************************
* Revision History
* 
---------------------------------------------------------------------------------
* Created Date                :              13th November 2014
* Last Modified Date          :              13th November 2014
---------------------------------------------------------------------------------
* Modification History
* 1. Initial creation of ReportDTO  class .
************************************************************************************
*/
package com.belk.dtos;

import java.io.Serializable;

public class ReportDTO implements Serializable {
private static final long serialVersionUID = 1L;
	private int deptNbr;
	private String planName;
	private String vendorStyleTxt;
	private String colorDescr;
	private int storeImportId;
	private int ecomImportId;
	private String errMsg;
	public int getDeptNbr() {
		return deptNbr;
	}
	public void setDeptNbr(int deptNbr) {
		this.deptNbr = deptNbr;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getVendorStyleTxt() {
		return vendorStyleTxt;
	}
	public void setVendorStyleTxt(String vendorStyleTxt) {
		this.vendorStyleTxt = vendorStyleTxt;
	}
	public String getColorDescr() {
		return colorDescr;
	}
	public void setColorDescr(String colorDescr) {
		this.colorDescr = colorDescr;
	}
	public int getStoreImportId() {
		return storeImportId;
	}
	public void setStoreImportId(int storeImportId) {
		this.storeImportId = storeImportId;
	}
	public int getEcomImportId() {
		return ecomImportId;
	}
	public void setEcomImportId(int ecomImportId) {
		this.ecomImportId = ecomImportId;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	
	
}
