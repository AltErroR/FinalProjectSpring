package com.my.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
@Scope(value="prototype")
@Table(name = "feedbacks")
public class Feedback {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true,nullable = false)
    private int id;

    @Column(name="user_id")
    private int userId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",unique = true,insertable=false,updatable = false)
    private User user;

    @Column(name = "master_login",length = 45)
    private String masterLogin;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "master_login",unique = true,insertable = false,updatable = false,referencedColumnName = "login")
    private Master master;

    @Column(name="feedback")
    private String feedbackMessage;
    @Column(name="user_rate",length = 2)
    private String userRate;

    public Feedback() {}
    public Feedback(int id, int userId, String masterLogin) {
        this.id = id;
        this.userId = userId;
        this.masterLogin = masterLogin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMasterLogin() {
        return masterLogin;
    }

    public void setMasterLogin(String masterId) {
        this.masterLogin = masterId;
    }

    public String getFeedbackMessage() {
        return feedbackMessage;
    }

    public void setFeedbackMessage(String feedback) {
        this.feedbackMessage = feedback;
    }

    public String getUserRate() {
        return userRate;
    }

    public void setUserRate(String userRate) {
        this.userRate = userRate;
    }

    @Override
    public String toString() {
        return "Feedback { Id : " + id +
                " Master Login : " + masterLogin +
                " User id : " + userId +
                " Feedback : " + feedbackMessage +
                " User rate : " + userRate + " }";
    }
}
