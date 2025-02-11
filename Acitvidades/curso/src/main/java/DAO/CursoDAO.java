package DAO;

import Model.Curso;
import jakarta.persistence.EntityManager;
import java.util.List;

public class CursoDAO {
    private EntityManager em;

    public CursoDAO(EntityManager em) {
        this.em = em;
    }

    public List<Curso> obtenerTodosLosCursos() {
        return em.createQuery("SELECT c FROM Curso c", Curso.class).getResultList();
    }
}