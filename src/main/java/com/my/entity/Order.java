package com.my.entity;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Component
@Scope(value="prototype")
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true,nullable = false)
    private int id;

    @Column(name = "master_login",length= 45)
    private String masterLogin;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "master_login",updatable = false,insertable = false,referencedColumnName = "login")
    private Master master;

    @Column(name = "service_name",length= 45)
    private String serviceName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_name",updatable = false,insertable = false,referencedColumnName = "name")
    private Service service;

    @Column(name = "user_id")
    private int userId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",updatable = false,insertable = false)
    private User user;

    @Column(name = "time_slot")
    private String timeSlot;
    @Column(name = "date_slot")
    private Date dateSlot;
    @Column(name = "status",length= 45)
    private String  status;
    public Order() {}
    public Order(int id, String masterLogin,int userId) {
        this.id = id;
        this.masterLogin = masterLogin;
        this.userId = userId;
    }



    @Override
    public String toString() {
        return "Order { Id : " + id +
                " Master Login : " + masterLogin +
                " User Id : " + userId +
                " Service Name : " + serviceName +
                " Time : " + timeSlot +
                " Data : " + dateSlot +" }";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMasterLogin() {
        return masterLogin;
    }

    public void setMasterLogin(String masterLogin) {
        this.masterLogin = masterLogin;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public Date getDateSlot() {
        return dateSlot;
    }

    public void setDateSlot(Date dateSlot) {
        this.dateSlot = dateSlot;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
