package com.ivan.examen.controller;


import com.ivan.examen.model.Alumno;
import com.ivan.examen.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumnos")
class AlumnoController {
    @Autowired
    private AlumnoService alumnoService;

    @GetMapping
    public List<Alumno> getAllAlumnos() {
        return alumnoService.findAll();
    }

    @PostMapping
    public Alumno createAlumno(@RequestBody Alumno alumno) {
        return alumnoService.save(alumno);
    }

    @GetMapping("/curso/{id_Curso}")
    public List<Alumno> getAlumnosByCurso(@PathVariable int id_Curso) {
        return alumnoService.findByCursoId(id_Curso);
    }
}
