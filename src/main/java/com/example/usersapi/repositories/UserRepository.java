package com.example.usersapi.repositories;

import com.example.usersapi.models.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {
    public abstract Optional<UserModel> findById(Integer id);
}
