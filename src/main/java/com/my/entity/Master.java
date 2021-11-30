package com.my.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Component
@Scope(value="prototype")
@Table(name= "masters")
public class Master implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true,nullable = false)
    private int id;
    @Column(name = "status",length = 45)
    private String status;
    @Column(name="rating",length = 2)
    private String rating;


    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id",updatable = false,insertable = false,referencedColumnName = "id")
    private Account account;
    @OneToMany(cascade = {CascadeType.DETACH},fetch = FetchType.LAZY, mappedBy = "master")
    private transient Set<Order> orders;
    @OneToMany(cascade = {CascadeType.DETACH},fetch = FetchType.LAZY, mappedBy = "master")
    private transient Set<Feedback> feedbacks;
    @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "master")
    private transient Set<MasterService> masterServices;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Master { Id : " + id +
                " Status : " + status +
                " Rating : " + rating + " }";
    }
}
