package com.my.controller.service;

import com.my.controller.service.implementation.AccountCreationServiceImpl;
import com.my.entity.Account;
import com.my.entity.Master;
import com.my.entity.User;
import com.my.repository.AccountRepository;
import com.my.repository.MasterRepository;
import com.my.repository.UserRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.my.constants.Constants.*;
import static org.mockito.Mockito.*;

public class AccountCreationServiceImplTest {

    @Mock
    private HttpSession sessionMock;
    @Mock
    private AccountRepository accountRepositoryMock;
    @Mock
    private UserRepository userRepositoryMock;
    @Mock
    private MasterRepository masterRepositoryMock;
    @Mock
    private HttpServletRequest requestMock;
    @Mock
    private HttpServletResponse responseMock;
    @Mock
    private Account accountMock;
    @Mock
    private User userMock;
    @Mock
    private Master masterMock;
    @InjectMocks
    @Spy
    private AccountCreationServiceImpl testInstance;

    @Test
    public void accountUserCreationTest() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(requestMock.getSession(false)).thenReturn(sessionMock);
        when(requestMock.getParameter(LOGIN)).thenReturn(LOGIN);
        when(requestMock.getParameter(PASSWORD)).thenReturn(PASSWORD);
        when(requestMock.getParameter(PASSWORD_REPEAT)).thenReturn(PASSWORD);
        when(requestMock.getParameter(EMAIL)).thenReturn(EMAIL);
        when(requestMock.getParameter(ROLE)).thenReturn(USER);
        doReturn(accountMock).when(testInstance).getAccount();
        doReturn(userMock).when(testInstance).getUser();
        doReturn(null).doReturn(accountMock).when(accountRepositoryMock).getByLogin(anyString());
        when(requestMock.getSession()).thenReturn(sessionMock);
        when(userRepositoryMock.getUserById(anyInt())).thenReturn(userMock);
        Assertions.assertEquals(MAIN_JSP,testInstance.creation(requestMock,responseMock));
    }

    @Test
    public void accountMasterCreationTest() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(requestMock.getSession(false)).thenReturn(sessionMock);
        when(requestMock.getParameter(LOGIN)).thenReturn(LOGIN);
        when(requestMock.getParameter(PASSWORD)).thenReturn(PASSWORD);
        when(requestMock.getParameter(PASSWORD_REPEAT)).thenReturn(PASSWORD);
        when(requestMock.getParameter(EMAIL)).thenReturn(EMAIL);
        when(requestMock.getParameter(ROLE)).thenReturn(MASTER);
        doReturn(accountMock).when(testInstance).getAccount();
        doReturn(masterMock).when(testInstance).getMaster();
        doReturn(null).doReturn(accountMock).when(accountRepositoryMock).getByLogin(anyString());
        when(requestMock.getSession()).thenReturn(sessionMock);
        when(userRepositoryMock.getUserById(anyInt())).thenReturn(userMock);
        Assertions.assertEquals(MASTER_HOME_JSP,testInstance.creation(requestMock,responseMock));
    }

}
