package com.ivan.examen.service;

import com.ivan.examen.model.Curso;

public interface CursoService {
    Curso findByAulaId(int idAula);
}