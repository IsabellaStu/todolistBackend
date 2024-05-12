package com.example.dto;

public class CredenzialiDTO {

    private long id;
    private String username;

    public CredenzialiDTO() {

    }

    public CredenzialiDTO(long id, String username) {
        this.id = id;
        this.username = username;
    }

    public CredenzialiDTO(String username) {
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
