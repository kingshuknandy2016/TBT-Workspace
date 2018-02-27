package com.spi.basics;


import java.io.File;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.activation.DataHandler;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.mail.BodyPart;
import javax.mail.Multipart;

public class GoogleMail {
	
	public void sendSpimail(final String username,final String password,String toAddress,String ccAddress,String subject,String body,String filename){
		
        StringTokenizer st = new StringTokenizer(username,"@");
		int i=0;
		String domain = null;
		while (st.hasMoreTokens()) {
			if(i==0){
			i++;
			}else{
				domain=(String) st.nextElement();
			}	
		}
		
		Properties props = new Properties();
	       props.put("mail.smtp.auth", "true");
	       props.put("mail.smtp.starttls.enable", "true");
	       if(domain.equalsIgnoreCase("spi.com")){
	    	   props.put("mail.smtp.host", "spimail.spi.com");
		       props.put("mail.smtp.port", "25");  
	       }else{
	    	   props.put("mail.smtp.host", "smtp.gmail.com");
	           props.put("mail.smtp.port", "587");
	       }
	       

	       Session session = Session.getInstance(props, new javax.mail.Authenticator() {
	    	   				protected PasswordAuthentication getPasswordAuthentication() {
	    	   						return new PasswordAuthentication(username, password);
	           }
	       });

	       try {

	           Message message = new MimeMessage(session);

	           message.setFrom(new InternetAddress(username));
	           if (toAddress != null && !toAddress.trim().isEmpty())

	           message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress));
	           message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(ccAddress));


	           if (subject != null && !subject.trim().isEmpty()) message.setSubject(subject);


	           // Create the message part
	           BodyPart messageBodyPart = new MimeBodyPart();

	           // Now set the actual message
	           messageBodyPart.setText(body);

	           // Create a multi part message
	           Multipart multipart = new MimeMultipart();

	           // Set text message part
	           multipart.addBodyPart(messageBodyPart);


	           //if the file path is empty , Don't attache the file
	           if (filename != null && !filename.trim().isEmpty()) {

	               // Part two is attachment
	               messageBodyPart = new MimeBodyPart();

	               DataSource source = new FileDataSource(filename);
	               messageBodyPart.setDataHandler(new DataHandler(source));
	               messageBodyPart.setFileName(new File(filename).getName());
	               multipart.addBodyPart(messageBodyPart);

	           }

	           // Send the complete message parts
	           message.setContent(multipart);

	           //send message
	           Transport.send(message);

	           System.out.println("Mail sent ..!");

	       } catch (MessagingException e) {
	           System.out.println("Mail not sent ...!");
	           throw new RuntimeException(e);
	       }
	}

	
	public static void main(String[] args) {
		 GoogleMail go=new GoogleMail();
		 go.sendSpimail("kingshuk.nandy@spi.com", "$picity123456", "suvodip.ghosh@spi.com", "", "Test Mail to", "Please Check it", "");
	}
}
