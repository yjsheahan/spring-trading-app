package com.kok.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Getter @Setter @ToString
public class OrderHistory {

    @Id @GeneratedValue
    private int historyId;
    private int userId;
    private LocalDateTime dateCreated;
    private String nasdaq;
    private String type;
    private int size;
    private double price;

}
