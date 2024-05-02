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

    public Elemento(){

    }

    public Elemento(long id, String name, boolean status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public Elemento(String name, boolean status) {
        this.name = name;
        this.status = status;
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
}
