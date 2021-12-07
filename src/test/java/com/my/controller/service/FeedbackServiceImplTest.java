package com.my.controller.service;

import com.my.controller.service.implementation.FeedbackServiceImpl;
import com.my.entity.Account;
import com.my.entity.Feedback;
import com.my.repository.AccountRepository;
import com.my.repository.FeedbackRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import static com.my.constants.Constants.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class FeedbackServiceImplTest {

    @Mock
    private FeedbackRepository feedbackRepositoryMock;
    @Mock
    private AccountRepository accountRepositoryMock;
    @Mock
    private HttpServletRequest requestMock;
    @Mock
    private HttpServletResponse responseMock;
    @Mock
    private HttpSession sessionMock;
    @Mock
    private List<Feedback> feedbacksMock= new ArrayList<>();
    @Mock
    private Feedback feedbackMock;
    @Mock
    Account accountMock;
    @InjectMocks
    @Spy
    private FeedbackServiceImpl testInstance;

    @Test
    public void shouldInitFeedbacks() throws Exception {
        MockitoAnnotations.initMocks(this);
        feedbacksMock.add(feedbackMock);
    when(feedbackRepositoryMock.findAll()).thenReturn(feedbacksMock);
        Assertions.assertEquals(FEEDBACK_JSP,testInstance.feedbackInit(requestMock,responseMock));
    }
    @Test
    public void shouldWriteFeedback() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(requestMock.getSession()).thenReturn(sessionMock);
        when(sessionMock.getAttribute(USER_ID)).thenReturn(1);
        when(requestMock.getParameter(MESSAGE)).thenReturn("message");
        when(requestMock.getParameter(RATE)).thenReturn("1");
        when(requestMock.getParameter(MASTER)).thenReturn("master");
        when(accountRepositoryMock.getByLogin(anyString())).thenReturn(accountMock);
        when(accountMock.getId()).thenReturn(1);
        when(testInstance.getFeedback()).thenReturn(feedbackMock);
        when(feedbackRepositoryMock.existsFeedbackByUserIdAndMasterId(anyInt(),anyInt())).thenReturn(false);
        Assertions.assertEquals(SUCCESS_JSP,testInstance.feedbackWrite(requestMock,responseMock));
    }
}
