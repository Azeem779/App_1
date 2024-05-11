package com.example.Test.Controller;


import com.example.Test.entities.User;

import com.example.Test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUsers(@RequestBody User user){
        User savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("{/id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId){
        User fetchUser = userService.getUserById(userId);
        if(fetchUser != null){
            return new ResponseEntity<>(fetchUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> allUser = userService.getAllUser();
        return new ResponseEntity<>(allUser, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> validateUser(@RequestBody User user){
        boolean userExists = userService.validateUser(user.getUsername(), user.getPassword());

        if (userExists) {
            return new ResponseEntity<>("Login successful", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid credentials. Please sign up.", HttpStatus.UNAUTHORIZED);
        }
    }
}
