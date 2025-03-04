package com.ivan.examen.service;

import com.ivan.examen.model.Curso;
import java.util.List;

public interface CursoService {

    Curso findByAulaId(Long idAula);
}