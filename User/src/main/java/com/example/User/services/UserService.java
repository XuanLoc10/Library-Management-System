package com.example.User.services;

import com.example.User.converter.UserConverter;
import com.example.User.entities.UserEntity;
import com.example.User.models.User;
import com.example.User.repositories.UserRepository;
import com.example.User.utils.EncrytedPasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return StreamSupport
                .stream(userRepository.findAll().spliterator(), false)
                //.map(UserConverter::entity2Model)
                .map((UserEntity entity) -> UserConverter.entity2Model(entity))
                .collect(Collectors.toList());
    }

    public User auth(UserEntity user) {
        UserEntity userEntity = userRepository.findByUser(user.getUser());
        if (userEntity != null && EncrytedPasswordUtils.isMatched(user.getPassword(), userEntity.getPassword())) {
            return UserConverter.entity2Model(userEntity);
        }
        return null;
    }


    public User signup(UserEntity user) {
        UserEntity userEntity = userRepository.findByUser(user.getUser());
        if (userEntity == null) {
            user.setPassword(EncrytedPasswordUtils.encrytePassword(user.getPassword()));
            userEntity = userRepository.save(user);
            return UserConverter.entity2Model(userEntity);
        }
        return null;
    }

    public User findById(long id) {
        //Chuyen doi UserEntity voi UserModel
        UserEntity entity = userRepository.findById(id).get();
        User user = UserConverter.entity2Model(entity);
        return user;
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public User saveUser(UserEntity user) {
        UserEntity userEntity = userRepository.findById(user.getId()).get();
        if (userEntity != null) {
            userEntity = userRepository.save(user);
            return UserConverter.entity2Model(userEntity);
        }
        return null;
    }

}