package com.kok.services;

import com.kok.entities.User;
import com.kok.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public User storeUserAccount(User user) {

        if(userRepository.findByEmail(user.getEmail()) != null) throw new RuntimeException("Email already exists!");
        else if(userRepository.findByuserName(user.getUserName()) != null) throw new RuntimeException("UserName already exists!");

        return this.userRepository.save(user);
    }

    @Override
    public User loginUser(User user){
        User loadedUser = this.userRepository.findByuserName(user.getUserName());
        if(loadedUser == null) throw new RuntimeException("Incorrect username!");
        return loadedUser;
    }
}
