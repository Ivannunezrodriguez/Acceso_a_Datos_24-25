package com.ivan.examen.service;

import com.ivan.examen.model.Curso;
import com.ivan.examen.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public Curso findByAulaId(int idAula) {
        return cursoRepository.findByAulaId(idAula);
    }
}