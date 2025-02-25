package com.ivan.libreria.controller;

import com.ivan.libreria.model.Libreria;
import com.ivan.libreria.service.LibreriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libreria")
public class LibreriaController {

    @Autowired
    private LibreriaService libreriaService;

    @GetMapping("error")
    public String error() {
        return "Error en la aplicación";
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Libreria>> getAllLibrerias() {
        List<Libreria> librerias = libreriaService.getAllLibrerias();
        return new ResponseEntity<>(librerias, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addLibreria(@RequestBody Libreria libreria) {
        libreriaService.agregarLibreria(libreria);
        return new ResponseEntity<>("Librería agregada: " + libreria.getNombre(), HttpStatus.CREATED);
    }


}