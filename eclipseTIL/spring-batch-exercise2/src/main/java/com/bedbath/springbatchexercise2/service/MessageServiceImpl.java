package com.bedbath.springbatchexercise2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendEmail() {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("abhishek.kesharwani@idc.bedbath.com");
        msg.setSubject("Test Subject from Exercise 2");
        msg.setText("Spring Boot Notification Mail :: Unable to Connect Kafka");
        javaMailSender.send(msg);
    }


}
