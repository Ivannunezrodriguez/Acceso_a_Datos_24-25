package com.ivan.examen.controller;

import com.ivan.examen.model.Aula;
import com.ivan.examen.service.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aulas")
public class AulaController {
    @Autowired
    private AulaService aulaService;



    @GetMapping("/capacidad/{capacidad}")
    public List<Aula> getAulasByCapacidad(@PathVariable int capacidad) {
        return aulaService.findByCapacidadGreaterThan(capacidad);
    }
}