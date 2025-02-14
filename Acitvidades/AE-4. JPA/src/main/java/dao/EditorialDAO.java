package dao;

import database.HibernateUtil;
import model.Editorial;
import org.hibernate.Session;

public class EditorialDAO {

    public void agregarEditorial(Editorial editorial) {
        Session session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(editorial);
        session.getTransaction().commit();
        session.close();
    }
}