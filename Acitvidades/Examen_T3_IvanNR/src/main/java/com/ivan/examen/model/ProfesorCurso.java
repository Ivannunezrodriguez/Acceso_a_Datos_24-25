package com.ivan.examen.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Profesor_Curso")
public class ProfesorCurso {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_profesor", nullable = false)
    private Profesor profesor;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso;
}