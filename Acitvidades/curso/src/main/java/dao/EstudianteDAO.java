package dao;

import database.HibernateUtil;
import model.Estudiante;
import org.hibernate.Session;

import java.util.List;

public class EstudianteDAO {


    public void agregarEstudiante(Estudiante estudiante) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            // Verificar si el estudiante ya existe
            Long count = session.createQuery("SELECT COUNT(e) FROM Estudiante e WHERE e.email = :email", Long.class)
                    .setParameter("email", estudiante.getEmail())
                    .getSingleResult();
            if (count == 0) {
                session.persist(estudiante);
                System.out.println("Estudiante agregado: " + estudiante.getNombre());
            } else {
                System.out.println("El estudiante con email " + estudiante.getEmail() + " ya existe.");
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<Estudiante> obtenerTodosLosEstudiantes() {
        try (Session session = HibernateUtil.getSession()) {
        session.beginTransaction();
        List<Estudiante> estudiantes = session.createQuery("SELECT e FROM Estudiante e", Estudiante.class).getResultList();
        session.getTransaction().commit();
        return estudiantes;
    }
}}