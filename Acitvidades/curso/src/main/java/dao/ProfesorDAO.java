package dao;

import database.HibernateUtil;
import model.Profesor;
import org.hibernate.Session;

import java.util.List;

public class ProfesorDAO {

    public void agregarProfesor(Profesor profesor) {
        try (Session session = HibernateUtil.getSession()) {
        session.beginTransaction();
        session.persist(profesor);
        session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Profesor> obtenerTodosLosProfesores() {
        try (Session session = HibernateUtil.getSession()) {
        session.beginTransaction();
        List<Profesor> profesores = session.createQuery("SELECT p FROM Profesor p", Profesor.class).getResultList();
        session.getTransaction().commit();
        return profesores;


}}}