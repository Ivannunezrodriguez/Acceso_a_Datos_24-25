package com.ivan.examen.repository;

import com.examen_ad.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlumnoRepository extends JpaRepository<Aula, Integer> {
    List<Aula> findByCapacidadGreaterThan(int capacidad);
}