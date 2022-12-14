package com.kok.services;

import com.kok.entities.Transaction;
import com.kok.repositories.BuyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyServiceImpl implements BuyService{

    @Autowired
    BuyRepository buyRepository;

    @Override
    public Transaction createBid(String nasdaq, Transaction transaction) {
        transaction.setNasdaq(nasdaq);
        return this.buyRepository.save(transaction);
    }
}
