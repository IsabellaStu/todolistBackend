package com.example.controller;

import com.example.dto.UserDto;
import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping("/findByName/{nome}")
    public UserDto findByName(@PathVariable String nome){
       return userService.findByname(nome);
    }

    @DeleteMapping ("delete/{username}/{email}/{password}")
    public ResponseEntity<String> deleteByUsername(@PathVariable String username, @PathVariable String email,@PathVariable String password){
        userService.deleteUser(username, email, password);
        return ResponseEntity.ok("eliminato");
    }
}
