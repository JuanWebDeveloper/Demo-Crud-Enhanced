package com.sofka.crud.services;

import java.util.ArrayList;
import java.util.Optional;

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

    // Method to validate if an id exists
    public boolean validateExistenceOfId(Long id) {
        return userRepository.existsById(id);
    }

    // Method to get a user by id
    public Optional<UserModel> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Method to get a users by priority
    public ArrayList<UserModel> getUsersByPriority(Integer priority) {
        return (ArrayList<UserModel>) userRepository.findByPriority(priority);
    }

    // Method to update a user
    public Optional<UserModel> updateUser(UserModel user, Long id) {
        user.setId(id);
        return Optional.of(userRepository.save(user));
    }

    // Method to delete a user
    public boolean deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    } 
}

