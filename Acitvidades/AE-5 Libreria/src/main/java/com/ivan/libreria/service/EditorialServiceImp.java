package com.ivan.libreria.service;

import com.ivan.libreria.model.Editorial;
import com.ivan.libreria.repository.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditorialServiceImp implements EditorialService {
    @Autowired
    private EditorialRepository editorialRepository;

    @Override
    public Editorial agregarEditorial(Editorial editorial) {
        return editorialRepository.save(editorial);

    }

 @Override
 public List<Editorial>getAllEditoriales(){
        return editorialRepository.findAll();
    }
}
