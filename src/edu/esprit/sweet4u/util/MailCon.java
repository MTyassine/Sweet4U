
package edu.esprit.sweet4u.util;

import edu.esprit.sweet4u.entites.Reclamation;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailCon {
    
    Reclamation r;
    
    public MailCon (Reclamation r){
    
        this.r=r;
       
       final String username = "sweet4u.b3@gmail.com";//r.getEmeteur().getMail();  //"username@gmail.com";
		final String password = "test1231/2";//r.getPwd();

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
                //Personne p = PersonneConenction.getInstance();
		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(r.getEmeteur().getLogin()));//.getMail())); //"from-email@gmail.com"
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("sweet4u.b3@gmail.com"));//getMail()));  //"to-email@gmail.com"
			message.setSubject(r.getSujet());
			message.setText("mail de : "+r.getEmeteur().getLogin()+ "  message : "+ r.getContenu());

			Transport.send(message);

			System.out.println("Message Envoyer !!!");

		} catch (MessagingException e) {
			//throw new RuntimeException(e);
                        Logger.getLogger(edu.esprit.sweet4u.util.MailCon.class.getName()).log(Level.SEVERE, null, e);
		}
        
    }
    
}
