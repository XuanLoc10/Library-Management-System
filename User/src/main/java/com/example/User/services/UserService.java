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
                //Tim cach viet khac
                //Su dung lamda
                .map((UserEntity entity) -> UserConverter.entity2Model(entity))
                //Su dung cach de hieu hon
                .collect(Collectors.toList());
    }

    //Kiem tra ma hoa password
    public User auth(UserEntity user) {
        UserEntity userEntity = userRepository.findByUser(user.getUser());
        if (userEntity != null && EncrytedPasswordUtils.isMatched(user.getPassword(), userEntity.getPassword())) {
            return UserConverter.entity2Model(userEntity);
        }
        return null;
    }


    public User signup(UserEntity user) {
        UserEntity userEntity = userRepository.findByUser(user.getUser());
        if (userEntity != null) {
            userEntity.setPassword(EncrytedPasswordUtils.encrytePassword(userEntity.getPassword()));
            UserEntity newUserEntity = userRepository.save(userEntity);
            return UserConverter.entity2Model(newUserEntity);
        }
        return null;
    }

    //Tim kiem User bang ID
    public User findById(long id) {
        //Chuyen doi UserEntity voi UserModel
        UserEntity entity = userRepository.findById(id);
        User user = UserConverter.entity2Model(entity);
        return user;
    }
    //Xoa User
    //Xoa User trong database
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public User save(User newUser) {
        UserEntity entity = userRepository.save(newUser);
        User user = UserConverter.entity2Model(entity);
        return user;
    }
}