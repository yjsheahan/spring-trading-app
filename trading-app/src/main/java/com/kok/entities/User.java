package com.kok.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Getter @Setter @ToString
public class User {

    @Id @GeneratedValue
    private int userId;

    @NonNull @Column(unique = true)
    private String userName;
    @NonNull
    private String password;
    @NonNull
    private String fname;
    @NonNull
    private String lname;
    @NonNull
    private double Balance;
    @NonNull @Column(unique = true)
    private String email;
    @NonNull
    private String location;
    private String contactNumber;
    @NonNull
    private LocalDateTime dateCreated;

    public User() {
        this.dateCreated = LocalDateTime.now();
    }

    public User(int userId, String userName, String password, String fName, String lName, double balance, String email, String location, String contactNumber, LocalDateTime dateCreated) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.fname = fName;
        this.lname = lName;
        Balance = balance;
        this.email = email;
        this.location = location;
        this.contactNumber = contactNumber;
        this.dateCreated = dateCreated;
    }
}
