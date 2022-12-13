package com.kok.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
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

    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getNasdaq() {
        return nasdaq;
    }

    public void setNasdaq(String nasdaq) {
        this.nasdaq = nasdaq;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }
}
