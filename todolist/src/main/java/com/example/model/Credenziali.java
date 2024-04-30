package com.example.model;

import jakarta.persistence.*;

@Entity
public class Credenziali {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String username;
    @Column
    private String password;


}
