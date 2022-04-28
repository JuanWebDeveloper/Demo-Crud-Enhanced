package com.sofka.crud.repositories;

import com.sofka.crud.models.UserModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {
   
}
