package com.ivan.examen.controller;


import com.ivan.examen.model.Profesor;
import com.ivan.examen.service.ProfesorCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/profesor-curso")
class ProfesorCursoController {
    @Autowired
    private ProfesorCursoService profesorCursoService;

    @GetMapping("/profesores/curso/{idCurso}")
    public List<Profesor> getProfesoresByCurso(@PathVariable int idCurso) {
        return profesorCursoService.findProfesoresByCursoId(idCurso);
    }

    @GetMapping("/cursos/profesor/{idProfesor}")
    public List<String> getCursosByProfesor(@PathVariable int idProfesor) {
        return profesorCursoService.findCursosByProfesorId(idProfesor);
    }
}