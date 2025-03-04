package com.ivan.examen.repository;

import com.ivan.examen.model.ProfesorCurso;
import com.ivan.examen.model.ProfesorCursoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfesorCursoRepository extends JpaRepository<ProfesorCurso, ProfesorCursoId> {
    List<ProfesorCurso> findByProfesorId(Long idProfesor);
    List<ProfesorCurso> findByCursoId(Long idCurso);
}
