package com.sofka.crud.models;

import javax.persistence.*;

@Entity
@Table(name = "user_rol")
public class UserRolModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private UserModel user;
    private String rol;

    public UserRolModel(UserModel user, String rol) {
        this.user = user;
        this.rol = rol;
    }

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
}
