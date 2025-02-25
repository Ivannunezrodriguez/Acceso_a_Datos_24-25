package com.ivan.libreria.controller;

import com.ivan.libreria.model.Autor;
import com.ivan.libreria.model.Editorial;
import com.ivan.libreria.model.Libreria;
import com.ivan.libreria.model.Libro;
import com.ivan.libreria.repository.AutorRepository;
import com.ivan.libreria.repository.EditorialRepository;
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
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private EditorialRepository editorialRepository;

    @GetMapping("error")
    public String error() {
        return "Error en la aplicación";
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Libro>> getAllLibros() {
        List<Libro> libros = libroService.getAllLibros();
        return new ResponseEntity<>(libros, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addLibro(@RequestBody Libro libro) {
        // Verificar que los datos sean válidos
        if (libro.getLibreria() == null || libro.getLibreria().getId() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: Librería no puede ser NULL");
        }
        if (libro.getAutor() == null || libro.getAutor().getId() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: Autor no puede ser NULL");
        }
        if (libro.getEditorial() == null || libro.getEditorial().getId() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: Editorial no puede ser NULL");
        }

        // Buscar los objetos en la base de datos
        Libreria libreria = libreriaRepository.findById(libro.getLibreria().getId())
                .orElseThrow(() -> new RuntimeException("Librería no encontrada"));

        Autor autor = autorRepository.findById(libro.getAutor().getId())
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));

        Editorial editorial = editorialRepository.findById(libro.getEditorial().getId())
                .orElseThrow(() -> new RuntimeException("Editorial no encontrada"));

        // Asignar relaciones
        libro.setLibreria(libreria);
        libro.setAutor(autor);
        libro.setEditorial(editorial);

        libroService.agregarLibro(libro);
        return ResponseEntity.status(HttpStatus.CREATED).body("Libro agregado: " + libro.getTitulo());
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