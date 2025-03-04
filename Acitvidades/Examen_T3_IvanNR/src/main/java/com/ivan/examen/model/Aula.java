package com.ivan.examen.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "aula")
public class Aula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aula")
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private int capacidad;

    @OneToMany(mappedBy = "aula")
    @JsonIgnore
    private List<Curso> cursos;
}