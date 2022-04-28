package com.sofka.crud.controllers;

import java.util.ArrayList;

import com.sofka.crud.models.UserRoleModel;
import com.sofka.crud.services.UserRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/role")
public class UserRoleController {
    @Autowired
    UserRoleService userRoleService;

    // Method to get all roles
    @GetMapping()
    public ArrayList<UserRoleModel> getAllRoles() {
        return userRoleService.getAllRoles();
    }
}
