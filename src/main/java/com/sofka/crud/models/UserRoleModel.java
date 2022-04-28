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
    private String rol;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    // Link between user and user_rol entities
    @ManyToOne (fetch = FetchType.LAZY, optional = false, targetEntity = UserModel.class)
    @JoinColumn(name = "user_role_id", nullable = false)
    @JsonBackReference
    private UserModel user;

    public UserRoleModel(UserModel user, String rol) {
        this.user = user;
        this.rol = rol;
    }
}
