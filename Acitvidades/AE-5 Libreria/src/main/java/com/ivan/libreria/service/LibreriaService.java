package com.ivan.libreria.service;

import com.ivan.libreria.model.Libreria;

import java.util.List;

public interface LibreriaService {
    Libreria agregarLibreria(Libreria libreria);

    List<Libreria> getAllLibrerias();
}
