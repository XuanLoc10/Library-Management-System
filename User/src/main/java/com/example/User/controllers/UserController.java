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

//@Controller
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //@PostMapping("/auth")
    @RequestMapping(value = "/auth",method = RequestMethod.POST)
    public @ResponseBody
    User auth(@RequestBody UserEntity user) {
        return userService.auth(user);
    }

    @RequestMapping(value = "/signup",method = RequestMethod.POST)
    public @ResponseBody
    User signup(@RequestBody UserEntity user) {
        return userService.signup(user);
    }

    //API để truyền thông tin user cho service library
    @GetMapping(value ="/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAll() {
        return userService.getAll();
    }



    @GetMapping(value = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User one(@PathVariable Long id) {
        return userService.findById(id);
                //.orElseThrow(() -> new EmployeeNotFoundException(id));
    }
    //Xoa
    @GetMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
    }


    @PostMapping("/new")
    public User newUser(@RequestBody User newUser) {
        return userService.save(newUser);
    }

    /*
    @GetMapping("/edit/{id}")
    public User editUser(@RequestBody User editUser, @PathVariable Long id) {
        return userService.findById(id)
                .map(user -> {
                    user.setFirstName(editUser.getFirstName());
                    user.
                    employee.setRole(editUser.getRole());
                    return userService.save(editUser);
                })
                .orElseGet(() -> {
                    editUser.setId(id);
                    return userService.save(editUser);
                });
    }
    */
}