package com.example.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class TodoList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String nomeLista;
    @OneToMany
    List<Elemento> elementiInLista;

public TodoList(){

}

    public TodoList(Long id, String nomeLista, List<Elemento> elementiInLista) {
        this.id = id;
        this.nomeLista = nomeLista;
        this.elementiInLista = elementiInLista;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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
        return "TodoList{" +
                "id=" + id +
                ", nomeLista='" + nomeLista + '\'' +
                ", elementiInLista=" + elementiInLista +
                '}';
    }
}
