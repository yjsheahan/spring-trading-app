package com.kok.services;

import com.kok.entities.User;
import com.kok.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public User storeUserAccount(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public List<User> loginUser(User user) {
        return this.userRepository.findByuserName(user.getUserName());
    }
}
