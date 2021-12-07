package com.my.entity;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Component
@Scope(value="prototype")
@Table(name="accounts")
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true,nullable = false)
    protected int id;
    @Column(name = "login",unique = true,length = 45)
    protected String login;
    @Column(name = "password",length = 45)
    protected String password;
    @Column(name="email",length = 45)
    protected String email;
//    @Enumerated(value = EnumType.STRING)
//    @Column(name = "role")
//    private Role role;
//    @Column(name = "status")
//    private boolean status;

    @OneToOne(cascade = {CascadeType.DETACH},fetch = FetchType.LAZY, mappedBy = "account")
    @PrimaryKeyJoinColumn
    private transient Master master;
    @OneToOne(cascade = {CascadeType.DETACH},fetch = FetchType.LAZY, mappedBy = "account")
    @PrimaryKeyJoinColumn
    private transient User user;
    @OneToOne(cascade = {CascadeType.ALL},fetch = FetchType.LAZY, mappedBy = "account")
    @PrimaryKeyJoinColumn
    private transient Admin admin;

    public Account() {}
    public Account(int id, String login) {
        this.id = id;
        this.login = login;
    }
//
//    public Role getRole() {
//        return role;
//    }
//
//    public void setRole(Role role) {
//        this.role = role;
//    }
//    public Boolean getStatus() {
//        return status;
//    }
//
//    public void setStatus(Boolean status) {
//        this.status = status;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Account { Id : " + id +
                " Email : " + email +
                " Login : " + login +
                " Password : " + password +
//                " Status : " +status +
//                " Role : " + role +
                 " }";
    }
}
