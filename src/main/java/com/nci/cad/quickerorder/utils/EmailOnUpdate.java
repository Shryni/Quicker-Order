package com.nci.cad.quickerorder.utils;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class EmailOnUpdate {

//    @Autowired
//    private JavaMailSenderImpl javaMailSenderImpl;

    public void sendEmail(String toEmailAddress) {

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("pranavnci@gmail.com");
        mailSender.setPassword("Nci1000$");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

//        JavaMailSenderImpl javaMailSend=  new JavaMailSenderImpl();
//        javaMailSend.setProtocol("SMTP");
//        javaMailSend.setHost("127.0.0.1");
//        javaMailSend.setPort(25);

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(toEmailAddress);
        msg.setSubject("Delivery Address Change");
        msg.setText("Dear Requestor, This is to inform you that there is a change in delivery address");

        mailSender.send(msg);
    }

}
