package com.ivan.examen.service;

import com.ivan.examen.model.Profesor;
import com.ivan.examen.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorServiceImpl implements ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;


    @Override
    public Profesor save(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    @Override
    public List<Profesor> findByCursoId(Long idCurso) {
        return profesorRepository.findByCursos_Id(idCurso);
    }

}