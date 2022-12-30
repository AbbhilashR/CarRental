package com.example.carrentaldemo.service;

import com.example.carrentaldemo.model.User;
import com.example.carrentaldemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
