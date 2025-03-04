package com.ivan.examen.repository;

import com.ivan.examen.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
    List<Profesor> findByCursos_Id(Long idCurso);
}