package com.sofka.crud.models;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "user_role")
public class UserRoleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // Link between user and user_rol entities
    @ManyToOne (fetch = FetchType.LAZY, optional = true, targetEntity = UserModel.class)
    @JoinColumn(name = "user_role_id", nullable = false)
    @JsonBackReference
    private UserModel user;

    public UserRoleModel(UserModel user, String role) {
        this.user = user;
        this.role = role;
    }

    public UserRoleModel() {
    }
}
