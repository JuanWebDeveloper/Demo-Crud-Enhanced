package com.sofka.crud.controllers;

import java.util.ArrayList;
import java.util.Optional;

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

    // Method to get a user by id
    @GetMapping("/{id}")
    public Optional<UserModel> getUserById(@PathVariable Long id) {
        boolean exists = userService.validateExistenceOfId(id); // Check if id exists

        if (exists) {
            return Optional.of(userService.getUserById(id).get()); // If the id exists, the user is returned
        } else {
            return Optional.empty(); // If the id does not exist, an empty optional is returned
        }
    }

    // Method to get a users by priority
    @GetMapping("/priority/{priority}")
    public ArrayList<UserModel> getUsersByPriority(@PathVariable Integer priority) {
        return userService.getUsersByPriority(priority);
    }
 
}

