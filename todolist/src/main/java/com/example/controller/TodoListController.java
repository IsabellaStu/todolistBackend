package com.example.controller;

import com.example.dto.TodoListDTO;
import com.example.model.TodoList;
import com.example.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todolist")
public class TodoListController {

    private TodoListService todoListService;

    @Autowired
    public TodoListController(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    @PostMapping("/{username}")
    public TodoListDTO addTodoListUser(@PathVariable String username, @RequestBody TodoList todoList) {
        return todoListService.AddTodoListUser(todoList, username);
    }
}
