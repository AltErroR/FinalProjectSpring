package com.my.controller.command;

import com.my.controller.service.implementation.MainPageServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.my.constants.Constants.*;
import static com.my.constants.SQLConstants.SQL_SUBLIST_BY_MASTER_NAME;
@Component
public class SortByMasterLoginCommand implements Command {
    private static final Logger logger = LoggerFactory.getLogger(SortByMasterLoginCommand.class);
    @Autowired
    public SortByMasterLoginCommand(MainPageServiceImpl mainPageServiceImplementation){
        this.mainPageServiceImplementation=mainPageServiceImplementation;
    }
    MainPageServiceImpl mainPageServiceImplementation;
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("try to sort data on main by master login");
        request.setAttribute(SORT_BY, MASTER_NAME);
        return mainPageServiceImplementation.mainPageInitialization(response,request);
    }
}
