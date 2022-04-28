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

    // Method to update a role
    @PutMapping("/{id}")
    public UserRoleModel updateRole(@RequestBody UserRoleModel userRole, @PathVariable Long id) {
        userRole.setId(id);
        return userRoleService.updateRole(userRole);
    }

    // Method to delete a role
    @DeleteMapping("/{id}")
    public String deleteRole(@PathVariable Long id) {
        boolean exists = userRoleService.validateExistenceOfId(id); // Check if id exists

        if (exists) {
            boolean ok = userRoleService.deleteRole(id); // If the id exists, the user is deleted
            
            if (ok) {
                return "Role with id " + id + " was deleted"; // If the user was deleted, a message is returned
            } else {
                return "Could not delete role with id " + id;
            }
        } else {
            return "Role with id " + id + " does not exist"; // If the id does not exist, a message is returned
        }
    }
}
