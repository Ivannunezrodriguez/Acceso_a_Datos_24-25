package com.ivan.examen.repository;

import com.ivan.examen.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    Curso findByAulaId(Long idAula);

    List<Curso> findByProfesores_Id(Long idProfesor);
}