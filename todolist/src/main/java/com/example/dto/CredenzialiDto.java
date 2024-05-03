package com.example.dto;

import jakarta.persistence.Column;

public class CredenzialiDto {

    private long id;
    private String username;

    public CredenzialiDto() {

    }

    public CredenzialiDto(long id, String username) {
        this.id = id;
        this.username = username;
    }

    public CredenzialiDto(String username) {
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
