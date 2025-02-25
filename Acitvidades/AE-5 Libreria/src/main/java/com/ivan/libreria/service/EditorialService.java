package com.ivan.libreria.service;

import com.ivan.libreria.model.Editorial;

import java.util.List;

public interface EditorialService {
    List<Editorial> getAllEditoriales;

    Editorial agregarEditorial(Editorial editorial);
}
