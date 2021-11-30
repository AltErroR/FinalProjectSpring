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

    @Column(name = "master_id",length = 45)
    private int masterId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "master_id",unique = true,insertable = false,updatable = false,referencedColumnName = "id")
    private Master master;

    @Column(name="feedback")
    private String feedbackMessage;
    @Column(name="user_rate",length = 2)
    private String userRate;

    public Feedback() {}
    public Feedback(int id, int userId, int masterId) {
        this.id = id;
        this.userId = userId;
        this.masterId = masterId;
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

    public int getMasterId() {
        return masterId;
    }

    public void setMasterId(int masterId) {
        this.masterId = masterId;
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
                " Master Login : " + masterId +
                " User id : " + userId +
                " Feedback : " + feedbackMessage +
                " User rate : " + userRate + " }";
    }
}
