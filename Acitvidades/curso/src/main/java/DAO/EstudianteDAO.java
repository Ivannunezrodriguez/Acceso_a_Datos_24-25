package DAO;

import Model.Estudiante;
import jakarta.persistence.EntityManager;
import java.util.List;

public class EstudianteDAO {
    private EntityManager em;

    public EstudianteDAO(EntityManager em) {
        this.em = em;
    }

    public List<Estudiante> obtenerTodosLosEstudiantes() {
        return em.createQuery("SELECT e FROM Estudiante e", Estudiante.class).getResultList();
    }
}