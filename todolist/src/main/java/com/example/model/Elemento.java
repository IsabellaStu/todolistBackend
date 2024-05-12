package com.example.model;

import jakarta.persistence.*;

@Entity
public class Elemento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String name;
    @Column
    private boolean status;
    //@ManyToOne
    //@JoinColumn(name = "todo_list_id")
   // private TodoList todoList;
    public Elemento(){

    }

    public Elemento(long id, String name, boolean status, TodoList todoList) {
        this.id = id;
        this.name = name;
        this.status = status;
        //this.todoList = todoList;
    }

    public Elemento(String name, boolean status, TodoList todoList) {
        this.name = name;
        this.status = status;
       // this.todoList = todoList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

   // public TodoList getTodoList() {
    //    return todoList;
   // }

    //public void setTodoList(TodoList todoList) {
     //   this.todoList = todoList;
   // }

    @Override
    public String toString() {
        return "Elemento{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}
