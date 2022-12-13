package com.kok.services;

import com.kok.entities.Stock;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StockService {
    public List<Stock> listAllStocks();
    public Stock addStock(Stock stock);
    public Stock getByNasdaq(String nasdaq);
    public Stock getByStockName(String stockName);
}
