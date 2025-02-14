package dao;

import database.HibernateUtil;
import model.Autor;
import model.Libreria;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AutorDAO {

    public void agregarAutor(Autor autor) {
        Session session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(autor);
        session.getTransaction().commit();
        session.close();
    }

    public List<Autor> obtenerAutoresConLibros() {
        Session session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String querySTR ="SELECT DISTINCT a FROM Autor a LEFT JOIN FETCH a.libros";
        Query<Autor> query = session.createQuery(querySTR, Autor.class);
        List<Autor> autores = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return autores;
    }
}