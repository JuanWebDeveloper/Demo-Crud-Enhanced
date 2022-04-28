package com.sofka.crud.services;

import java.util.ArrayList;

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
}
