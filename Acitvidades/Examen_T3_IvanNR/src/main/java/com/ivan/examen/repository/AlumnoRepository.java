package com.ivan.examen.repository;

import com.ivan.examen.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
    List<Alumno> findByCursoId(Long idCurso);
}