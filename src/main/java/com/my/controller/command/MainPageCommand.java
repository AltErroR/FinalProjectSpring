package com.my.controller.command;

import com.my.controller.service.implementation.MainPageServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.my.constants.Constants.ID;
import static com.my.constants.Constants.SORT_BY;
@Component
public class MainPageCommand implements Command{
    private static final Logger logger = LoggerFactory.getLogger(MainPageCommand.class);
    MainPageServiceImpl mainPageServiceImplementation;
    @Autowired
    public MainPageCommand(MainPageServiceImpl mainPageService){
        mainPageServiceImplementation= mainPageService;
    }
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("try to show data on main list");
        request.setAttribute(SORT_BY, ID);
        return mainPageServiceImplementation.mainPageInitialization(response,request);
    }
}
