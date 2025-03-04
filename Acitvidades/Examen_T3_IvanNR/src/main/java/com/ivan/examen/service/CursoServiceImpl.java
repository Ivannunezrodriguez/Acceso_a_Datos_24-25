package com.ivan.examen.service;

import com.ivan.examen.model.Curso;
import com.ivan.examen.repository.CursoRepository;
import com.ivan.examen.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;



    @Override
    public Curso findByAulaId(Long idAula) {
        return cursoRepository.findByAulaId(idAula);
    }
}