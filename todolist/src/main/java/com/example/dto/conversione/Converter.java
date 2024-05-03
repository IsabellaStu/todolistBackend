package com.example.dto.conversione;

import com.example.dto.CredenzialiDto;
import com.example.dto.UserDto;
import com.example.model.Credenziali;
import com.example.model.User;

public class Converter {

    public static UserDto convertUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setNome(user.getNome());
        userDto.setCognome(user.getCognome());
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    public static CredenzialiDto convertCredenzialiDto(Credenziali credenziali) {
        CredenzialiDto credDto = new CredenzialiDto();
        credDto.setId(credenziali.getId());
        credDto.setUsername(credenziali.getUsername());
        return credDto;
    }
}
