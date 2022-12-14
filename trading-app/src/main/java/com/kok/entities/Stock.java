package com.kok.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stockId;
    private String stockName;
    private String nasdaq;
    private double currentPrice;

    public Stock() {
    }

    public Stock(String stockName, String nasdaq, double currentPrice) {
        this.stockName = stockName;
        this.nasdaq = nasdaq;
        this.currentPrice = currentPrice;
    }

    public Stock(int stockId, String stockName, String nasdaq, double currentPrice) {
        this.stockId = stockId;
        this.stockName = stockName;
        this.nasdaq = nasdaq;
        this.currentPrice = currentPrice;
    }
}
