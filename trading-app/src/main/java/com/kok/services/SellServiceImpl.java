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
<<<<<<< HEAD

        List<Transaction> buyList = this.sellRepository.findAllByTypeAndStockOrderByPrice(nasdaq, "buy");
        for(Transaction t : buyList){
            if(t.getSize() >= transaction.getSize()) t.setSize(t.getSize() - transaction.getSize());
            else{
                transaction.setSize(transaction.getSize() - t.getSize());
                t.setSize(0);
            }
        }
=======
        transaction.setType("sell");
>>>>>>> main
        return this.sellRepository.save(transaction);
    }

    @Override
    public List<Transaction> findAllSellTransactions() {
        return this.sellRepository.findAllByParamOrderByPrice("sell");
    }

    @Override
    public List<Transaction> findAllStockSellTransactions(String stock, String type) {
        return this.sellRepository.findAllByTypeAndStockOrderByPrice(stock, type);
    }


}
