package com.example.User.controller;


import com.example.User.Entity.User;

import com.example.User.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(path="/user")
public class UserController {
    @Autowired
    private Environment env;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public String home() {
        // This is useful for debugging
        // When having multiple instance of image service running at different ports. // We load balance among them, and display which instance received the request.
        return "index";
                //"Hello from Image Service running at port: " + env.getProperty("local.server.port");
    }

    @RequestMapping("/users")
    public List<User> getUsers() {

        List<User> users = Arrays.asList(
                //new User(1, "123456", "Hoang", "Tran", "jindo@gamil.com","0911.231.135", "Tp. Ho Chi Minh"),
                //new User(2, "1111", "Tuyet", "Pham", "tuyetph@gmail.com", "0985.987.456", "BInh Duong")
                );
        return users;
    }
    /*
    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody
    String addNewUser (@RequestParam Integer userId, @RequestParam String password,
                       @RequestParam String firstName, @RequestParam String lastName, @RequestParam String role, @RequestParam String email,
                       @RequestParam String phone, @RequestParam String address) {

        User n = new User();
        n.setUserId(userId);
        n.setPassword(password);
        n.setFirstName(firstName);
        n.setLastName(lastName);
        n.setRole(role);
        n.setEmail(email);
        n.setPhone(phone);
        n.setAddress(address);

        userRepository.save(n);
        return "Saved";
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

     */
}