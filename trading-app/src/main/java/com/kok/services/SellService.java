package com.kok.services;

import com.kok.entities.Transaction;

public interface SellService {
    public Transaction createAsk(Transaction transaction, String nasdaq);
}
