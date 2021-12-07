package com.my.controller.service;

import com.my.controller.service.implementation.LoginServiceImpl;
import com.my.entity.Account;
import com.my.entity.Admin;
import com.my.entity.Master;
import com.my.entity.User;
import com.my.repository.AccountRepository;
import com.my.repository.AdminRepository;
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

public class LoginServiceImplTest {

    @Mock
    private AccountRepository accountRepositoryMock;
    @Mock
    private AdminRepository adminRepositoryMock;
    @Mock
    private MasterRepository masterRepositoryMock;
    @Mock
    private UserRepository userRepositoryMock;
    @Mock
    private HttpServletRequest requestMock;
    @Mock
    private HttpServletResponse responseMock;
    @Mock
    private User userMock;
    @Mock
    private Master masterMock;
    @Mock
    private Admin adminMock;
    @Mock
    private Account accountMock;
    @Mock
    private HttpSession sessionMock;

    @InjectMocks
    @Spy
    private LoginServiceImpl testingInstance;

    @Test
    public void shouldLoginUser() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(requestMock.getSession(false)).thenReturn(sessionMock);
        when(requestMock.getSession()).thenReturn(sessionMock);
        when(sessionMock.getAttribute(USER_LOGGED_IN)).thenReturn(null);
        when(requestMock.getParameter(LOGIN)).thenReturn(LOGIN);
        when(requestMock.getParameter(PASSWORD)).thenReturn(PASSWORD);
        when(requestMock.getParameter(ROLE)).thenReturn(USER);
        when(accountRepositoryMock.existsAccountByLogin(anyString())).thenReturn(true);
        when(testingInstance.getAccount()).thenReturn(accountMock);
        when(accountRepositoryMock.getByLogin(anyString())).thenReturn(accountMock);
        when(accountMock.getPassword()).thenReturn(PASSWORD);
        when(accountRepositoryMock.existsAccountByLogin(anyString())).thenReturn(true);
        when(userRepositoryMock.existsUserById(accountMock.getId())).thenReturn(true);
        when(testingInstance.getUser()).thenReturn(userMock);
        when(userRepositoryMock.getById(anyInt())).thenReturn(userMock);
        when(userMock.getWallet()).thenReturn(0);
        when(userMock.getId()).thenReturn(1);
        when(accountMock.getLogin()).thenReturn(LOGIN);
        Assertions.assertEquals(MAIN_PAGE_COMMAND,testingInstance.login(requestMock,responseMock));
    }
    @Test
    public void shouldLoginMaster() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(requestMock.getSession(false)).thenReturn(sessionMock);
        when(requestMock.getSession()).thenReturn(sessionMock);
        when(sessionMock.getAttribute(USER_LOGGED_IN)).thenReturn(null);
        when(requestMock.getParameter(LOGIN)).thenReturn(LOGIN);
        when(requestMock.getParameter(PASSWORD)).thenReturn(PASSWORD);
        when(requestMock.getParameter(ROLE)).thenReturn(MASTER);
        when(accountRepositoryMock.existsAccountByLogin(anyString())).thenReturn(true);
        when(testingInstance.getAccount()).thenReturn(accountMock);
        when(accountRepositoryMock.getByLogin(anyString())).thenReturn(accountMock);
        when(accountMock.getPassword()).thenReturn(PASSWORD);
        when(accountRepositoryMock.existsAccountByLogin(anyString())).thenReturn(true);
        when(accountMock.getId()).thenReturn(1);
        when(masterRepositoryMock.existsMasterById(anyInt())).thenReturn(true);
        when(testingInstance.getMaster()).thenReturn(masterMock);
        when(masterMock.getId()).thenReturn(1);
        when(accountMock.getLogin()).thenReturn(LOGIN);
        when(masterRepositoryMock.getMasterById(anyInt())).thenReturn(masterMock);
        Assertions.assertEquals(MASTER_HOMEPAGE_COMMAND,testingInstance.login(requestMock,responseMock));
    }
    @Test
    public void shouldLoginAdmin() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(requestMock.getSession(false)).thenReturn(sessionMock);
        when(requestMock.getSession()).thenReturn(sessionMock);
        when(sessionMock.getAttribute(USER_LOGGED_IN)).thenReturn(null);
        when(requestMock.getParameter(LOGIN)).thenReturn(LOGIN);
        when(requestMock.getParameter(PASSWORD)).thenReturn(PASSWORD);
        when(requestMock.getParameter(ROLE)).thenReturn(USER);
        when(accountRepositoryMock.existsAccountByLogin(anyString())).thenReturn(true);
        when(testingInstance.getAccount()).thenReturn(accountMock);
        when(accountRepositoryMock.getByLogin(anyString())).thenReturn(accountMock);
        when(accountMock.getPassword()).thenReturn(PASSWORD);
        when(accountRepositoryMock.existsAccountByLogin(anyString())).thenReturn(true);
        when(adminRepositoryMock.existsAdminById(accountMock.getId())).thenReturn(true);
        when(testingInstance.getAdmin()).thenReturn(adminMock);
        when(adminMock.getId()).thenReturn(1);
        when(accountMock.getLogin()).thenReturn(LOGIN);
        when(adminRepositoryMock.getAdminById( anyInt())).thenReturn(adminMock);
        Assertions.assertEquals(ADMIN_HOMEPAGE_COMMAND,testingInstance.login(requestMock,responseMock));
    }
}
