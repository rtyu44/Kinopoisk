package com.example.kino.config;


import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.io.File;



@Component
@RequiredArgsConstructor
public class Email {

    private final JavaMailSender emailSender;

    public void getEmail(String to) throws MessagingException{

        MimeMessage message = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom("noreply@foreach.com");
        helper.setTo("*");
        helper.setSubject("отчет");
        helper.setText("тест");

        FileSystemResource file
                = new FileSystemResource(new File("C:\\XML/file.xml"));
        helper.addAttachment("Tes", file);

        emailSender.send(message);
    }
}
