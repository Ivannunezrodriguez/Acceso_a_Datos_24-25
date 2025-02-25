package com.ivan.libreria.controller;

import com.ivan.libreria.model.Libreria;
import com.ivan.libreria.model.Libro;
import com.ivan.libreria.repository.LibreriaRepository;
import com.ivan.libreria.repository.LibroRepository;
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
    @Autowired
    private LibroRepository libroRepository;
    @Autowired
    private LibreriaRepository libreriaRepository;

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
    @GetMapping("/byLibreria/{libreriaId}")
    public ResponseEntity<List<Libro>> getLibrosByLibreria(@PathVariable Long libreriaId) {
        Libreria libreria = libreriaRepository.findById(libreriaId)
                .orElseThrow(() -> new RuntimeException("Librería no encontrada"));

        List<Libro> libros = libroRepository.findByLibreria(libreria);

        if (libros.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(libros);
    }


}