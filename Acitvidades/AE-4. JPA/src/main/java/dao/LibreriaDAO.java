package dao;

import database.HibernateUtil;
import model.Libreria;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class LibreriaDAO {

    public void agregarLibreria(Libreria libreria) {
        Session session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(libreria);
        session.getTransaction().commit();
        session.close();
    }

    public List<Libreria> obtenerLibreriasConLibros() {
        Session session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String querySTR = "SELECT DISTINCT l FROM Libreria l LEFT JOIN FETCH l.libros WHERE SIZE(l.libros) > 0";
        Query<Libreria> query = session.createQuery(querySTR, Libreria.class);

        List<Libreria> librerias = query.getResultList();
        session.getTransaction().commit();
        session.close();

        return librerias;
    }
}