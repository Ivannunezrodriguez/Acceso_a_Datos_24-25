package com.ivan.examen.controller;

import com.ivan.examen.model.Profesor;
import com.ivan.examen.service.ProfesorCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesor-curso")
public class ProfesorCursoController {
    @Autowired
    private ProfesorCursoService profesorCursoService;

    @GetMapping("/profesores/curso/{idCurso}")
    public List<Profesor> getProfesoresByCurso(@PathVariable Long idCurso) {
        return profesorCursoService.findProfesoresByCursoId(idCurso);
    }

    @GetMapping("/cursos/profesor/{idProfesor}")
    public List<String> getCursosByProfesor(@PathVariable Long idProfesor) {
        return profesorCursoService.findCursosByProfesorId(idProfesor);
    }
}