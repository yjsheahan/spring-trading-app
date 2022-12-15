package com.kok.services;

import com.kok.entities.Transaction;
import com.kok.repositories.SellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellServiceImpl implements SellService {
    @Autowired
    SellRepository sellRepository;

    @Override
    public Transaction createAsk(Transaction transaction, String nasdaq) {
        transaction.setNasdaq(nasdaq);
        transaction.setType("sell");
        List<Transaction> buyList = this.sellRepository.findAllByTypeAndStockOrderByPrice(nasdaq, "buy");
        for(Transaction t : buyList){
            // If buy price is greater than or equal to sell price
            if(t.getPrice() >=  transaction.getPrice()) {
                int newSize;
                // Check if sizes are equal
                if(t.getSize() == transaction.getSize()) {
                    this.sellRepository.delete(t);
                    this.sellRepository.delete(transaction);
                    // TODO: Update order history of users with both transactions fully filled
                    return transaction;
                // If sell size is larger than pending transactions buy size
                } else if(t.getSize() < transaction.getSize()) {
                    // Set transaction size to the difference
                    newSize = transaction.getSize() - t.getSize();
                    transaction.setSize(newSize);
                    // Delete pending transaction
                    this.sellRepository.delete(t);
                    // TODO: Update user's order history table with buy transaction fully filled, other partially filled
                } else {
                  // If transaction sell size is less than pending transactions buy size, set pending transaction size to difference
                  newSize = t.getSize() - transaction.getSize();
                  t.setSize(newSize);
                  // Delete transaction
                  this.sellRepository.delete(transaction);
                  // TODO: Update order history of users with transaction fully filled, other partially filled
                }
            }
        }
        return this.sellRepository.save(transaction);
    }

    @Override
    public List<Transaction> findAllSellTransactions() {
        return this.sellRepository.findAllByParamOrderByPrice("sell");
    }

    @Override
    public List<Transaction> findAllStockSellTransactions(String nasdaq, String type) {
        return this.sellRepository.findAllByTypeAndStockOrderByPrice(nasdaq, type);
    }

}
