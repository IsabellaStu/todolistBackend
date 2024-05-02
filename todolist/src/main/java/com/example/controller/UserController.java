package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User saveUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @DeleteMapping ("delete/{username}/{email}/{password}")
    public ResponseEntity<String> deleteByUsername(@PathVariable String username, @PathVariable String email,@PathVariable String password){
        userService.deleteByUsername(username, email, password);
        return ResponseEntity.ok("eliminato");
    }
}
