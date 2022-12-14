package com.kok.controllers;

import com.kok.entities.Transaction;
import com.kok.services.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
