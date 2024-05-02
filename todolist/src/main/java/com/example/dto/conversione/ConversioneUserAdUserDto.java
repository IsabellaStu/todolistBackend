package com.example.dto.conversione;

import com.example.dto.UserDto;
import com.example.model.User;

public class ConversioneUserAdUserDto {

    public static UserDto convertUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setNome(user.getNome());
        userDto.setCognome(user.getCognome());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
