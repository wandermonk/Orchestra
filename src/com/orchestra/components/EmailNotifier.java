package com.orchestra.components;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailNotifier {
	
	private String _host;
	
	public EmailNotifier(String host){
		this._host = host;
	}

	public void PostMail(String mailFrom , String mailTo , String subject, String body) {

		try {
			Properties properties = System.getProperties();
			properties.setProperty("mail.smtp.host", _host);
			Session session = Session.getDefaultInstance(properties);
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(mailFrom));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(mailTo));
			message.setSubject(subject);
			message.setContent(body, "text/html");
			Transport.send(message);
		} catch (Exception e) {
		}
	}
}
