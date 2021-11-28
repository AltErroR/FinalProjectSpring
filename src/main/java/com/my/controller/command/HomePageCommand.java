package com.my.controller.command;

import com.my.controller.service.implementation.HomePageServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.my.constants.Constants.ROLE;
@Component
public class HomePageCommand implements Command{
    private static final Logger logger = LoggerFactory.getLogger(HomePageCommand.class);
    @Autowired
           public HomePageCommand(HomePageServiceImpl homePageService){
        this.homePageService=homePageService;
    }
    HomePageServiceImpl homePageService;
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("try to redirect to homepage");
        String role=request.getSession().getAttribute(ROLE).toString();
        return homePageService.getHome(role);
    }
}
