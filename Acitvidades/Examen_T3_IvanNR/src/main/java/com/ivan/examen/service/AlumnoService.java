package com.ivan.examen.service;

import com.ivan.examen.model.Alumno;
import java.util.List;

public interface AlumnoService {
    List<Alumno> findAll();

    Alumno save(Alumno alumno);

    List<Alumno> findByCursoId(Long idCurso);
}