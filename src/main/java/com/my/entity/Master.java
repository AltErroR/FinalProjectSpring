package com.my.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Component
@Scope(value="prototype")
@Table(name= "masters")
public class Master extends Account implements Serializable {


    @Column(name = "status",length = 45)
    protected String status;
    @Column(name="rating",length = 2)
    protected String rating;

    @OneToMany(cascade = {CascadeType.DETACH},fetch = FetchType.LAZY, mappedBy = "master")
    private transient Set<Order> orders;
    @OneToMany(cascade = {CascadeType.DETACH},fetch = FetchType.LAZY, mappedBy = "master")
    private transient Set<Feedback> feedbacks;
    @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "master")
    private transient Set<MasterService> masterServices;

    public Master() {
     super();
    }
    public Master(int id,String login) {
        super(id,login);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }


    @Override
    public String toString() {
        return "Master { Id : " + id +
                " Email : " + email +
                " Login : " + login +
                " Password : " + password +
                " Status : " + status +
                " Rating : " + rating + " }";
    }
}
