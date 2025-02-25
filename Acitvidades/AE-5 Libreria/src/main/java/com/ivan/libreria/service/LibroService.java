package com.ivan.libreria.service;

import com.ivan.libreria.model.Libro;
import java.util.List;

public interface LibroService {
    Libro agregarLibro(Libro libro);
    List<Libro> getAllLibros();
}
