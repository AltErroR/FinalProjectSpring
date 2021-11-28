package com.my.controller.command;

import com.my.controller.service.implementation.FeedbackServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class FeedbackCommand implements Command{
    private static final Logger logger = LoggerFactory.getLogger(FeedbackCommand.class);
    FeedbackServiceImpl feedbackServiceImplementation;
    @Autowired
    public FeedbackCommand(FeedbackServiceImpl feedbackService){
        feedbackServiceImplementation=feedbackService;
    }
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("try to get all feedbacks");
        return feedbackServiceImplementation.feedbackInit(request,response);
    }
}
