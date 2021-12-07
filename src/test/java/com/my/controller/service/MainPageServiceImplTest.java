package com.my.controller.service;

import com.my.controller.service.implementation.MainPageServiceImpl;
import com.my.dto.MasterServiceDTO;
import com.my.repository.MasterServiceRepository;
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
import java.util.Map;

import static com.my.constants.Constants.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;


public class MainPageServiceImplTest {
    @Mock
    private MasterServiceRepository masterServiceRepositoryMock ;
    @Mock
    private HttpServletRequest requestMock;
    @Mock
    private HttpServletResponse responseMock;
    @Mock
    private HttpSession sessionMock;
    @Mock
    private List<Map<String,String>> masterServiceListMock= new ArrayList<>();
    @Mock
    private final List<MasterServiceDTO> masterServiceListDTOMock= new ArrayList<>();
    @InjectMocks
    @Spy
    MainPageServiceImpl testingInstance;


    @Test
    public void shouldReturnMainPageById() {
        MockitoAnnotations.initMocks(this);
        testingInstance.setNoOfRecords(9);
        when(requestMock.getSession()).thenReturn(sessionMock);
        when(requestMock.getAttribute(SORT_BY)).thenReturn(" ");
        when(masterServiceRepositoryMock.findAllById(anyInt(),anyInt())).thenReturn(masterServiceListMock);
        when(testingInstance.getMasterServiceDTOList()).thenReturn(masterServiceListDTOMock);
        Assertions.assertEquals(MAIN_JSP,testingInstance.mainPageInitialization(responseMock,requestMock));
    }
    @Test
    public void shouldReturnMainPageByMaster() {
        MockitoAnnotations.initMocks(this);
        testingInstance.setNoOfRecords(9);
        when(requestMock.getSession()).thenReturn(sessionMock);
        when(requestMock.getAttribute(SORT_BY)).thenReturn(MASTER);
        when(masterServiceRepositoryMock.findAllByMaster(anyInt(),anyInt())).thenReturn(masterServiceListMock);
        when(testingInstance.getMasterServiceDTOList()).thenReturn(masterServiceListDTOMock);
        Assertions.assertEquals(MAIN_JSP,testingInstance.mainPageInitialization(responseMock,requestMock));
    }
    @Test
    public void shouldReturnMainPageByService() {
        MockitoAnnotations.initMocks(this);
        testingInstance.setNoOfRecords(9);
        when(requestMock.getSession()).thenReturn(sessionMock);
        when(requestMock.getAttribute(SORT_BY)).thenReturn(SERVICE);
        when(masterServiceRepositoryMock.findAllByService(anyInt(),anyInt())).thenReturn(masterServiceListMock);
        when(testingInstance.getMasterServiceDTOList()).thenReturn(masterServiceListDTOMock);
        Assertions.assertEquals(MAIN_JSP,testingInstance.mainPageInitialization(responseMock,requestMock));
    }
    @Test
    public void shouldReturnMainPageByRating() {
        MockitoAnnotations.initMocks(this);
        testingInstance.setNoOfRecords(9);
        when(requestMock.getSession()).thenReturn(sessionMock);
        when(requestMock.getAttribute(SORT_BY)).thenReturn(RATING);
        when(masterServiceRepositoryMock.findAllByRating(anyInt(),anyInt())).thenReturn(masterServiceListMock);
        when(testingInstance.getMasterServiceDTOList()).thenReturn(masterServiceListDTOMock);
        Assertions.assertEquals(MAIN_JSP,testingInstance.mainPageInitialization(responseMock,requestMock));
    }
    @Test
    public void shouldReturnMainPageByServiceName() {
        MockitoAnnotations.initMocks(this);
        testingInstance.setNoOfRecords(9);
        when(requestMock.getSession()).thenReturn(sessionMock);
        when(requestMock.getAttribute(SORT_BY)).thenReturn(SERVICE_NAME);
        when(masterServiceRepositoryMock.findAllByServiceName(anyString(),anyInt(),anyInt())).thenReturn(masterServiceListMock);
        when(testingInstance.getMasterServiceDTOList()).thenReturn(masterServiceListDTOMock);
        Assertions.assertEquals(MAIN_JSP,testingInstance.mainPageInitialization(responseMock,requestMock));
    }
    @Test
    public void shouldReturnMainPageByMasterName() {
        MockitoAnnotations.initMocks(this);
        testingInstance.setNoOfRecords(9);
        when(requestMock.getSession()).thenReturn(sessionMock);
        when(requestMock.getAttribute(SORT_BY)).thenReturn(MASTER_NAME);
        when(masterServiceRepositoryMock.findAllByMasterLogin(anyString(),anyInt(),anyInt())).thenReturn(masterServiceListMock);
        when(testingInstance.getMasterServiceDTOList()).thenReturn(masterServiceListDTOMock);
        Assertions.assertEquals(MAIN_JSP,testingInstance.mainPageInitialization(responseMock,requestMock));
    }

}
