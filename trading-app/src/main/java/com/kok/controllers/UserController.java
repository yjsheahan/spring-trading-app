package com.kok.controllers;

import com.kok.entities.User;
import com.kok.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/new_user")
    public User addUser(@RequestBody User user){
        return this.userService.storeUserAccount(user);
    }

    @GetMapping("/login")
    public List<User> loginUser(@RequestBody User user){
        return this.userService.loginUser(user);
    }

}
