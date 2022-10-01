package com.webkorps.util;

import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailUtil {

 public static void sendMail(String email,String messageforuser)
  {
	final String username = "chetanrjaiswal77@gmail.com";
	final String password1 = "mbibwvnourxzvadl";
	Properties props = new Properties();
	props.put("mail.smtp.auth",true);
	props.put("mail.smtp.starttls.enable",true);
	props.put("mail.smtp.host","smtp.gmail.com");
	props.put("mail.smtp.port","587");
	Session session = Session.getInstance
			(props,new javax.mail.Authenticator() {
	          @Override
	          protected PasswordAuthentication getPasswordAuthentication() {
	          return new PasswordAuthentication(username, password1);
	          }
	        });

	try 
	{
	Message message = new MimeMessage(session);
	message.setFrom(new InternetAddress(username));
	message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(email));
	MimeBodyPart textPart = new MimeBodyPart();
	Multipart multipart = new MimeMultipart();
	String final_Text = messageforuser;
	textPart.setText(final_Text);
	message.setSubject("otp sent");
	multipart.addBodyPart(textPart);
	message.setContent(multipart);
	message.setSubject("Email Verification");
	System.out.println("Sending");
	Transport.send(message);
	System.out.println("mail sendsuccessfuly");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
   }
}
