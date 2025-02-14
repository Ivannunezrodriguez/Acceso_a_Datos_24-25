package dao;

import database.HibernateUtil;
import model.Libreria;
import model.Libro;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class LibroDAO {

    public void agregarLibro(Libro libro) {
        Session session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(libro);
        session.getTransaction().commit();
        session.close();
    }

    public List<Libro> obtenerLibrosConEditorialYAutor(){
        Session session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String querySTR = "SELECT l FROM Libro l JOIN FETCH l.editorial JOIN FETCH l.autor";
        Query<Libro> query = session.createQuery(querySTR, Libro.class);
          List<Libro> libros= query.getResultList();
        session.getTransaction().commit();
        session.close();
        return libros;
    }
}