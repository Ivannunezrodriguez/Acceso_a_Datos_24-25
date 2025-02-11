import Controller.CursoController;
import DAO.CursoDAO;
import DAO.EstudianteDAO;
import DAO.ProfesorDAO;
import Database.JpaUtil;
import Model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            CursoController cursoController=new CursoController(em);
            CursoDAO cursoDAO = new CursoDAO(em);
            EstudianteDAO estudianteDAO = new EstudianteDAO(em);
            ProfesorDAO profesorDAO = new ProfesorDAO(em);



            // Creación de 4 alumnos con perfiles y usuarios

            Usuario usuario1 = new Usuario("Jose@example.com", "1234");
            Usuario usuario2 = new Usuario("Alba@example.com", "4321");
            Usuario usuario3 = new Usuario("Daniel@example.com", "5678");
            Usuario usuario4 = new Usuario("Ivan@example.com", "8765");

            Perfil perfil1 = new Perfil("Jose", "Perez", usuario1);
            Perfil perfil2 = new Perfil("Alba", "Nuñez", usuario2);
            Perfil perfil3 = new Perfil("Daniel", "Gomez", usuario3);
            Perfil perfil4 = new Perfil("Ivan", "Nuñez", usuario4);
            usuario1.setPerfil(perfil1);
            usuario2.setPerfil(perfil2);
            usuario3.setPerfil(perfil3);
            usuario4.setPerfil(perfil4);

            Estudiante estudiante1 = new Estudiante("Jose", usuario1.getEmail(),usuario1);
            Estudiante estudiante2 = new Estudiante("Alba", usuario2.getEmail(),usuario2);
            Estudiante estudiante3 = new Estudiante("Daniel", usuario3.getEmail(),usuario3);
            Estudiante estudiante4 = new Estudiante("Ivan", usuario4.getEmail(),usuario4);

            em.persist(usuario1);
            em.persist(usuario2);
            em.persist(usuario3);
            em.persist(usuario4);
            em.persist(perfil1);
            em.persist(perfil2);
            em.persist(perfil3);
            em.persist(perfil4);
            em.persist(estudiante1);
            em.persist(estudiante2);
            em.persist(estudiante3);
            em.persist(estudiante4);


            // Creación de 3 profesores

            Profesor profesor1 = new Profesor("Manuel", "SGE");
            Profesor profesor2 = new Profesor("Ana", "FOL");
            Profesor profesor3 = new Profesor("Daniel", "DEVops");



            // Creación de 2 cursos y asignación de profesores


            Curso curso1 = new Curso("DAM", 40, profesor1);
            Curso curso2 = new Curso("DAM2", 50, profesor2);
            em.persist(profesor1);
            em.persist(profesor2);
            em.persist(profesor3);
            em.persist(curso1);
            em.persist(curso2);

            em.getTransaction().commit();

            //consultas
            cursoController.listarProfesores();
            cursoController.listarEstudiantes();
            cursoController.listarCursos();

        } finally {
            em.close();
            JpaUtil.closeEntityManagerFactory();
        }

    }
}

