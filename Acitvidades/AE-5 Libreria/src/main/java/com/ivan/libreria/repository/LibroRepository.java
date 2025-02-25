package com.ivan.libreria.repository;

import com.ivan.libreria.model.Libreria;
import com.ivan.libreria.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    List<Libro> findByLibreria(Libreria libreria);


}
