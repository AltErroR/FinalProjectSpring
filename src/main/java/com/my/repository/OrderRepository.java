package com.my.repository;

import com.my.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

import static com.my.constants.SQLConstants.*;
@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
    Order getOrderById(int id);
    Order getByMasterIdAndDateSlotAndTimeSlotAndServiceName(int masterId, Date date, String time, String serviceName);


    List<Order> getAllByMasterId(String masterLogin);
    List<Order> getAllByUserId(int userId);
    List<Order> getAllByStatusEquals(String status);
    boolean existsOrderByMasterIdAndDateSlotAndTimeSlotAndServiceName(int masterId, Date date, String time, String serviceName);

    @Query(value = SELECT_ORDERS_FOR_USER,nativeQuery = true)
    List<Order> getAll4User(int userId);
    @Query(value = SELECT_ORDERS_FOR_MASTER,nativeQuery = true)
    List<Order> getAll4Master(int masterId);
    @Query(value = SELECT_RESERVED_ORDERS,nativeQuery = true)
    List<Order> getAll4Admin();
    @Query(value = SELECT_DONE_ORDERS,nativeQuery = true)
    List<Order> getAll4Payment();
}
