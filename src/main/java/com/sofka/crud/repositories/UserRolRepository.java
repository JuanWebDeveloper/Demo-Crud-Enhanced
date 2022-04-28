package com.sofka.crud.repositories;

import com.sofka.crud.models.UserRolModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRolRepository extends CrudRepository<UserRolModel, Long> {
    
}
