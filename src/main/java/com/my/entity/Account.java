package com.my.entity;


import javax.persistence.*;

@MappedSuperclass
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true,nullable = false)
    protected int id;
    @Column(name = "login",unique = true,length = 45)
    protected String login;
    @Column(name = "pasword",length = 45)
    protected String password;
    @Column(name="email",length = 45)
    protected String email;


    public Account() {}
    public Account(int id, String login) {
        this.id = id;
        this.login = login;
    }


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
                " Password : " + password + " }";
    }
}
