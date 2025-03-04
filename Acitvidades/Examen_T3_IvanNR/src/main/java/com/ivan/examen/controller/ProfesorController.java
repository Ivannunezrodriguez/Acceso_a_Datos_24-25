package com.ivan.examen.controller;


import com.ivan.examen.model.Profesor;
import com.ivan.examen.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profesores")
class ProfesorController {
    @Autowired
    private ProfesorService profesorService;

    @PostMapping
    public Profesor createProfesor(@RequestBody Profesor profesor) {
        return profesorService.save(profesor);
    }
}