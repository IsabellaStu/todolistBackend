package com.example.service;

import com.example.dto.conversione.Converter;
import com.example.dto.UserDTO;
import com.example.model.Credenziali;
import com.example.model.TodoList;
import com.example.model.User;
import com.example.repository.CredenzialiRepository;
import com.example.repository.TodoListRepository;
import com.example.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    private UserRepository userRepo;
    private CredenzialiRepository credeRepo;
    private TodoListRepository todoListRepo;


    @Autowired
    public UserService(UserRepository userRepo, CredenzialiRepository credeRepo, TodoListRepository todoListRepo) {
        this.userRepo = userRepo;
        this.credeRepo = credeRepo;
        this.todoListRepo = todoListRepo;
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

    public List<UserDTO> getAllUsers() {
        List<User> users = userRepo.findAll();
        List<UserDTO> userDtos = new ArrayList<>();
        for (User user : users) {
            userDtos.add(Converter.convertUserDto(user));
        }
       return userDtos;
    }


    public UserDTO editEmail(String email, String nuovaEmail){
        Optional<User>userOptional = userRepo.findByEmail(email);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            user.setEmail(nuovaEmail);
            userRepo.save(user);
            UserDTO userDto = Converter.convertUserDto(user);
            return userDto;
        }
        return null;
    }
    public Optional<UserDTO> findByname(String nome){
        Optional<User> userOptional = userRepo.findByNome(nome);
        if(userOptional.isPresent()){
            User user = userOptional.get();
           UserDTO userDto = Converter.convertUserDto(user);
            return Optional.of(userDto);
        }
        return Optional.empty();
    }




    public void deleteUser(String username, String email, String password) {
        try {
            Optional<Credenziali> credenzialiOptional = credeRepo.findByUsername(username);
            Optional<User> userOptional = userRepo.findByEmail(email);

            if (userOptional.isPresent() && credenzialiOptional.isPresent()) {
                User user = userOptional.get();
                Credenziali credenziali = credenzialiOptional.get();

                // Verifica se le credenziali corrispondono
                if (password.equals(credenziali.getPassword()) && user.getEmail().equals(email)) {
                    todoListRepo.deleteAll(user.getTodoListList());
                    // Elimina le credenziali e l'utente
                    credeRepo.delete(credenziali);
                    userRepo.delete(user);

                    System.out.println("Utente eliminato con successo.");
                } else {
                    System.out.println("Le credenziali non corrispondono.");
                }
            } else {
                System.out.println("Utente non trovato.");
            }
        } catch (Exception e) {
            System.out.println("Si è verificato un errore durante l'eliminazione dell'utente.");
            e.printStackTrace();
        }
    }


}
