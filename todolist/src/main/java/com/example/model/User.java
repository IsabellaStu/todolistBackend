package com.example.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String nome;
    @Column
    private String cognome;
    @Column
    private String email;
    @OneToOne
    Credenziali credenziali;
    @OneToMany
    private List<TodoList> todoListList;
    public User(){

    }

    public User(long id, String nome, String cognome, String email, Credenziali credenziali, List<TodoList> todoListList) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.credenziali = credenziali;
        this.todoListList = todoListList;
    }

    public User(String nome, String cognome, String email, Credenziali credenziali, List<TodoList> todoListList) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.credenziali = credenziali;
        this.todoListList = todoListList;
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

    public Credenziali getCredenziali() {
        return credenziali;
    }

    public void setCredenziali(Credenziali credenziali) {
        this.credenziali = credenziali;
    }

    public List<TodoList> getTodoListList() {
        return todoListList;
    }

    public void setTodoListList(List<TodoList> todoListList) {
        this.todoListList = todoListList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", credenziali=" + credenziali +
                ", todoListList=" + todoListList +
                '}';
    }
}
