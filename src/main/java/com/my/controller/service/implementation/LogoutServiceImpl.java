package com.my.controller.service.implementation;

import com.my.controller.service.LogoutService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.my.constants.Constants.LOG_OUT_COMMAND;

@Service("LogoutService")
public class LogoutServiceImpl implements LogoutService {
    private static final Logger logger = LoggerFactory.getLogger(LogoutServiceImpl.class);
    @Override
    public String exit(HttpServletRequest request, HttpServletResponse response) {
         request.getSession().invalidate();
        logger.info("success");
        return LOG_OUT_COMMAND;
    }
}
