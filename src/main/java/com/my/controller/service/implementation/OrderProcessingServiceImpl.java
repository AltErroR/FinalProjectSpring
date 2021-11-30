package com.my.controller.service.implementation;

import com.my.controller.service.OrderProcessingService;
import com.my.entity.Order;
import com.my.entity.Service;
import com.my.entity.User;
import com.my.repository.OrderRepository;
import com.my.repository.ServiceRepository;
import com.my.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

import static com.my.constants.Constants.*;

    @org.springframework.stereotype.Service("OrderProcessingService")
public class OrderProcessingServiceImpl implements OrderProcessingService {
    private static final Logger logger = LoggerFactory.getLogger(OrderProcessingServiceImpl.class);
    @Autowired
        public OrderProcessingServiceImpl(OrderRepository orderRepository, UserRepository userRepository,
            ServiceRepository serviceRepository){
        this.orderRepository=orderRepository;
        this.userRepository=userRepository;
        this.serviceRepository=serviceRepository;
    }
    OrderRepository orderRepository;
    UserRepository userRepository;
    ServiceRepository serviceRepository;
    Order order;
    User user;
    Service service;
        @Lookup
        public Order getOrder() {
            return null;
        }
        @Lookup
        public User getUser() {
            return null;
        }
        @Lookup
        public Service getService() {
            return null;
        }

    @Transactional
    @Override
    public String updateOrder(HttpServletRequest request, HttpServletResponse response) {
        String time =request.getParameter(TIME);
        Date date =Date.valueOf(request.getParameter(DATE));
        int orderId =Integer.parseInt(request.getParameter(ORDER_ID));
        String typeOfUpdate = request.getParameter(STATUS);
        if(typeOfUpdate.equals(DELETE)){
            orderRepository.deleteById(orderId);
            logger.debug("order deleted");
        }
        if(typeOfUpdate.equals(UPDATE)){
            order=getOrder();
            order = orderRepository.getOrderById(orderId);
            order.setTimeSlot(time);
            order.setDateSlot(date);
            orderRepository.save(order);
            logger.debug("order updated");
        }
        logger.debug("succes.jsp");
        return SUCCESS_JSP;
    }
    @Transactional
    @Override
    public String payOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int orderId =Integer.parseInt(request.getParameter(ORDER_ID));
            order=getOrder();
            user=getUser();
            service= getService();
             order = orderRepository.getOrderById(orderId);
             user = userRepository.getUserById(order.getUserId());
             service = serviceRepository.getServiceByName(order.getServiceName());
            if (user.getWallet()-service.getPrice()<0){
                logger.warn("wallet < price");
                throw new Exception("Not Enought Money");
            }
        user.setWallet(user.getWallet()-service.getPrice());
            order.setStatus("paid");
            orderRepository.save(order);
            userRepository.save(user);
        logger.debug("order payment done");
        return SUCCESS_JSP;
    }
    @Transactional
    @Override
    public String updateStatus(HttpServletRequest request, HttpServletResponse response) {
        String status = request.getParameter(STATUS);
        int id =Integer.parseInt(request.getParameter(ORDER_ID));
        order= getOrder();
        order= orderRepository.getOrderById(id);
        order.setStatus(status);
        orderRepository.save(order);
        logger.debug("status updated");
        return SUCCESS_JSP;
    }

    @Override
    public String getUserOrders(HttpServletRequest request, HttpServletResponse response){
        List<Order> ordersList= orderRepository.getAll4User((int)request.getSession().getAttribute(USER_ID));
        request.setAttribute(ORDERS_LIST,ordersList);
        logger.debug(SUCCESS);
        return WRITE_FEEDBACK_JSP;
    }

    @Override
    public String getMasterOrders(HttpServletRequest request, HttpServletResponse response){
        List<Order> ordersList= orderRepository.getAll4Master(Integer.parseInt(request.getSession().getAttribute(USER_ID).toString()));
        request.setAttribute(ORDERS_LIST,ordersList);
        logger.debug(SUCCESS);
        return MASTER_HOME_JSP;
    }

    @Override
    public String getAdminOrders(HttpServletRequest request, HttpServletResponse response){
        List<Order> ordersList= orderRepository.getAll4Admin();
        request.setAttribute(ORDERS_LIST,ordersList);
        logger.debug(SUCCESS);
        return ADMIN_HOME_JSP;
    }

    @Override
    public String getPaymentOrders(HttpServletRequest request, HttpServletResponse response){
        List<Order> ordersList= orderRepository.getAll4Payment();
        request.setAttribute(ORDERS_LIST,ordersList);
        logger.debug(SUCCESS);
        return GET_PAYMENT_JSP ;
    }
}
