package com.my.controller.service;

import com.my.controller.service.implementation.OrderProcessingServiceImpl;
import com.my.entity.Order;
import com.my.entity.Service;
import com.my.entity.User;
import com.my.repository.OrderRepository;
import com.my.repository.ServiceRepository;
import com.my.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

import static com.my.constants.Constants.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;


 class OrderProcessingServiceImplTest {


    @Mock
    private OrderRepository orderRepositoryMock ;
    @Mock
    private HttpServletRequest requestMock;
    @Mock
    private HttpServletResponse responseMock;
    @Mock
    private Order orderMock;
    @Mock
    private HttpSession sessionMock;
    @Mock
    private Service serviceMock ;
    @Mock
    private ServiceRepository serviceRepositoryMock;
    @Mock
    private UserRepository userRepositoryMock;
    @Mock
    private User userMock;

    @InjectMocks
    @Spy
    private OrderProcessingServiceImpl testingInstance;


    @Test
     void shouldUpdateOrder(){
        MockitoAnnotations.initMocks(this);
        when(requestMock.getParameter(DATE)).thenReturn("2021-12-07");
        when(requestMock.getParameter(TIME)).thenReturn("1:1");
        when(requestMock.getParameter(ORDER_ID)).thenReturn("1");
        when(requestMock.getParameter(STATUS)).thenReturn(UPDATE);
        when(testingInstance.getOrder()).thenReturn(orderMock);
        when(orderRepositoryMock.getOrderById(1)).thenReturn(orderMock);
        Assertions.assertEquals(SUCCESS_JSP,testingInstance.updateOrder(requestMock,responseMock));
    }
    @Test
     void shouldDeleteOrder(){
        MockitoAnnotations.initMocks(this);
        when(requestMock.getParameter(DATE)).thenReturn("2021-12-07");
        when(requestMock.getParameter(TIME)).thenReturn("1:1");
        when(requestMock.getParameter(ORDER_ID)).thenReturn("1");
        when(requestMock.getParameter(STATUS)).thenReturn(DELETE);
        Assertions.assertEquals(SUCCESS_JSP,testingInstance.updateOrder(requestMock,responseMock));
    }

    @Test
     void shouldPayOrder() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(requestMock.getParameter(ORDER_ID)).thenReturn("1");
        when(testingInstance.getOrder()).thenReturn(orderMock);
        when(testingInstance.getUser()).thenReturn(userMock);
        when(testingInstance.getService()).thenReturn(serviceMock);
        when(orderRepositoryMock.getOrderById(anyInt())).thenReturn(orderMock);
        when(userRepositoryMock.getUserById(anyInt())).thenReturn(userMock);
        when(serviceRepositoryMock.getServiceByName(anyString())).thenReturn(serviceMock);
        when(userMock.getWallet()).thenReturn(12);
        when(serviceMock.getPrice()).thenReturn(3);
        Assertions.assertEquals(SUCCESS_JSP,testingInstance.payOrder(requestMock,responseMock));
    }

    @Test
     void shouldUpdateStatus(){
        MockitoAnnotations.initMocks(this);
        when(testingInstance.getOrder()).thenReturn(orderMock);
        when(requestMock.getParameter(STATUS)).thenReturn("reserved");
        when(requestMock.getParameter(ORDER_ID)).thenReturn("1");
        when(orderRepositoryMock.getOrderById(1)).thenReturn(orderMock);
        Assertions.assertEquals(SUCCESS_JSP,testingInstance.updateStatus(requestMock,responseMock));
    }

    @Test
     void shouldReturnUsers() {
        MockitoAnnotations.initMocks(this);
        when(orderRepositoryMock.getAll4User(1)).thenReturn(new ArrayList<>());
        when(orderRepositoryMock.getAll4Admin()).thenReturn(new ArrayList<>());
        when(orderRepositoryMock.getAll4Master(anyInt())).thenReturn(new ArrayList<>());
        when(orderRepositoryMock.getAll4Payment()).thenReturn(new ArrayList<>());
        when(requestMock.getSession()).thenReturn(sessionMock);
        when(sessionMock.getAttribute(anyString())).thenReturn("1");
        when(sessionMock.getAttribute(USER_LOGIN)).thenReturn(new ArrayList<>());
        Assertions.assertEquals(ADMIN_HOME_JSP,testingInstance.getAdminOrders(requestMock,responseMock));
        Assertions.assertEquals(GET_PAYMENT_JSP,testingInstance.getPaymentOrders(requestMock,responseMock));
        Assertions.assertEquals(MASTER_HOME_JSP,testingInstance.getMasterOrders(requestMock,responseMock));
        Assertions.assertEquals(WRITE_FEEDBACK_JSP,testingInstance.getUserOrders(requestMock,responseMock));
    }

}
