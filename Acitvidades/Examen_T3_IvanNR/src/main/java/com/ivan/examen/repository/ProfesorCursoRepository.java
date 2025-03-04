package com.ivan.examen.repository;

import com.ivan.examen.model.ProfesorCurso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfesorCursoRepository extends JpaRepository<ProfesorCurso, Integer> {
    List<ProfesorCurso> findByCursoId(int idCurso);
    List<ProfesorCurso> findByProfesorId(int idProfesor);
}