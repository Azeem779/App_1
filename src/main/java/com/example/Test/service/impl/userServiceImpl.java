package com.example.Test.service.impl;

import com.example.Test.entities.User;
import com.example.Test.repository.UserRepository;
import com.example.Test.service.UserService;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class userServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        Optional<User> optionalUser =  userRepository.findById(userId);
        return optionalUser.get();
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }


    @Override
    public boolean validateUser(String username, String password) {
        return userRepository.existsByUsernameAndPassword(username, password);
    }

    

}
