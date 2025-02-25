package com.ivan.libreria.controller;


import com.ivan.libreria.model.Editorial;
import com.ivan.libreria.service.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/editorial")
public class EditorialController {
    @Autowired
    private EditorialService editorialService;

    @GetMapping("error")
    public String error() {
        return "error en la app";
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Editorial>> getAllEditoriales() {
        return new ResponseEntity<>(editorialService., HttpStatus.OK);
    }

    @PostMapping("add")
    public String addEditorial(@RequestBody Editorial editorial) {
        editorialService.agregarEditorial(editorial);
        return "editorial agregado" + editorial.getNombre();
    }


}
