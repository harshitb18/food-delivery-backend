package com.Foodies.FoodDelivery.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String username;

    private String emailId;

    private Long phoneNo;

    // Default constructor is required by JPA
    public User() {
    }

    public User(int userId, String username, String emailId, Long phoneNo) {
        this.userId = userId;
        this.username = username;
        this.emailId = emailId;
        this.phoneNo = phoneNo;
    }

    public User(String username, String emailId, Long phoneNo) {
        this.username = username;
        this.emailId = emailId;
        this.phoneNo = phoneNo;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(Long phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", emailId='" + emailId + '\'' +
                ", phoneNo=" + phoneNo +
                '}';
    }
}
