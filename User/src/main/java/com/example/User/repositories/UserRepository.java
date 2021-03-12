package com.example.User.repositories;

import com.example.User.entities.UserEntity;
//import com.example.User.models.User;
import com.example.User.models.User;
import org.springframework.data.repository.CrudRepository;
//Su dung UserEntity <UserEntity, Long>
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    //Note
    //Su dung tat ca lop Entity
    UserEntity findById(long id);
    UserEntity deleteById(long id);
    UserEntity save(User newUser);
    UserEntity findByUser(String user);
}
