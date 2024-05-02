package com.example.service;

import com.example.dto.conversione.Converter;
import com.example.dto.UserDto;
import com.example.model.Credenziali;
import com.example.model.User;
import com.example.repository.CredenzialiRepository;
import com.example.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        String email = user.getEmail();
        if(credeRepo.findByUsername(username).isEmpty() && userRepo.findByEmail(email).isEmpty()){
            credeRepo.save(user.getCredenziali());
            System.out.println("salvato");
        return userRepo.save(user);

        }
        System.out.print("non salvato");
        return null;
    }

    public UserDto findByname(String nome){
        Optional<User> userOptional = userRepo.findByNome(nome);
        if(userOptional.isPresent()){
            User user = userOptional.get();
           UserDto userDto = Converter.convertUserDto(user);
            return userDto;
        }
        return null;
    }


    @Transactional
    public void deleteUser(String username, String email, String password) {
        try {
            Optional<Credenziali> usernameOptional = credeRepo.findByUsername(username);
            Optional<User> userOptional = userRepo.findByEmail(email);

            if (userOptional.isPresent() && usernameOptional.isPresent()) {
                User user = userOptional.get();
                Credenziali credenziali = usernameOptional.get();

                if (password.equals(credenziali.getPassword()) && user.getEmail().equals(email)) {
                    userRepo.deleteById(user.getId());
                    credeRepo.deleteByUsernameAndPassword(username, password);

                    System.out.println("eliminate");
                } else {
                    System.out.println("i dati non corrispondono");
                }
            } else {
                System.out.println("non trovato");
            }
        } catch (Exception e) {
            System.out.println("Errore ");
            e.printStackTrace();
        }
    }

}
