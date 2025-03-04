package com.ivan.examen.repository;

import com.ivan.examen.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    Curso findByAulaId(Long idAula);
}