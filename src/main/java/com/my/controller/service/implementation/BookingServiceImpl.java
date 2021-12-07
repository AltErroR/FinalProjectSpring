package com.my.controller.service.implementation;

import com.my.controller.service.BookingService;
import com.my.entity.Order;
import com.my.repository.AccountRepository;
import com.my.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

import java.sql.Date;

import static com.my.constants.Constants.SUCCESS_JSP;

@Service("BookingService")
public class BookingServiceImpl implements BookingService {
    private static final Logger logger = LoggerFactory.getLogger(BookingServiceImpl.class);
    OrderRepository orderRepository;
    AccountRepository accountRepository;
    Order order;

  @Autowired
          public BookingServiceImpl(OrderRepository orderRepository,AccountRepository accountRepository){
      this.orderRepository= orderRepository;
      this.accountRepository= accountRepository;
  }
    @Lookup
    public Order getOrder() {
        return null;
    }

    @Override
    public String booking(Date dateSlot, String timeSlot, String masterLogin, String serviceName, int userId) throws Exception {
      int masterId=accountRepository.getByLogin(masterLogin).getId();
        if(orderRepository.existsOrderByMasterIdAndDateSlotAndTimeSlotAndServiceName(masterId, dateSlot, timeSlot, serviceName))
        {
            logger.debug("reservation failed");
            throw new Exception("Already reserved");
        }
        order=getOrder();
        order.setUserId(userId);
        order.setServiceName(serviceName);
        order.setStatus("reserved");
        order.setDateSlot(dateSlot);
        order.setMasterId(masterId);
        order.setTimeSlot(timeSlot);
        orderRepository.save(order);
        logger.debug("reservation done");
        return SUCCESS_JSP;
    }
}
