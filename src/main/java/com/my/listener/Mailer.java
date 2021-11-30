package com.my.listener;

import com.my.controller.service.implementation.MailSendServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Mailer extends Thread {
    private static final Logger logger = LoggerFactory.getLogger(Mailer.class);
        @Autowired
        public Mailer(MailSendServiceImpl mailSendService){
         this.mailSendService=mailSendService;
    }
    MailSendServiceImpl mailSendService ;

    @PostConstruct
    @Override
    public void run() {
        try {
            mailSendService.sendMail();
            Thread.sleep(86400000);
        } catch (Exception e) {
            logger.error("mailer error occured");
        }
    }
}
