package com.kok.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Getter @Setter @ToString
public class User {

    @Id @GeneratedValue
    private int userId;

    @Column(nullable=false, length=50, unique=true)
    private String userName;
    @Column(nullable=false, length=50)
    private String password;
    @Column(nullable=false, length=50)
    private String fName;
    @Column(nullable=false, length=50)
    private String lName;
    @Column(nullable=false)
    private double Balance;
    @Column(nullable=false, length=100, unique=true)
    private String email;
    @Column(nullable=false, length=50)
    private String location;
    private String contactNumber;
    @Column(nullable=false)
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
}
