package com.kok.services;

import com.kok.entities.Transaction;
import com.kok.repositories.BuyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyServiceImpl implements BuyService{

    @Autowired
    BuyRepository buyRepository;

    @Override
    public Transaction createBid(String nasdaq, Transaction transaction) {
        transaction.setNasdaq(nasdaq);
        transaction.setType("buy");
        List<Transaction> sellList = this.buyRepository.collectByType("sell", nasdaq);
        for(Transaction ask : sellList){
            if (ask.getPrice() <= transaction.getPrice()){
                int newSize;
                if(transaction.getSize() == ask.getSize()) {
                    this.buyRepository.delete(ask);
                    this.buyRepository.delete(transaction);
                    return transaction;
                }
                else if (transaction.getSize() > ask.getSize()){
                    newSize = transaction.getSize() - ask.getSize();
                    transaction.setSize(newSize);
                    this.buyRepository.delete(ask);
                }
                else{
                    newSize = ask.getSize() - transaction.getSize();
                    ask.setSize(newSize);
                    this.buyRepository.delete(ask);
                    this.buyRepository.save(ask);
                    return transaction;
                }
            }
        }
    return this.buyRepository.save(transaction);
    }
}
