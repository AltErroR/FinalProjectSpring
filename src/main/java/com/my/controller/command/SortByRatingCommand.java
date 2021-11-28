package com.my.controller.command;

import com.my.controller.service.implementation.MainPageServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.my.constants.SQLConstants.SQL_SUBLIST_BY_RATING;
@Component
public class SortByRatingCommand implements Command {
    private static final Logger logger = LoggerFactory.getLogger(SortByRatingCommand.class);
    @Autowired
    public SortByRatingCommand(MainPageServiceImpl mainPageServiceImplementation){
        this.mainPageServiceImplementation=mainPageServiceImplementation;
    }
    MainPageServiceImpl mainPageServiceImplementation;
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("try to sort data on main by rating");
        return mainPageServiceImplementation.mainPageInitialization(SQL_SUBLIST_BY_RATING,response,request);

    }
}