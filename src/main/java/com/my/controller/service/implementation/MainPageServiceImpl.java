package com.my.controller.service.implementation;

import com.my.controller.service.MainPageService;
import com.my.dto.MasterServiceDTO;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.my.constants.Constants.*;

@Service("MainPageService")
public class MainPageServiceImpl implements MainPageService {
    private static final Logger logger = LoggerFactory.getLogger(MainPageServiceImpl.class);
     MasterServiceRepository masterServiceRepository;
    List<Map<String, String>> searchList = new ArrayList<>();
    long noOfRecords;
    int page = 1;
    int recordsPerPage = 4;
    @Autowired
    public MainPageServiceImpl(MasterServiceRepository repository){
        masterServiceRepository= repository;
        noOfRecords=masterServiceRepository.count();
    }
    @Override
    public String mainPageInitialization(HttpServletResponse response,HttpServletRequest request){
        HttpSession session = request.getSession();
        if (noOfRecords == 0) {
            logger.warn("no data in master_service table");
            return ERROR_JSP;
        }
        if (request.getParameter(PAGE) != null)
            page = Integer.parseInt(request.getParameter(PAGE));
        long noOfPages = (noOfRecords / recordsPerPage);


        switch (request.getAttribute(SORT_BY).toString()) {
            case MASTER:
                searchList = masterServiceRepository.findAllByMaster(recordsPerPage,(page-1)*recordsPerPage);
                logger.info("list sorted by master");
                break;
            case SERVICE:
                searchList = masterServiceRepository.findAllByService(recordsPerPage,(page-1)*recordsPerPage);
                logger.info("list sorted by service");
                break;
            case RATING:
                searchList = masterServiceRepository.findAllByRating(recordsPerPage,(page-1)*recordsPerPage);
                logger.info("list sorted by rating");
                break;
            case SERVICE_NAME:
                searchList = masterServiceRepository.findAllByServiceName(request.getParameter(SERVICE),recordsPerPage,(page-1)*recordsPerPage);
                logger.info("list sorted by service name");
                break;
            case MASTER_NAME:
                searchList = masterServiceRepository.findAllByMasterLogin(request.getParameter(MASTER),recordsPerPage,(page-1)*recordsPerPage);
                logger.info("list sorted by master login");
                break;
            default:
                searchList = masterServiceRepository.findAllById(recordsPerPage,(page-1)*recordsPerPage);
                logger.info("list sorted by master");
                break;
        }

        List<MasterServiceDTO> masterServiceDTO = getMasterServiceDTOList();
        request.setAttribute(NUMBER_OF_PAGES, noOfPages);
        request.setAttribute(CURRENT_PAGE, page);
        session.setAttribute(SEARCH_LIST, masterServiceDTO);
        return MAIN_JSP;
    }

    private List<MasterServiceDTO> getMasterServiceDTOList() {

        List<MasterServiceDTO> masterServiceDTO = new ArrayList<> ();
        for (Map<String,String> m:searchList) {
            List<String> list=new ArrayList<>(m.values());
                masterServiceDTO.add(new MasterServiceDTO(list.get(0), list.get(1)));
        }
        return masterServiceDTO;
    }
}
