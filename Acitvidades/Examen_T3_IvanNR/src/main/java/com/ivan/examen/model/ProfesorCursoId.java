package com.ivan.examen.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProfesorCursoId implements Serializable {
    private Long profesorId;
    private Long cursoId;

    public ProfesorCursoId() {}

    public ProfesorCursoId(Long profesorId, Long cursoId) {
        this.profesorId = profesorId;
        this.cursoId = cursoId;
    }

    public Long getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(Long profesorId) {
        this.profesorId = profesorId;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfesorCursoId that = (ProfesorCursoId) o;
        return Objects.equals(profesorId, that.profesorId) &&
                Objects.equals(cursoId, that.cursoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(profesorId, cursoId);
    }
}
