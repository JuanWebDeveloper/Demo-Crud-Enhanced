package com.sofka.crud.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.sofka.crud.models.UserRoleModel;
import com.sofka.crud.services.UserRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/role")
public class UserRoleController {
    @Autowired
    UserRoleService userRoleService;

    // Method to get all roles
    @GetMapping()
    public ArrayList<UserRoleModel> getAllRoles() {
        return userRoleService.getAllRoles();
    }

    // Method to save a new role
    @PostMapping()
    public UserRoleModel saveRole(@RequestBody UserRoleModel userRole) {
        return userRoleService.saveRole(userRole);
    }

    // Method to get a role by id
    @GetMapping("/{id}")
    public Optional<UserRoleModel> getRoleById(@PathVariable Long id) {
        boolean exists = userRoleService.validateExistenceOfId(id); // Check if id exists

        if (exists) {
            return userRoleService.getRoleById(id); // If the id exists, the role is returned
        } else {
            return Optional.empty(); // If the id does not exist, an empty optional is returned
        }
    }
}