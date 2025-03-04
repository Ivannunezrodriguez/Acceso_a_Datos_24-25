package com.ivan.examen.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Data
@Entity
@Table(name = "Curso")
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
    private Set<Profesor> profesores;

    @OneToOne
    @JoinColumn(name = "id_aula", nullable = false)
    private Aula aula;

    @OneToMany(mappedBy = "curso")
    private Set<Alumno> alumnos;
}