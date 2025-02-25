package com.ivan.libreria.controller;

import com.ivan.libreria.model.Libro;
import com.ivan.libreria.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libro")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping("error")
    public String error() {
        return "Error en la aplicación";
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Libro>> getAllLibros() {
        List<Libro> libros = libroService.getAllLibros();
        return new ResponseEntity<>(libros, HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<String> addLibro(@RequestBody Libro libro) {
        libroService.agregarLibro(libro);
        return new ResponseEntity<>("Libro agregado: " + libro.getTitulo(), HttpStatus.CREATED);
    }
}