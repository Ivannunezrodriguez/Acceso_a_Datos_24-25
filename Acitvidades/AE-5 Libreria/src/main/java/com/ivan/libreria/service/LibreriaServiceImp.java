package com.ivan.libreria.service;

import com.ivan.libreria.model.Libreria;
import com.ivan.libreria.repository.LibreriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibreriaServiceImp implements LibreriaService {

    @Autowired
    private LibreriaRepository libreriaRepository;

    @Override
    public Libreria agregarLibreria(Libreria libreria) {
        return libreriaRepository.save(libreria);
    }

    @Override
    public List<Libreria> getAllLibrerias() {
        return libreriaRepository.findAll();
    }
}
