package com.ivan.examen.service;

import com.ivan.examen.model.Aula;
import com.ivan.examen.repository.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AulaServiceImpl implements AulaService {

    @Autowired
    private AulaRepository aulaRepository;

    @Override
    public List<Aula> findByCapacidadGreaterThan(int capacidad) {
        return aulaRepository.findByCapacidadGreaterThan(capacidad);
    }
}