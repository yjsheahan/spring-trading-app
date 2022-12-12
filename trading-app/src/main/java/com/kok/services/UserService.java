package com.kok.services;

import com.kok.entities.User;

import java.util.List;

public interface UserService {

    User storeUserAccount(User user);

    List<User> loginUser(User user);

}
