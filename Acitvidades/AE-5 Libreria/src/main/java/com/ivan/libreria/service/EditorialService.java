package com.ivan.libreria.service;

import com.ivan.libreria.model.Editorial;

import java.util.List;

public interface EditorialService {


    Editorial agregarEditorial(Editorial editorial);

    List<Editorial>getAllEditoriales();
}
