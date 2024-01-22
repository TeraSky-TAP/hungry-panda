//package org.example.hungry_panda.controllers;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import org.example.hungry_panda.model.User;
//import org.example.hungry_panda.repository.UserRepository;
//
//@RestController
//public class UserController {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @PostMapping("/register")
//    public User registerUser(@RequestParam String username) {
//        User user = new User();
//        user.setUsername(username);
//        return userRepository.save(user);
//    }
//}
