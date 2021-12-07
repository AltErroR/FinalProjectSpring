package com.my;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class BeautySalon extends SpringBootServletInitializer {

    static Logger bSLogger = LoggerFactory.getLogger(BeautySalon.class);

    public static void main(String[] args) {
        bSLogger.info("*** APP STARTED ***");
        SpringApplication.run(BeautySalon.class, args);
    }
}