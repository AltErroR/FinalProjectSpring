package com.my.controller.service.implementation;

import com.my.controller.service.FeedbackService;
import com.my.entity.Feedback;
import com.my.repository.FeedbackRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import static com.my.constants.Constants.*;

@Service("FeedbackService")
public class FeedbackServiceImpl implements FeedbackService, ApplicationContextAware {
    FeedbackRepository feedbackRepository;
    Feedback feedback;
    private ApplicationContext applicationContext;

    @Autowired
    public FeedbackServiceImpl(FeedbackRepository feedbackRepository){
        this.feedbackRepository=feedbackRepository;
    }
    @Lookup
    public Feedback getFeedback() {
        return null;
    }
    private static final Logger logger = LoggerFactory.getLogger(FeedbackServiceImpl.class);
    List<Feedback> feedbacks= new ArrayList<>();
    @Override
    public String feedbackInit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        feedbacks= feedbackRepository.findAll();
        if(feedbacks.isEmpty()){
            logger.warn("feedbacks list is clear");
            throw  new Exception("No feedbacks yet");
        }
        request.setAttribute(FEEDBACK_LIST,feedbacks);
        logger.debug("success");
        return FEEDBACK_JSP;
    }
    @Override
    public String feedbackWrite(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int userId =(int) request.getSession().getAttribute(USER_ID);
        String message=request.getParameter(MESSAGE);
        String rate=request.getParameter(RATE);
        String masterLogin=request.getParameter(MASTER);
        if(feedbackRepository.existsFeedbackByUserIdAndMasterLogin(userId,  masterLogin)){
            logger.warn("feedbacks insertion to bd failed");
            throw new Exception("You already left your feedback, to this master, thanx");
        }
        feedback=getFeedback();
        feedback.setMasterLogin(masterLogin);
        feedback.setFeedbackMessage(message);
        feedback.setUserId(userId);
        feedback.setUserRate(rate);
        feedbackRepository.save(feedback);
        logger.debug("success");
        return SUCCESS_JSP;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        this.applicationContext = applicationContext;
    }
}
