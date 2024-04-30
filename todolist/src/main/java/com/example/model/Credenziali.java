package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Credenziali {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


}
