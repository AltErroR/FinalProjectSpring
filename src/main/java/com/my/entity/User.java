package com.my.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;

@Entity
@Component
@Scope(value="prototype")
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id",unique = true,nullable = false)
    protected int id;
    @Column(name = "wallet",nullable = false)
    protected int wallet;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id",updatable = false,insertable = false,referencedColumnName = "id")
    private Account account;

    @OneToMany(cascade = {CascadeType.DETACH},fetch = FetchType.LAZY, mappedBy = "id")
    private Set<Order> orders;

    @OneToMany(cascade = {CascadeType.DETACH},fetch = FetchType.LAZY, mappedBy = "id")
    private Set<Feedback> feedbacks;

    public int getWallet() {
        return wallet;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User { Id : " + id +
                " Wallet : " + wallet + " }";
    }
}
