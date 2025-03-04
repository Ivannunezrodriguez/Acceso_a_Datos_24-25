package com.ivan.examen.service;

import com.ivan.examen.model.Profesor;

import java.util.List;

public interface ProfesorService {

    Profesor save(Profesor profesor);

    List<Profesor> findByCursoId(Long idCurso);
}

