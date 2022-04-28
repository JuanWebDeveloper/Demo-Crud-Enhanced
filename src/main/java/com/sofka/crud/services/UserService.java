package com.sofka.crud.services;

import java.util.ArrayList;

import com.sofka.crud.models.UserModel;
import com.sofka.crud.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    // Method to get all users
    public ArrayList<UserModel> getAllUsers() {
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    // Method to save a user
    public UserModel saveUser(UserModel user) {
        return userRepository.save(user);
    }


}

