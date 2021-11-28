package com.my.controller.command;

import com.my.controller.service.implementation.LoginServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class LoginCommand implements Command{
    private static final Logger logger = LoggerFactory.getLogger(LoginCommand.class);
    LoginServiceImpl loginServiceImplementation;

    @Autowired
            public LoginCommand(LoginServiceImpl loginServiceImplementation){
        this.loginServiceImplementation=loginServiceImplementation;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("try to login");
        return loginServiceImplementation.login(request,response);
    }
}
