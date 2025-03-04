package com.ivan.examen.controller;


import com.ivan.examen.model.Alumno;
import com.ivan.examen.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumnos")
@RequiredArgsConstructor
public class AlumnoController {
    private final AlumnoService alumnoService;

    @GetMapping
    public List<Alumno> getAll() {
        return alumnoService.getAllAlumnos();
    }

    @GetMapping("/curso/{id}")
    public List<Alumno> getByCurso(@PathVariable int id) {
        return alumnoService.getAlumnosByCurso(id);
    }

    @PostMapping
    public Alumno create(@RequestBody Alumno alumno) {
        return alumnoService.saveAlumno(alumno);
    }
}
