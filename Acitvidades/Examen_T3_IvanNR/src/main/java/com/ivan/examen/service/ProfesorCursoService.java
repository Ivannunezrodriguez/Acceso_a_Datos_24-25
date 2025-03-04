package com.ivan.examen.service;

import com.ivan.examen.model.Profesor;
import java.util.List;

public interface ProfesorCursoService {
    List<Profesor> findProfesoresByCursoId(Long idCurso);
    List<String> findCursosByProfesorId(Long idProfesor);
}