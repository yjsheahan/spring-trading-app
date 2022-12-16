package com.kok.services;

import com.kok.entities.OrderHistory;
import com.kok.entities.Transaction;
import com.kok.repositories.BuyRepository;
import com.kok.repositories.OrderHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyServiceImpl implements BuyService{

    @Autowired
    BuyRepository buyRepository;

    @Autowired
    OrderHistoryRepository orderHistoryRepository;

    @Override
    public Transaction createBid(String nasdaq, Transaction transaction, int userId) {
        transaction.setNasdaq(nasdaq);
        transaction.setType("buy");
        List<Transaction> sellList = this.buyRepository.collectByType("sell", nasdaq);
        int historySize = transaction.getSize();
        for(Transaction ask : sellList){
            if (ask.getPrice() <= transaction.getPrice()){
                int newSize;
                OrderHistory orderHistory = new OrderHistory();
                if(transaction.getSize() == ask.getSize()) {
                    this.buyRepository.delete(ask);
                    this.buyRepository.delete(transaction);
                    orderHistory.setDateCreated(transaction.getDateCreated());
                    orderHistory.setPrice(transaction.getPrice());
                    orderHistory.setType(transaction.getType());
                    orderHistory.setSize(transaction.getSize());
                    orderHistory.setNasdaq(transaction.getNasdaq());
                    orderHistory.setUserId(userId);
                    this.orderHistoryRepository.save(orderHistory);

                    //orderHistory.setUserId();
                    return transaction;
                }
                else if (transaction.getSize() > ask.getSize()){
                    newSize = transaction.getSize() - ask.getSize();
                    transaction.setSize(newSize);
                    orderHistory.setDateCreated(transaction.getDateCreated());
                    orderHistory.setPrice(ask.getPrice());
                    orderHistory.setType(transaction.getType());
                    orderHistory.setSize(ask.getSize());
                    orderHistory.setNasdaq(transaction.getNasdaq());
                    orderHistory.setUserId(userId);
                    this.orderHistoryRepository.save(orderHistory);
                    this.buyRepository.delete(ask);
                }
                else{
                    newSize = ask.getSize() - transaction.getSize();
                    ask.setSize(newSize);
                    this.buyRepository.delete(ask);
                    this.buyRepository.save(ask);
                    orderHistory.setDateCreated(transaction.getDateCreated());
                    orderHistory.setPrice(ask.getPrice());
                    orderHistory.setType(transaction.getType());
                    orderHistory.setSize(transaction.getSize());
                    orderHistory.setNasdaq(transaction.getNasdaq());
                    orderHistory.setUserId(userId);
                    this.orderHistoryRepository.save(orderHistory);
                    return transaction;
                }
            }
        }
    return this.buyRepository.save(transaction);
    }
}
