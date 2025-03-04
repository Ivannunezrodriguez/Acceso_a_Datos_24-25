package com.ivan.examen.service;

import com.ivan.examen.model.Aula;

import java.util.List;

public interface AulaService {
    List<Aula> findByCapacidadGreaterThan(int capacidad);
}