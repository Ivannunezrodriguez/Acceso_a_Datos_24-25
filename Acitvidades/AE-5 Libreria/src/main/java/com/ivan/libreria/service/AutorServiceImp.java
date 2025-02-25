package com.ivan.libreria.service;

import com.ivan.libreria.model.Autor;
import com.ivan.libreria.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorServiceImp implements AutorService {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public Autor agregarAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    @Override
    public List<Autor> getAllAutores() {
        return autorRepository.findAll();
    }
}
