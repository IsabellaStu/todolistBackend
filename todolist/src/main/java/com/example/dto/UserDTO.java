package com.example.dto;


import com.example.model.TodoList;

import java.util.List;

public class UserDTO {
    private long id;

    private String nome;

    private String cognome;

    private String email;

    private List<TodoList> todoListList;

    public UserDTO(long id, String nome, String cognome, String email, List<TodoList> todoListList) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.todoListList = todoListList;
    }

    public UserDTO(String nome, String cognome, String email, List<TodoList> todoListList) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.todoListList = todoListList;
    }

    public UserDTO(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<TodoList> getTodoListList() {
        return todoListList;
    }

    public void setTodoListList(List<TodoList> todoListList) {
        this.todoListList = todoListList;
    }
}
