package com.my.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@Scope(value="prototype")
@Table(name="admins")
public class Admin extends Account {
    @Id
    @Column(name = "id",insertable = false,updatable = false)
    private int id;

    public Admin(){
        super();
    }
    public Admin(int id,String login){
    super(id,login);
    }
    @Override
    public String toString() {
        return "Admin { Id : " + id +
                " Email : " + email +
                " Login : " + login +
                " Password : " + password + " }";
    }
}
