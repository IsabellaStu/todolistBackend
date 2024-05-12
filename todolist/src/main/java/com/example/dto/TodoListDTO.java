package com.example.dto;


import com.example.model.Elemento;

import java.util.List;

public class TodoListDTO {


    private Long id;

    private String nomeLista;

    List<Elemento> elementiInLista;

    public TodoListDTO (){

    }

    public TodoListDTO(Long id, String nomeLista, List<Elemento> elementiInLista) {
        this.id = id;
        this.nomeLista = nomeLista;
        this.elementiInLista = elementiInLista;
    }

    public TodoListDTO(String nomeLista, List<Elemento> elementiInLista) {
        this.nomeLista = nomeLista;
        this.elementiInLista = elementiInLista;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeLista() {
        return nomeLista;
    }


    public void setNomeLista(String nomeLista) {
        this.nomeLista = nomeLista;
    }

    public List<Elemento> getElementiInLista() {
        return elementiInLista;
    }

    public void setElementiInLista(List<Elemento> elementiInLista) {
        this.elementiInLista = elementiInLista;
    }

    @Override
    public String toString() {
        return "TodoListDTO{" +
                "id=" + id +
                ", nomeLista='" + nomeLista + '\'' +
                ", elementiInLista=" + elementiInLista +
                '}';
    }
}
