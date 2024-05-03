package com.example.controller;

import com.example.dto.CredenzialiDto;
import com.example.model.Credenziali;
import com.example.service.CredenzialiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/credenziali")
public class CredenzialiController {

    private CredenzialiService credenzialiService;

    @Autowired
    public CredenzialiController(CredenzialiService credenzialiService) {
        this.credenzialiService = credenzialiService;
    }

    @PutMapping("editUsername/{username}/{nuovoUsername}")
    public CredenzialiDto updateUser(@PathVariable String username, @PathVariable String nuovoUsername){
        return credenzialiService.editUsername(username, nuovoUsername);
    }

    @PutMapping("editPassword/{username}/{password}/{nuovaPassword}")
    public Credenziali editPassword(@PathVariable String username, @PathVariable String password, @PathVariable String nuovaPassword){
        return credenzialiService.editPassword(username, password, nuovaPassword);
    }
}
