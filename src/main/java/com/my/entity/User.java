package com.my.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;

@Entity
@Component
@Scope(value="prototype")
@Table(name = "users")
public class User extends Account {


    @Column(name = "wallet",nullable = false)
    protected int wallet;

    @OneToMany(cascade = {CascadeType.DETACH},fetch = FetchType.LAZY, mappedBy = "id")
    private Set<Order> orders;

    @OneToMany(cascade = {CascadeType.DETACH},fetch = FetchType.LAZY, mappedBy = "id")
    private Set<Feedback> feedbacks;

    public User() {
        super();
    }
    public User(int id,String login) {
        super(id,login);
    }

    public int getWallet() {
        return wallet;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }



    @Override
    public String toString() {
        return "User { Id : " + id +
                " Email : " + email +
                " Login : " + login +
                " Password : " + password +
                " Wallet : " + wallet + " }";
    }
}
