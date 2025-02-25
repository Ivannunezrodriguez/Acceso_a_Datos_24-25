package com.ivan.libreria.repository;

import com.ivan.libreria.model.Libreria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibreriaRepository extends JpaRepository<Libreria, Long> {
}
