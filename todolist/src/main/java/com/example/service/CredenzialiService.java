package com.example.service;

import com.example.dto.CredenzialiDTO;
import com.example.dto.conversione.Converter;
import com.example.model.Credenziali;
import com.example.repository.CredenzialiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CredenzialiService {

    private CredenzialiRepository credenzialiRepository;

    public CredenzialiService() {

    }

    @Autowired
    public CredenzialiService(CredenzialiRepository credenzialiRepository) {
        this.credenzialiRepository = credenzialiRepository;
    }

    public CredenzialiDTO editUsername(String username, String nuovoUsername) {
        Optional<Credenziali> optionalCredenziali = credenzialiRepository.findByUsername(username);
        if (optionalCredenziali.isPresent()) {
            Credenziali credenziali = optionalCredenziali.get();
            credenziali.setUsername(nuovoUsername);
            credenzialiRepository.save(credenziali);
            CredenzialiDTO convertiCredInDto = Converter.convertCredenzialiDto(credenziali);
            return convertiCredInDto;
        }
        return null;
    }

    public Credenziali editPassword(String username, String password, String nuovoPassword) {
        Optional<Credenziali>optionalCredenziali = credenzialiRepository.findByPassword(password);
        Optional<Credenziali>optionalCredenzialiUsername = credenzialiRepository.findByUsername(username);
        if (optionalCredenziali.isPresent() && optionalCredenzialiUsername.isPresent()) {
            Credenziali credenziali = optionalCredenziali.get();
            credenziali.setPassword(nuovoPassword);
            return credenzialiRepository.save(credenziali);
        }
        return null;
    }

    public boolean authenticate(String username, String password) {
        Optional<Credenziali>usernameCredenziali = credenzialiRepository.findByUsername(username);
        return usernameCredenziali.isPresent() && usernameCredenziali.get().getPassword().equals(password);
    }
}
