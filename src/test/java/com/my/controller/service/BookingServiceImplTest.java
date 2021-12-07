package com.my.controller.service;

import com.my.controller.service.implementation.BookingServiceImpl;
import com.my.entity.Account;
import com.my.entity.Order;
import com.my.repository.AccountRepository;
import com.my.repository.OrderRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.sql.Date;

import static com.my.constants.Constants.SUCCESS_JSP;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

public class BookingServiceImplTest {
    @Mock
    private OrderRepository orderRepositoryMock;
    @Mock
    AccountRepository accountRepositoryMock;
    @Mock
    private Order orderMock;
    @Mock
    private Account accountMock;
    @InjectMocks
    @Spy
    private BookingServiceImpl testInstance= new BookingServiceImpl(orderRepositoryMock,accountRepositoryMock);

    @Test
    public void bookingTest() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(orderRepositoryMock.existsOrderByMasterIdAndDateSlotAndTimeSlotAndServiceName(0, Date.valueOf("2021-12-06"), " ", " ")).
                thenReturn(false);
        when(accountRepositoryMock.getByLogin(anyString())).thenReturn(accountMock);
        when(accountMock.getId()).thenReturn(1);
        when(testInstance.getOrder()).thenReturn(orderMock);
        Assertions.assertEquals(SUCCESS_JSP,testInstance.booking(Date.valueOf("2021-12-06"),"12:00","master","service",1));
    }
}
