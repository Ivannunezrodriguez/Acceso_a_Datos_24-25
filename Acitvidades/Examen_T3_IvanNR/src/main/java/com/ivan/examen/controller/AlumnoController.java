package com.ivan.examen.controller;

import com.ivan.examen.model.Alumno;
import com.ivan.examen.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {
    @Autowired
    private AlumnoService alumnoService;

    @GetMapping
    public List<Alumno> getAllAlumnos() {
        return alumnoService.findAll();
    }

    @PostMapping
    public ResponseEntity<Alumno> addAlumno(@RequestBody Alumno alumno) {
        Alumno newAlumno = alumnoService.saveAlumno(alumno);
        return ResponseEntity.ok(newAlumno);
    }


    @GetMapping("/curso/{idCurso}")
    public List<Alumno> getAlumnosByCurso(@PathVariable Long idCurso) {
        return alumnoService.findByCursoId(idCurso);
    }
}