/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

/**
 *
 * @author black
 */

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

public class SMTP {

    private String host;
    private String port;

    private String email;
    private String password;

    private Session session;

    public SMTP() {
    }

    public SMTP(String host, String port, String email, String password) {
        this.host = host;
        this.port = port;
        this.email = email;
        this.password = password;
    }

    public boolean connect() {
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        };

        session = Session.getInstance(props, auth);

        return session != null;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getEmail() {
        return email;
    }

    public String getHost() {
        return host;
    }

    public String getPassword() {
        return password;
    }

    public String getPort() {
        return port;
    }

    public Session getSession() {
        return session;
    }

    public void sendMimeMessage(String sender, String recepent, String subject, String text) throws AddressException, MessagingException, UnsupportedEncodingException {
        MimeMessage ms = new MimeMessage(session);

        ms.setFrom(new InternetAddress(email, sender));
        ms.setReplyTo(InternetAddress.parse(email, false));
        ms.setSubject(subject, "UTF-8");
        ms.setText(text, "UTF-8");
        ms.setSentDate(new Date());
        ms.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recepent, false));
        Transport.send(ms);
    }

    public void sendMimeMessageWithThread(final String sender,final String recepent,final String subject,final String text) {
        Thread thread = new Thread() {
            @Override
            public void run() {
            try {
                sendMimeMessage(sender, recepent, subject, text);
            } catch (UnsupportedEncodingException | MessagingException e) {
            }
            }
        };

        thread.start();
    }
}

