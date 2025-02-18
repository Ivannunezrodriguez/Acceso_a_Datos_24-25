package dao;

import database.HibernateUtil;
import model.Usuario;
import org.hibernate.Session;

import java.util.List;

public class UsuarioDAO {

    public void agregarUsuario(Usuario usuario) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            Long count = session.createQuery("SELECT COUNT(u) FROM Usuario u WHERE u.email = :email", Long.class).setParameter("email", usuario.getEmail()).getSingleResult();
            if (count == 0) {
                session.persist(usuario);
                System.out.println("Usuario agregado: " + usuario.getEmail());
            } else {
                System.out.println("El usuario con email " + usuario.getEmail() + " ya existe. No se insertará nuevamente.");
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<Usuario> listarUsuarios() {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            List<Usuario> usuarios = session.createQuery("FROM Usuario", Usuario.class).getResultList();
            session.getTransaction().commit();
            return usuarios;
        }
    }
}
