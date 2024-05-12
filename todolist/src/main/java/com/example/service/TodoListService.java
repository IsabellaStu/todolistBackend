package com.example.service;

import com.example.dto.TodoListDTO;
import com.example.dto.conversione.Converter;
import com.example.model.TodoList;
import com.example.model.User;
import com.example.repository.CredenzialiRepository;
import com.example.repository.TodoListRepository;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoListService {

    private TodoListRepository todoListRepository;
    private UserRepository userRepository;
    private CredenzialiRepository credenzialiRepository;


    @Autowired
    public TodoListService(TodoListRepository todoListRepository, UserRepository userRepository, CredenzialiRepository credenzialiRepository) {
        this.todoListRepository = todoListRepository;
        this.userRepository = userRepository;
        this.credenzialiRepository = credenzialiRepository;
    }

    public TodoList createTodoList(TodoList todoList) {
       return todoListRepository.save(todoList);
    }

    public Optional<TodoList> getTodoList(Long id) {
        Optional<TodoList> optionalTodoList = todoListRepository.findById(id);
        if (optionalTodoList.isPresent()) {
            return Optional.of(optionalTodoList.get());

        }
        return Optional.empty();
    }

    public TodoListDTO AddTodoListUser(TodoList todoList, String email) {
        Optional<User> emailOptional = userRepository.findByEmail(email);
        TodoList todoListSave = null;
    if (emailOptional.isPresent()){
        User user = emailOptional.get();
        if(todoList.getNomeLista()!= null){
            user.addListUser(todoList);
            todoList.setUser(user);
             todoListSave = todoListRepository.save(todoList);
            userRepository.save(user);

        }
        return Converter.convertTodoListDto(todoListSave);
    }
    return null;
    }




}
