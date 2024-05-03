package com.example.service;

import com.example.dto.CredenzialiDto;
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

    public CredenzialiDto editUsername(String username, String nuovoUsername) {
        Optional<Credenziali> optionalCredenziali = credenzialiRepository.findByUsername(username);
        if (optionalCredenziali.isPresent()) {
            Credenziali credenziali = optionalCredenziali.get();
            credenziali.setUsername(nuovoUsername);
            credenzialiRepository.save(credenziali);
            CredenzialiDto convertiCredInDto = Converter.convertCredenzialiDto(credenziali);
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
}
