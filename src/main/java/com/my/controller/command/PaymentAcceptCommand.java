package com.my.controller.command;

import com.my.controller.service.implementation.OrderProcessingServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class PaymentAcceptCommand implements Command {
    private static final Logger logger = LoggerFactory.getLogger(PaymentAcceptCommand.class);
    @Autowired
    public PaymentAcceptCommand(OrderProcessingServiceImpl orderProcessingService){
        this.orderProcessingService=orderProcessingService;
    }
    OrderProcessingServiceImpl orderProcessingService;
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.debug("try to make payment");
        return  orderProcessingService.payOrder(request,response);
    }
}
