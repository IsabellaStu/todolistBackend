package com.example.service;

import com.example.model.Elemento;
import com.example.model.TodoList;
import com.example.repository.ElementoRepository;
import com.example.repository.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ElementoService {

private ElementoRepository elementoRepository;
private TodoListRepository todoListRepository;

@Autowired
public ElementoService(ElementoRepository elementoRepository, TodoListRepository todoListRepository) {
    this.elementoRepository = elementoRepository;
    this.todoListRepository = todoListRepository;
}

public Elemento save(Elemento elemento, String nomeList) {
    Optional<TodoList> nomeLista = todoListRepository.findByNomeLista(nomeList);

    if(nomeLista.isPresent()){
        TodoList todoList = nomeLista.get();
        todoList.addElemento(elemento);
        elementoRepository.save(elemento);
        todoListRepository.save(todoList);
        return elemento;
    }
    return null;
}











}
