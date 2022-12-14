package com.kok.repositories;

import com.kok.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByuserName(String userName);


    User findByEmail(String email);
}
