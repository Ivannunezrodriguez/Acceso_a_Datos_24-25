package com.ivan.examen.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Aula")
public class Aula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aula")
    private int id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private int capacidad;
}