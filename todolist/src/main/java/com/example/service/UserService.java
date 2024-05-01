package com.example.service;

import com.example.model.User;
import com.example.repository.CredenzialiRepository;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    private UserRepository userRepo;
    private CredenzialiRepository credeRepo;



    @Autowired
    public UserService(UserRepository userRepo, CredenzialiRepository credeRepo) {
        this.userRepo = userRepo;
        this.credeRepo = credeRepo;
    }

    public User addUser(User user){
        String username = user.getCredenziali().getUsername();
        if(credeRepo.findByUsername(username) == null){
            credeRepo.save(user.getCredenziali());
            System.out.println("andato");
        return userRepo.save(user);

        }
        System.out.print("non andato");
        return null;
    }
}
