package com.example.controller;

import com.example.model.Elemento;
import com.example.service.ElementoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/elemento")
public class ElementoController {

    private ElementoService elementoService;

    @Autowired
    public ElementoController(ElementoService elementoService) {
        this.elementoService = elementoService;
    }

    @PostMapping("/{nomeLista}")
    public Elemento addElemento(@RequestBody Elemento elemento, @PathVariable String nomeLista) {
    return elementoService.save(elemento, nomeLista);
    }
}
