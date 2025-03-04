package com.ivan.examen.service;

import com.ivan.examen.model.Profesor;

import java.util.List;

public interface ProfesorCursoService {
    List<Profesor> findProfesoresByCursoId(int idCurso);

    List<String> findCursosByProfesorId(int idProfesor);
}