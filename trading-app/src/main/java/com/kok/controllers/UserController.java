package com.kok.controllers;

import com.kok.entities.User;
import com.kok.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/new_user")
    public User addUser(@RequestBody User user){
        return this.userService.storeUserAccount(user);
    }

}
