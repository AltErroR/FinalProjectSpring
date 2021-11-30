package com.my.controller.service.implementation;

import com.my.controller.service.MailSendService;
import com.my.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import static com.my.constants.Constants.*;
 @Service("MailSendService")
public class MailSendServiceImpl implements MailSendService {
    private static final Logger logger = LoggerFactory.getLogger(MailSendServiceImpl.class);

    @Autowired
    MailSendServiceImpl(UserRepository userRepository
//                        ,JavaMailSender javaMailSender
                        ){
    this.userRepository=userRepository;
//    this.javaMailSender=javaMailSender;
}

    //todo watch how to make spring mail service
//    JavaMailSender javaMailSender;
    List<String> mails;
    UserRepository userRepository;
    @Override
    public void sendMail(){
//
//        logger.debug("try to send mail");
//        mails= userRepository.getMails();
//        SimpleMailMessage mailMessage= new SimpleMailMessage();
//        for(String mail:mails){
//        mailMessage.setTo(mail);
//        mailMessage.setFrom(SALON_EMAIL);
//        mailMessage.setSubject(SALON_NAME);
//        mailMessage.setText(MAIL_MESSAGE);
//        javaMailSender.send(mailMessage);
//        }

        logger.debug("success");
    }

}
