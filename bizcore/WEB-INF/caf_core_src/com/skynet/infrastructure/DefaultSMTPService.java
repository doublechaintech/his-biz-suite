package com.skynet.infrastructure;
///////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                               // 
//                                     CHECK hostname -i on your system, if not getting a result //
//                                     try to add entry to /etc/host like 127.0.0.1 <yourhost>   // 
//																								 //	
///////////////////////////////////////////////////////////////////////////////////////////////////




import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.terapico.caf.BlobObject;

public class DefaultSMTPService extends InfraBaseService implements SMTPService {

	public DefaultSMTPService() {
		// TODO Auto-generated constructor stub
	}
	private class SMTPAuthenticator extends javax.mail.Authenticator {
        public PasswordAuthentication getPasswordAuthentication() {
           String username = getUsername();
           String password = getPassword();
           
           System.out.print("really called here!");
           return new PasswordAuthentication(username, password);
        }
        protected String getPassword(){
        	return System.getenv("SMTP_PASSWORD");
        }
        protected String getUsername(){
        	return System.getenv("SMTP_USERNAME");
        }
    }
	
	public void send(String to, String subject, String content) throws Exception{
		try {
			sendEmail( to,  subject,  content);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue when sending message: "+ e);
		}
	}
	protected boolean sendEmail(String to, String subject, String content) throws URISyntaxException, Exception {

		Properties mailProps = new Properties();
        mailProps.put("mail.smtp.from", "report@bettbio.com");
        mailProps.put("mail.smtp.host", "smtp.bettbio.com");
        mailProps.put("mail.smtp.port", 25);
        mailProps.put("mail.smtp.auth", "true");
        //mailProps.put("mail.smtp.socketFactory.port", port);
        //mailProps.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        //mailProps.put("mail.smtp.socketFactory.fallback", "false");
        //mailProps.put("mail.smtp.starttls.enable", "true");
        SMTPAuthenticator auth = new SMTPAuthenticator();
		Session session = Session.getInstance(mailProps,  auth);
		session.setDebug(true);
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("report@bettbio.com"));
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
		//String content = value + "! product price has been changed ";
		msg.setSubject(subject);
		msg.setText(content);

		// Send the message
		Transport.send(msg);
		return true;

	}
	@Override
	public void sendHtml(String to, String subject, String content) {
		try {
			sendHtmlEmail( to,  subject,  content);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue when sending message: "+ e);
		}
	}
	protected boolean sendHtmlEmail(String to, String subject, String content) throws Exception {
		Properties mailProps = new Properties();
        mailProps.put("mail.smtp.from", "report@bettbio.com");
        mailProps.put("mail.smtp.host", "smtp.bettbio.com");
        mailProps.put("mail.smtp.port", 25);
        mailProps.put("mail.smtp.auth", "true");
        //mailProps.put("mail.smtp.socketFactory.port", port);
        //mailProps.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        //mailProps.put("mail.smtp.socketFactory.fallback", "false");
        //mailProps.put("mail.smtp.starttls.enable", "true");
        SMTPAuthenticator auth = new SMTPAuthenticator();
		Session session = Session.getInstance(mailProps,  auth);
		session.setDebug(true);
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("report@bettbio.com"));
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
		//String content = value + "! product price has been changed ";
		msg.setSubject(subject);
		msg.setContent(content,"text/html;charset=utf-8");

		// Send the message
		Transport.send(msg);
		return true;
	}
	@Override
	public void sendWithAttachment(String to, String subject, String content, List<BlobObject> attachments) throws Exception{
		
		
	}
}
