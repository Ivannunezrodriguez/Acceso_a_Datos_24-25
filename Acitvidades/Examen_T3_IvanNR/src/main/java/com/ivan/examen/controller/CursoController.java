package com.ivan.examen.controller;

import com.ivan.examen.model.Curso;
import com.ivan.examen.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @GetMapping("/aula/{idAula}")
    public Curso getCursoByAula(@PathVariable Long idAula) {
        return cursoService.findByAulaId(idAula);
    }

    @GetMapping("/profesor/{idProfesor}")
    public List<Curso> getCursosByProfesor(@PathVariable Long idProfesor) {
        return cursoService.findByProfesorId(idProfesor);
    }
}