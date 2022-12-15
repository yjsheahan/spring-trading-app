package com.kok.controllers;

import com.kok.entities.Stock;
import com.kok.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StockController {
    @Autowired
    private StockService stockService;

    @GetMapping("/stocks")
    public ResponseEntity<List<Stock>> getStocks(){
        List<Stock> stocks = this.stockService.listAllStocks();
        HttpHeaders headers = new HttpHeaders();
        headers.add("info", "Stocks Information");

        return ResponseEntity
                .status(HttpStatus.OK)
                .headers(headers)
                .body(stocks);
    }

    @PostMapping("/stocks")
    public ResponseEntity<Stock> storeStock(@RequestBody Stock stock){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.stockService.addStock(stock));
    }

    @GetMapping("/stocks/{nasdaq}")
    public ResponseEntity<Stock> getByNasdaq(@PathVariable("nasdaq") String nasdaq){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.stockService.getByNasdaq(nasdaq));
    }

}
