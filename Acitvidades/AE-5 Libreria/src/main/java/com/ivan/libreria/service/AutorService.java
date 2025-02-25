package com.ivan.libreria.service;

import com.ivan.libreria.model.Autor;

import java.util.List;

public interface AutorService {

    Autor agregarAutor(Autor autor);

    List<Autor> getAllAutores();
}
