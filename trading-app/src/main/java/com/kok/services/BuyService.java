package com.kok.services;

import com.kok.entities.Transaction;

public interface BuyService {
    Transaction createBid(String nasdaq, Transaction transaction, int userId);
}
