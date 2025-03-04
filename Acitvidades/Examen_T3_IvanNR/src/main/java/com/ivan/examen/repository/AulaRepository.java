package com.ivan.examen.repository;

import com.ivan.examen.model.Aula;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AulaRepository extends JpaRepository<Aula, Long> {
    List<Aula> findByCapacidadGreaterThan(int capacidad);
}