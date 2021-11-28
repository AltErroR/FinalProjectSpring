package com.my.controller.service.implementation;

import com.my.controller.service.MainPageService;
import com.my.entity.MasterService;
import com.my.repository.MasterServiceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import static com.my.constants.Constants.*;
import static com.my.constants.SQLConstants.*;

@Service("MainPageService")
public class MainPageServiceImpl implements MainPageService {
    private static final Logger logger = LoggerFactory.getLogger(MainPageServiceImpl.class);
     MasterServiceRepository masterServiceRepository;
    List<MasterService> searchList = new ArrayList<>();
    long noOfRecords;
    int page = 1;
    int recordsPerPage = 4;
    @Autowired
    public MainPageServiceImpl(MasterServiceRepository repository){
        masterServiceRepository= repository;
        noOfRecords=masterServiceRepository.count();
    }
    @Override
    public String mainPageInitialization(String query,HttpServletResponse response,HttpServletRequest request){
        HttpSession session = request.getSession();
        if (noOfRecords == 0) {
            logger.warn("no data in master_service table");
            return ERROR_JSP;
        }
        if (request.getParameter(PAGE) != null)
            page = Integer.parseInt(request.getParameter(PAGE));
        long noOfPages = (noOfRecords / recordsPerPage);

        if (query.equals(SQL_SUBLIST_BY_MASTER_NAME) && request.getParameter(MASTER) != null) {
            searchList = masterServiceRepository.findAllByMasterLogin(request.getParameter(MASTER));
            logger.info("list sorted by master login");
            request.setAttribute(SORT_BY, MASTER_NAME);
        } else if (query.equals(SQL_SUBLIST_BY_SERVICE_NAME) && request.getParameter(SERVICE) != null) {
            searchList = masterServiceRepository.findAllByServiceName(request.getParameter(SERVICE));
            logger.info("list sorted by service name");
            request.setAttribute(SORT_BY, SERVICE_NAME);
        } else {
            searchList = masterServiceRepository.findAllByMaster();
            logger.info("list sorted by master");
            request.setAttribute(SORT_BY, MASTER);
        }
        request.setAttribute(NUMBER_OF_PAGES, noOfPages);
        request.setAttribute(CURRENT_PAGE, page);
        session.setAttribute(SEARCH_LIST, searchList);
        return MAIN_JSP;
    }
}
