package com.ivan.examen.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "curso")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @ManyToMany
    @JoinTable(
            name = "Profesor_Curso",
            joinColumns = @JoinColumn(name = "id_curso"),
            inverseJoinColumns = @JoinColumn(name = "id_profesor")
    )

    private List<Profesor> profesores;

    @ManyToOne
    @JoinColumn(name = "id_aula", nullable = false)
    @JsonIgnore
    private Aula aula;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Alumno> alumnos;

    @ManyToOne
    @JoinColumn(name = "id_profesor", nullable = false)
    @JsonIgnore
    private Profesor profesor;

}