package com.ivan.libreria.service;

import com.ivan.libreria.model.Editorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditorialServiceImp implements EditorialService {
    @Autowired
    private EditorialService editorialService;

    @Override
    public Editorial agregarEditorial(Editorial editorial) {
        return editorialRepository.save(editorial);

    }

    @Override
    public List<Editorial> getAllEditoriales() {
        return editorialRepository.findAll();
    }
}
