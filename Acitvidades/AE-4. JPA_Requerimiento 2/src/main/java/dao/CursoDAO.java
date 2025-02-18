package dao;

import database.HibernateUtil;
import model.Curso;
import org.hibernate.Session;

import java.util.List;

public class CursoDAO {


    public void agregarCurso(Curso curso) {
        try (Session session = HibernateUtil.getSession()) {
        session.beginTransaction();
        session.persist(curso);
        session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Curso> obtenerTodosLosCursos() {
        try (Session session = HibernateUtil.getSession()) {
        session.beginTransaction();
        List<Curso> cursos = session.createQuery("SELECT c FROM Curso c", Curso.class).getResultList();
        session.getTransaction().commit();
        return cursos;


}}}