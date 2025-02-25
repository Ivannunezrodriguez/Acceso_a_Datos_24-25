package com.ivan.libreria.repository;

import com.ivan.libreria.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {
   List<Autor> getAllAutores();

}
