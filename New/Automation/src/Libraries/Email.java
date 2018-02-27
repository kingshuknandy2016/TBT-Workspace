package Libraries;
//import org.apache.commons.io.FileUtils;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import jxl.Sheet;
import jxl.Workbook;

public class Email {
//public static void main(String[] args) 
	public static String str;
	public static String Subject;
	public static String ToEmail;
	public static void SendEmail()
	{   
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.spi.com");
		props.put("mail.smtp.socketFactory.port", "25");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "25");
 
		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					 
					return new PasswordAuthentication("vijaya.rangaiah","******");
				}
			});
		try{
		Workbook w = Workbook.getWorkbook(new File("C:/WorkSpace/Automation/Utility/Utility.xls"));
        Sheet s=w.getSheet("Setup");
        ToEmail =s.getCell(1,15).getContents();
        System.out.println("ToEmail = "+ToEmail);
        Subject=s.getCell(1,16).getContents();
        System.out.println("Inside Workbook Try block");
        w.close();
        
		}
		catch(Exception e)
		{
			
		}
		
		try{
			 
	         DataInputStream dis = 
		    new DataInputStream (
		    	 new FileInputStream ("C:/WorkSpace/Automation/Results/Summary.html"));

		 byte[] datainBytes = new byte[dis.available()];
		 dis.readFully(datainBytes);
		 System.out.println("Inside DataInputStream Try block");
	//	 dis.close();

		 str = new String(datainBytes, 0, datainBytes.length);

		 System.out.println("str = "+str);

	}catch(Exception ex){
		ex.printStackTrace();
	}

		        
		        
		        
 
		try {
 
			System.out.println("Inside Message Try block");
			
			Message message = new MimeMessage(session);
			System.out.println("message1 = "+message);
			message.setFrom(new InternetAddress("vijaya.rangaiah@spi.com"));
			System.out.println("message2 = "+message);
		//	System.out.println(Message.RecipientType.TO);
		//	String TM = InternetAddress.parse(ToEmail);
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(ToEmail));
			System.out.println("message3 = "+message);
			message.setSubject(Subject);
			System.out.println("message4 = "+message);
			message.setText("Automation Summary Report");
			System.out.println("message5 = "+message);
			message.setContent(str, "text/html");
			System.out.println("message6 = "+message);
			Transport.send(message);
 
			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

}
}
