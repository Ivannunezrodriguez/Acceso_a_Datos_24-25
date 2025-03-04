package com.ivan.examen.model;

import jakarta.persistence.*;

@Entity
@Table(name = "profesor_curso")
public class ProfesorCurso {

    @EmbeddedId
    private ProfesorCursoId id;

    @ManyToOne
    @MapsId("profesorId")
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;

    @ManyToOne
    @MapsId("cursoId")
    @JoinColumn(name = "curso_id")
    private Curso curso;

    private String anioAcademico;  // Ejemplo de atributo adicional en la relación

    public ProfesorCurso() {}

    public ProfesorCurso(Profesor profesor, Curso curso, String anioAcademico) {
        this.id = new ProfesorCursoId(profesor.getId(), curso.getId());
        this.profesor = profesor;
        this.curso = curso;
        this.anioAcademico = anioAcademico;
    }

    public ProfesorCursoId getId() {
        return id;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public Curso getCurso() {
        return curso;
    }

    public String getAnioAcademico() {
        return anioAcademico;
    }

    public void setAnioAcademico(String anioAcademico) {
        this.anioAcademico = anioAcademico;
    }
}
