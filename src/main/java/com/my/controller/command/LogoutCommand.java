package com.my.controller.command;

import com.my.controller.service.implementation.LogoutServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class LogoutCommand implements Command {
    private static final Logger logger = LoggerFactory.getLogger(LogoutCommand.class);
    @Autowired
            public LogoutCommand(LogoutServiceImpl logoutService){
        this.logoutService=logoutService;
    }
LogoutServiceImpl logoutService;
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("try to log out");
    return logoutService.exit(request,response);
    }
}
