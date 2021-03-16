package com.example.User.controllers;

import com.example.User.entities.UserEntity;
import com.example.User.models.User;

import com.example.User.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value ="/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAll() {
        return userService.getAll();
    }

    @RequestMapping(value = "/auth",method = RequestMethod.POST)
    public @ResponseBody
    User auth(@RequestBody UserEntity user) {
        return userService.auth(user);
    }

    @PostMapping(value = "/signup",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public @ResponseBody
    User signup(UserEntity user) {
        return userService.signup(user);
    }

    @GetMapping(value = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User one(@PathVariable Long id) {
        return userService.findById(id);
    }
    //Xoa
    @GetMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
    }
}
