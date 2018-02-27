package com.spi.date;

import java.util.Date;

public class Implementor {

	String username;
	String password;

	Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String toString() {
		return "Implementor [username=" + username + ", password=" + password
				+ ", date=" + date + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}