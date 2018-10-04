package com.example.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by Bauka on 04-Oct-18
 */
@Service
public class MailSenderService
{
    private Properties mailServerProperties;
    private Session mailSession;
    private MimeMessage mailMessage;

    public void generateAndSendEmail(String emailAddress,String emailBody) throws AddressException, MessagingException {
        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");
        mailSession = Session.getDefaultInstance(mailServerProperties, null);
        mailMessage = new MimeMessage(mailSession);
        mailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailAddress));
        mailMessage.setSubject("Ticocar user confirmation");
        mailMessage.setContent(emailBody, "text/html");
        Transport transport = mailSession.getTransport("smtp");
        transport.connect("smtp.gmail.com", "ticocar.senior@gmail.com", "senior.ticocar123");
        transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
        transport.close();
    }
}