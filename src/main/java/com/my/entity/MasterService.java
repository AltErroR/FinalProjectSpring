package com.my.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@Scope(value="prototype")
@Table(name = "services_masters")
public class MasterService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true,nullable = false)
    private int id;

    @Column(name = "login_master")
    protected String masterLogin;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "login_master",updatable = false,insertable = false,referencedColumnName = "login")
    private Master master;

    @Column(name= "name_service")
    protected String serviceName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "name_service",updatable = false,insertable = false,referencedColumnName = "name")
    private Service service;

    public MasterService(){}

    public MasterService(String masterLogin,String serviceName){
        this.masterLogin= masterLogin;
        this.serviceName=serviceName;
    }



    @Override
    public String toString() {
        return "MasterServiceDao { Id : " + id +
                " Master Login : " + masterLogin +
                " Service Name : " + serviceName +" }";
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
}
