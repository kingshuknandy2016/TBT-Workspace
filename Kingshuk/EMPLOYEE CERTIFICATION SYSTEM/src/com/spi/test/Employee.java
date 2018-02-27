package com.spi.test;

import java.sql.Date;

public class Employee {
	private int empId, skillId, cityId, cellNo1, cellNo2, pinCode;
	private String name, address, emailId;
	private Date dateOfJoining;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getSkillId() {
		return skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public int getCellNo1() {
		return cellNo1;
	}
	public void setCellNo1(int cellNo1) {
		this.cellNo1 = cellNo1;
	}
	public int getCellNo2() {
		return cellNo2;
	}
	public void setCellNo2(int cellNo2) {
		this.cellNo2 = cellNo2;
	}
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	} 
}

