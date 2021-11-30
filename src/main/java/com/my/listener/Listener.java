package com.my.listener;



import com.my.controller.service.implementation.MailSendServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;



@Component
public class Listener implements ApplicationListener<ApplicationReadyEvent> {
    private static final Logger logger = LoggerFactory.getLogger(Listener.class);
@Autowired
public Listener(MailSendServiceImpl mailSendService){
    this.mailSendService=mailSendService;
}
    MailSendServiceImpl mailSendService;
//    Mailer mailer;
    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        //fixme sanding mail and not starting servlet
        // mailSendService.sendMail();
        return;
    }
}
//        //fixme loging into file
//        String filePath = this.getClass().getResource("/").getPath();
//        filePath = filePath.substring(1).replace(BIN, SRC);
//        PropertyConfigurator.configure(filePath + LOG4J_PROPERTIES);


