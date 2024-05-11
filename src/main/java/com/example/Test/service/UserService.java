package com.example.Test.service;

import com.example.Test.entities.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(Long userId);
    List<User> getAllUser();
    boolean validateUser(String username, String password);
}
