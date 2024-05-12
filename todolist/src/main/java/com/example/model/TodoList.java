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
    @ManyToOne
    private User user;
    @OneToMany(cascade = CascadeType.ALL)
    List<Elemento> elementiInLista;

public TodoList(){

}

    public TodoList(Long id, String nomeLista, User user, List<Elemento> elementiInLista) {
        this.id = id;
        this.nomeLista = nomeLista;
        this.user = user;
        this.elementiInLista = elementiInLista;
    }

    public TodoList(String nomeLista, User user, List<Elemento> elementiInLista) {
        this.nomeLista = nomeLista;
        this.user = user;
        this.elementiInLista = elementiInLista;
    }

    public void addElemento(Elemento elemento){
    this.elementiInLista.add(elemento);
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "TodoList{" +
                "id=" + id +
                ", nomeLista='" + nomeLista + '\'' +
                ", user=" + user +
                ", elementiInLista=" + elementiInLista +
                '}';
    }
}
