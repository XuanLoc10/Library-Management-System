package com.example.User.converter;

import com.example.User.entities.UserEntity;
import com.example.User.models.User;

public class UserConverter {

    public static UserEntity model2Entity(User u) {
        UserEntity entity = new UserEntity();
        //Su dung phuong thuc set, get AbstractBaseEntity
        entity.setId(u.getId());
        entity.setFirstName(u.getFirstName());
        entity.setLastName(u.getLastName());
        entity.setRole(u.getRole());

        entity.setEmail(u.getEmail());
        entity.setPhone(u.getPhone());
        entity.setAddress(u.getAddress());
        //entity.setId(u.getId());
        //entity.setName(u.getName());
        //entity.setEmail(u.getEmail());
        return entity;
    }

    public static User entity2Model(UserEntity entity) {
        User u = new User();
        u.setId(entity.getId());
        u.setFirstName(entity.getFirstName());
        u.setLastName(entity.getLastName());
        u.setRole(entity.getRole());
        u.setEmail(entity.getEmail());
        u.setPhone(entity.getPhone());
        u.setAddress(entity.getAddress());
        return u;
    }
}
