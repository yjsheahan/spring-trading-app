package com.kok.controllers;

import com.kok.entities.Transaction;
import com.kok.services.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuyController {

    @Autowired
    BuyService buyService;

    @PostMapping("/{nasdaq}/buy")
    public Transaction createBid(@RequestBody Transaction transaction, @PathVariable("nasdaq")String nasdaq){
        return this.buyService.createBid(nasdaq, transaction);
    }


}
