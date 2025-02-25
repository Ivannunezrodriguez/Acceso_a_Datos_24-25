package com.ivan.libreria.service;

import com.ivan.libreria.model.Libro;
import com.ivan.libreria.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroServiceImp implements LibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Override
    public Libro agregarLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public List<Libro> getAllLibros() {
        return libroRepository.findAll();
    }
}
