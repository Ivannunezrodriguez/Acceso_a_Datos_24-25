package com.ivan.examen.service;

import com.ivan.examen.model.Alumno;

import java.util.List;

public interface AlumnoService {
    List<Alumno> findAll();

    Alumno findById(int id);

    Alumno save(Alumno alumno);

    void deleteById(int id);

    List<Alumno> findByCursoId(int idCurso);
}