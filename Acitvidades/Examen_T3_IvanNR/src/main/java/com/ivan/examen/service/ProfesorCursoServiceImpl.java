package com.ivan.examen.service;

import com.ivan.examen.model.Profesor;
import com.ivan.examen.model.ProfesorCurso;
import com.ivan.examen.repository.ProfesorCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfesorCursoServiceImpl implements ProfesorCursoService {

    @Autowired
    private ProfesorCursoRepository profesorCursoRepository;

    @Override
    public List<Profesor> findProfesoresByCursoId(int idCurso) {
        return profesorCursoRepository.findByCursoId(idCurso)
                .stream()
                .map(ProfesorCurso::getProfesor)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findCursosByProfesorId(int idProfesor) {
        return profesorCursoRepository.findByProfesorId(idProfesor)
                .stream()
                .map(pc -> pc.getCurso().getNombre())
                .collect(Collectors.toList());
    }
}