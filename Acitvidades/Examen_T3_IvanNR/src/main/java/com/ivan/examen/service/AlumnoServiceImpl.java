package com.ivan.examen.service;

import com.ivan.examen.model.Alumno;
import com.ivan.examen.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Override
    public List<Alumno> findAll() {
        return alumnoRepository.findAll();
    }

    @Override
    public Alumno findById(int id) {
        return alumnoRepository.findById(id).orElse(null);
    }

    @Override
    public Alumno save(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    @Override
    public void deleteById(int id) {
        alumnoRepository.deleteById(id);
    }

    @Override
    public List<Alumno> findByCursoId(int id_Curso) {
        return alumnoRepository.findByCurso_Id_curso(id_Curso);
    }



    }
