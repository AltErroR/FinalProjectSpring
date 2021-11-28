package com.my.controller.command;

import com.my.controller.service.implementation.FeedbackServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class FeedbackWriteCommand implements  Command{
    private static final Logger logger = LoggerFactory.getLogger(FeedbackWriteCommand.class);
    FeedbackServiceImpl feedbackServiceImplementation;
    @Autowired
    public FeedbackWriteCommand(FeedbackServiceImpl feedbackService){
        feedbackServiceImplementation=feedbackService;
    }
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("try to write feedback");
        return feedbackServiceImplementation.feedbackWrite(request,response);
    }
}
