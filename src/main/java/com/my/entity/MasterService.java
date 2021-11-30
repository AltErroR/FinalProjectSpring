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

    @Column(name = "master_id")
    protected int masterId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "master_id",updatable = false,insertable = false,referencedColumnName = "id")
    private Master master;

    @Column(name= "name_service")
    protected String serviceName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "name_service",updatable = false,insertable = false,referencedColumnName = "name")
    private Service service;

    public MasterService(){}

    public MasterService(int masterId,String serviceName){
        this.masterId= masterId;
        this.serviceName=serviceName;
    }



    @Override
    public String toString() {
        return "MasterServiceDao { Id : " + id +
                " Master Login : " + masterId +
                " Service Name : " + serviceName +" }";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMasterId() {
        return masterId;
    }

    public void setMasterId(int masterId) {
        this.masterId = masterId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
