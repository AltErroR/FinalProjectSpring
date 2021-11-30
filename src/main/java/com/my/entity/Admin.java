package com.my.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@Scope(value="prototype")
@Table(name="admins")
public class Admin {
    @Id
    @Column(name = "id",unique = true,nullable = false)
    protected int id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id",updatable = false,insertable = false,referencedColumnName = "id")
    private Account account;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Admin { Id : " + id + " }";
    }
}
