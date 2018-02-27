/**********************************************************************************
*                                                                                 
* @author $Author: SPI(Barsha Mohanty)                                        
* @version $Revision: $, $Date: $
***********************************************************************************
* Package          : default 
* Class Type       :  Class
***********************************************************************************
*
* This is the Email class for APX ReportGeneration application.
* It is acting as a EmailSending class for Automatic ReportSending with excel attachment functionality.
***********************************************************************************
* Revision History
* 
-----------------------------------------------------------------------------------
* Created Date                :               13th November 2015
* Last Modified Date          :               13th November 2015
-----------------------------------------------------------------------------------
* Modification History
* 1. Initial creation of ReportGenerate Email process .
***********************************************************************************
*/
package com.belk.email;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.belk.file.ReadFile;

public class Email {
	/**This method sends the report email with the attached excelsheet 
	 * @param file
	 */
	public static void sendEmail(ReadFile file){
			String to=file.getProperty("mail.to");
			String from =file.getProperty("mail.from");
			String host =file.getProperty("mail.host");
			String subject=file.getProperty("mail.successSubject");
			Properties properties = new Properties();
			properties.put("mail.smtp.host", host);
			properties.put("mail.smtp.starttls.enable", "true");
			//Getting the session object
			Session session = Session.getInstance(properties);
			try {
				Message msg = new MimeMessage(session);
				msg.setFrom(new InternetAddress(from));
				msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
				msg.setSubject(subject);
				msg.setSentDate(new Date());
				BodyPart messageBodyPart = new MimeBodyPart();
				messageBodyPart.setText(file.getProperty("mailmsg.body"));
				Multipart multipart = new MimeMultipart();
				multipart.addBodyPart(messageBodyPart);	
				//Email with attachment
				messageBodyPart = new MimeBodyPart(); 
				String filename = file.getProperty("excel.file");
				DataSource source = new FileDataSource(filename);
				messageBodyPart.setDataHandler(new DataHandler(source));
				messageBodyPart.setFileName(filename);
				multipart.addBodyPart(messageBodyPart);
				//Send the complete message parts
				msg.setContent(multipart);
				//Sending the message
				Transport.send(msg);
				System.out.println("Sent message successfully....");
			    } 
			catch (MessagingException e) 
			    {
				throw new RuntimeException(e);
			    }
	}
}
