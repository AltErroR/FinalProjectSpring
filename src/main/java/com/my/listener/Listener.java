package com.my.listener;



import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import static com.my.constants.Constants.*;


@WebListener
public class Listener implements ServletContextListener {
    private static final Logger logger = LoggerFactory.getLogger(Listener.class);


//    public Listener(Mailer mailer){
//    this.mailer=mailer;
//}
    Mailer mailer;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.info("try to start mailer 1 time per day");
//        mailer.start();

        //fixme loging into file
        String filePath = this.getClass().getResource("/").getPath();
        filePath = filePath.substring(1).replace(BIN, SRC);
        PropertyConfigurator.configure(filePath + LOG4J_PROPERTIES);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        mailer.interrupt();
    }
}

