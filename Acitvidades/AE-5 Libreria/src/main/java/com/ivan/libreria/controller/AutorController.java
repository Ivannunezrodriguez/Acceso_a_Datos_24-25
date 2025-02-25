package com.ivan.libreria.controller;

import com.ivan.libreria.model.Autor;
import com.ivan.libreria.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping("error")
    public String error(){
        return "Error en la aplicación";
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Autor>> getAllAutores(){
        return new ResponseEntity<>(autorService.getAllAutores(), HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<String> addAutor(@RequestBody Autor autor){
        autorService.agregarAutor(autor);
        return new ResponseEntity<>("Autor agregado: " + autor.getNombre(), HttpStatus.CREATED);
    }
}
