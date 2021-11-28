package com.my.controller.service.implementation;

import com.my.controller.service.MailSendService;
import com.my.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    MailSendServiceImpl(UserRepository userRepository){
    this.userRepository=userRepository;
}

    //todo watch how to make spring mail service

    List<String> mails;
    UserRepository userRepository;
    @Override
    public void sendMail() throws IOException, MessagingException{

        logger.debug("try to send mail");
        mails= userRepository.getmMails();
        final Properties properties= new Properties();
        properties.load(MainPageServiceImpl.class.getClassLoader().getResourceAsStream(MAIL_PROPERTIES));
        Session mailSession= Session.getDefaultInstance(properties);
        MimeMessage message= new MimeMessage(mailSession);
        message.setFrom(new InternetAddress(SALON_EMAIL));
        for(String mail:mails){
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(mail));
        }
        message.setSubject(SALON_NAME);
        message.setText(MAIL_MESSAGE);

        Transport tr = mailSession.getTransport();
        tr.connect(null,MAIL_PASSWORD);
        tr.sendMessage(message, message.getAllRecipients());
        tr.close();
        logger.debug("success");
    }

}
