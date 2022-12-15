package com.kok.services;

import com.kok.entities.Transaction;

import java.util.List;

public interface SellService {
    public Transaction createAsk(Transaction transaction, String nasdaq);
    public List<Transaction> findAllSellTransactions();
    List<Transaction> findAllStockSellTransactions(String stock, String type);
}
