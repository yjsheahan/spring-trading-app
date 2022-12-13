package com.kok.services;

import com.kok.entities.Stock;
import com.kok.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StockServiceImpl implements StockService {
    @Autowired
    StockRepository stockRepository;

    @Override
    public List<Stock> listAllStocks() {
        List<Stock> stocks = this.stockRepository.findAll();
        if(stocks.size() != 0) return stocks;
        else return null;
    }

    @Override
    public Stock addStock(Stock stock) {
        return this.stockRepository.save(stock);
    }

    @Override
    public Stock getByNasdaq(String nasdaq) {
        return this.stockRepository.getByNasdaq(nasdaq);
    }

    @Override
    public Stock getByStockName(String stockName) {
        return this.stockRepository.getByStockName(stockName);
    }
}
