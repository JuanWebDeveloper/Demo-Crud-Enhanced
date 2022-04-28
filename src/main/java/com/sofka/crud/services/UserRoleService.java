package com.sofka.crud.services;

import java.util.ArrayList;
import java.util.Optional;

import com.sofka.crud.models.UserRoleModel;
import com.sofka.crud.repositories.UserRoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService {
    @Autowired
    UserRoleRepository userRoleRepository;

    // Method to get all roles
    public ArrayList<UserRoleModel> getAllRoles() {
        return (ArrayList<UserRoleModel>) userRoleRepository.findAll();
    }

    // Method to save a new role
    public UserRoleModel saveRole(UserRoleModel userRole) {
        return userRoleRepository.save(userRole);
    }

    // Method to validate if an id exists
    public boolean validateExistenceOfId(Long id) {
        return userRoleRepository.existsById(id);
    }

    // Method to get a role by id
    public Optional<UserRoleModel> getRoleById(long id) {
        return userRoleRepository.findById(id);
    }

    // Method to update a role
    public UserRoleModel updateRole(UserRoleModel userRole) {
        return userRoleRepository.save(userRole);
    }

    // Method to delete a role
    public boolean deleteRole(long id) {
        try {
            userRoleRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }   
    }
}
