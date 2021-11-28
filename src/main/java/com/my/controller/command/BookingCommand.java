package com.my.controller.command;

import com.my.controller.service.implementation.BookingServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Date;

import static com.my.constants.Constants.*;
@Component
public class BookingCommand implements Command{
    private static final Logger logger = LoggerFactory.getLogger(BookingCommand.class);
    @Autowired
            public BookingCommand(BookingServiceImpl bookingServiceImplementation){
        this.bookingServiceImplementation=bookingServiceImplementation;
    }
    BookingServiceImpl bookingServiceImplementation;
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("Try to make reservation");
        HttpSession session = request.getSession();
        Date dateSlot= Date.valueOf(request.getParameter(DATE));
        String timeSlot= request.getParameter(TIME);
        String masterLogin= request.getParameter(MASTER);
        String serviceName= request.getParameter(SERVICE);
        int userId =(int) session.getAttribute(USER_ID);
        return bookingServiceImplementation.booking(dateSlot,timeSlot,masterLogin,serviceName,userId);
    }
}
