package com.kok.controllers;

import com.kok.entities.Transaction;
import com.kok.services.SellService;
import jakarta.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SellController {
    @Autowired
    SellService sellService;

    @PostMapping("/{nasdaq}/sell")
    public ResponseEntity<Transaction> storeTransactionData(
            @RequestBody Transaction transaction, @PathVariable("nasdaq") String nasdaq){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Add-ask", "Ask transaction added.");
        return ResponseEntity
                .status(HttpStatus.OK)
                .headers(headers)
                .body(this.sellService.createAsk(transaction, nasdaq));
    }

    @GetMapping("/sell")
    public ResponseEntity<List<Transaction>> getSellTransactions(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Ask-list", "All ask transactions.");
        return ResponseEntity
                .status(HttpStatus.OK)
                .headers(headers)
                .body(this.sellService.findAllSellTransactions());
    }

    @GetMapping("/{nasdaq}/{type}")
    public ResponseEntity<List<Transaction>> getSellTransactions(
            @PathVariable("nasdaq") String nasdaq, @PathVariable("type") String type){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Ask-stock-list", "Ask transaction list for specific stock.");
        return ResponseEntity
                .status(HttpStatus.OK)
                .headers(headers)
                .body(this.sellService.findAllStockSellTransactions(nasdaq, type));
    }
}
