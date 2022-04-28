package com.sofka.crud.repositories;

import com.sofka.crud.models.UserRoleModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRoleModel, Long> {
}
