package com.logistics.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class MailFunctions {

    private JavaMailSender javaMailSender;

    @Autowired
    public MailFunctions(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }


    public ResponseEntity<Object> sendEmail(String privateCode, String senderEmail, String receiverEmail) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper messageBuilder = new MimeMessageHelper(message, true);
        messageBuilder.setFrom("needylogisticcomapny@gmail.com");
        messageBuilder.setTo(senderEmail);
        messageBuilder.setSubject(MailTemplates.senderSubject_mail);
        messageBuilder.setText(MailTemplates.buildSenderMail(senderEmail,privateCode), true);
        javaMailSender.send(message);

        return ResponseEntity.ok(null);
    }

    public ResponseEntity<Object> sendEmailReceiver(String receiverEmail, String firstName, String code, String city, String address, boolean isOffice, String date) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper messageBuilder = new MimeMessageHelper(message, true);
        messageBuilder.setFrom("needylogisticcomapny@gmail.com");
        messageBuilder.setTo(receiverEmail);
        messageBuilder.setSubject(MailTemplates.receiverSubject_mail);
        messageBuilder.setText(MailTemplates.buildReceiverMail(firstName,  code,  city,  address,  isOffice,  date), true);
        javaMailSender.send(message);

        return ResponseEntity.ok(null);
    }

    public ResponseEntity<Object> sendRejectedEmail(String senderEmail, String firstName, String code, boolean isOffice, String address, String city) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper messageBuilder = new MimeMessageHelper(message, true);
        messageBuilder.setFrom("needylogisticcomapny@gmail.com");
        messageBuilder.setTo(senderEmail);
        messageBuilder.setSubject(MailTemplates.senderSubject_rejectedMail);
        messageBuilder.setText(MailTemplates.buildRejectedMail(firstName, code, address, city, isOffice), true);
        javaMailSender.send(message);

        return ResponseEntity.ok(null);
    }

    public ResponseEntity<Object> sendDeliveredEmail(String senderEmail, String firstName, String code) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper messageBuilder = new MimeMessageHelper(message, true);
        messageBuilder.setFrom("needylogisticcomapny@gmail.com");
        messageBuilder.setTo(senderEmail);
        messageBuilder.setSubject(MailTemplates.senderSubject_deliveredMail);
        messageBuilder.setText(MailTemplates.buildDeliveredMail(firstName, code), true);
        javaMailSender.send(message);

        return ResponseEntity.ok(null);
    }
}

