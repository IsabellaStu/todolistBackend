package com.example.dto.conversione;

import com.example.dto.CredenzialiDTO;
import com.example.dto.TodoListDTO;
import com.example.dto.UserDTO;
import com.example.model.Credenziali;
import com.example.model.TodoList;
import com.example.model.User;

public class Converter {

    public static UserDTO convertUserDto(User user) {
        UserDTO userDto = new UserDTO();
        userDto.setId(user.getId());
        userDto.setNome(user.getNome());
        userDto.setCognome(user.getCognome());
        userDto.setEmail(user.getEmail());
        userDto.setTodoListList(user.getTodoListList());
        return userDto;
    }

    public static CredenzialiDTO convertCredenzialiDto(Credenziali credenziali) {
        CredenzialiDTO credDto = new CredenzialiDTO();
        credDto.setId(credenziali.getId());
        credDto.setUsername(credenziali.getUsername());
        return credDto;
    }

    public static TodoListDTO convertTodoListDto(TodoList todoList) {
        TodoListDTO todoListDto = new TodoListDTO();
        todoListDto.setId(todoList.getId());
        todoListDto.setNomeLista(todoList.getNomeLista());
        todoList.setElementiInLista(todoList.getElementiInLista());
        return todoListDto;
    }
}
