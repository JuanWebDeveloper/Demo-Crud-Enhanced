package com.sofka.crud.controllers;

import java.util.ArrayList;

import com.sofka.crud.models.UserModel;
import com.sofka.crud.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    // Method to get all users
    @GetMapping()
    public ArrayList<UserModel> getAllUsers() {
        return userService.getAllUsers();
    }

    // Method to save a user
    @PostMapping()
    public UserModel saveUser(@RequestBody UserModel user) {
        return userService.saveUser(user);
    }
}

