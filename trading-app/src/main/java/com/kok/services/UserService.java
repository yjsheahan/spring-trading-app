package com.kok.services;

import com.kok.entities.User;

public interface UserService {

    User storeUserAccount(User user);

    User loginUser(User user);

}
