package dao;

import database.HibernateUtil;
import model.Perfil;
import org.hibernate.Session;

import java.util.List;

public class PerfilDAO {

    public void agregarPerfil(Perfil perfil) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            Long count = session.createQuery("SELECT COUNT(p) FROM Perfil p WHERE p.usuario.id = :usuarioId", Long.class).setParameter("usuarioId", perfil.getUsuario().getId()).getSingleResult();
            if (count == 0) {
                session.persist(perfil);
                System.out.println("Perfil agregado: " + perfil.getNombre());
            } else {
                System.out.println("Ya existe un perfil asociado al usuario " + perfil.getUsuario().getEmail());
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Perfil> listarPerfil() {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            List<Perfil> perfil = session.createQuery("SELECT p from Perfil p", Perfil.class).getResultList();
            session.getTransaction().commit();
            return perfil;
        }
    }
}
