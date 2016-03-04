package otp;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.PasswordAuthentication;

public class OTPClient {

	public static void main(String[] args) {
		sendMail();
		testTOTP();
		//testHOTP();
	}
	
	public static void testTOTP() {
		String key = "manibhushan_otp_key";

		for (int i = 0; i < 10; i++) {
			System.out.println(OTP.generate("" + key + i, "" + System.currentTimeMillis(), 4, "hotp"));
		}
		
		//http://www.smszone.in/sendsms.asp?page=SendSmsBulk&username=919739099370&password=E4BE&number=919739099370&message=manibhushan
	}

	public static void testHOTP() {
		String secret = "its really a secret otp! ssshhhh!!";

		try {
			for (int i = 0; i < 10; i++) {
				System.out.println(OTP.generate(secret, "" + 2, 6, "hotp"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void sendMail() {
		final String username = "bbawet@gmail.com";
		final String password = "fun_here";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("from-email@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("to-email@gmail.com"));
			message.setSubject("Testing Subject");
			message.setText("Dear Mail Crawler,"
				+ "\n\n No spam to my email, please!");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void sendMail1() {
		 // Recipient's email ID needs to be mentioned.
	      String to = "manibhushan.cs@gmail.com";

	      // Sender's email ID needs to be mentioned
	      String from = "manibhushan.cs@gmail.com";

	      // Assuming you are sending email from localhost
	      String host = "localhost";

	      // Get system properties
	      Properties properties = System.getProperties();

	      // Setup mail server
	      properties.setProperty("mail.smtp.host", host);

	      // Get the default Session object.
	      Session session = Session.getDefaultInstance(properties);

	      try{
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

	         // Set Subject: header field
	         message.setSubject("This is the Subject Line!");

	         // Now set the actual message
	         message.setText("This is actual message");

	         // Send message
	         Transport.send(message);
	         System.out.println("Sent message successfully....");
	      }catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	}
}
