package com.kok.services;

import com.kok.entities.Transaction;
import com.kok.repositories.SellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellServiceImpl implements SellService {
    @Autowired
    SellRepository sellRepository;

    @Override
    public Transaction createAsk(Transaction transaction, String nasdaq) {
        transaction.setNasdaq(nasdaq);
        return this.sellRepository.save(transaction);
    }


}
