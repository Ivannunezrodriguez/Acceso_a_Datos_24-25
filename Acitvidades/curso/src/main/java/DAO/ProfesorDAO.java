package DAO;

import Model.Profesor;
import jakarta.persistence.EntityManager;
import java.util.List;

public class ProfesorDAO {
    private EntityManager em;

    public ProfesorDAO(EntityManager em) {
        this.em = em;
    }

    public List<Profesor> obtenerTodosLosProfesores() {
        return em.createQuery("SELECT p FROM Profesor p", Profesor.class).getResultList();
    }
}