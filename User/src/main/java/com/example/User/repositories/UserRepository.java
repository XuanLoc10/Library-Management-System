package com.example.User.repositories;

import com.example.User.entities.UserEntity;
import com.example.User.models.User;
import org.springframework.data.repository.CrudRepository;
//Su dung UserEntity <UserEntity, Long>
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByUser(String user);
}
