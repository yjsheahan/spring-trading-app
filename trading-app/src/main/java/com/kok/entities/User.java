package com.kok.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class User {

    @Id @GeneratedValue
    private int userId;

    private String userName;
    private String password;
    private String fName;
    private String lName;
    private double Balance;
    private String email;
    private String location;
    private String contactNumber;
    private LocalDateTime dateCreated;

    public User() {
        this.dateCreated = LocalDateTime.now();
    }

    public User(int userId, String userName, String password, String fName, String lName, double balance, String email, String location, String contactNumber, LocalDateTime dateCreated) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.fName = fName;
        this.lName = lName;
        Balance = balance;
        this.email = email;
        this.location = location;
        this.contactNumber = contactNumber;
        this.dateCreated = dateCreated;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double balance) {
        Balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", Balance=" + Balance +
                ", email='" + email + '\'' +
                ", location='" + location + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
