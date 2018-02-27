package com.spi.basics;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer("kingshuk.nandy@spi.com","@");
		
		int i=0;
		String domain = null;
		while (st.hasMoreTokens()) {
			if(i==0){
			i++;
			}else{
				domain=(String) st.nextElement();
			}	
		}
}

}
