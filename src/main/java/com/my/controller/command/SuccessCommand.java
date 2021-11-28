package com.my.controller.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class SuccessCommand implements Command {
    private static final Logger logger = LoggerFactory.getLogger(SuccessCommand.class);
    public SuccessCommand(HomePageCommand homePageCommand){
        this.homePageCommand=homePageCommand;
    }
    HomePageCommand homePageCommand;
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("redirect to homePageCommand");
        return homePageCommand.execute(request,response);
    }
}
