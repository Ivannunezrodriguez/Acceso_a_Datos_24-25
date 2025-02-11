import controller.LibreriaController;
import database.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.Autor;
import model.Editorial;
import model.Libreria;
import model.Libro;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            LibreriaController libreriaController = new LibreriaController((Session) em);

            // Dar de alta 3 autores
            Autor autor1 = new Autor("Gabriel", "García Márquez", "1927-03-06");
            Autor autor2 = new Autor("Isabel", "Allende", "1942-08-02");
            Autor autor3 = new Autor("Julio", "Cortázar", "1914-08-26");

            em.persist(autor1);
            em.persist(autor2);
            em.persist(autor3);

            // Dar de alta 2 editoriales
            Editorial editorial1 = new Editorial("RBA", "Madrid, España");
            Editorial editorial2 = new Editorial("Planeta", "Barcelona, España");

            em.persist(editorial1);
            em.persist(editorial2);

            // Dar de alta 8 libros
            Libro libro1 = new Libro("El misterio del bosque", 25.99, autor1, editorial1);
            autor1.addLibro(libro1);
            editorial1.addLibro(libro1);
            Libro libro2 = new Libro("El arte de la guerra", 15.75, autor2, editorial2);
            autor2.addLibro(libro2);
            editorial2.addLibro(libro2);
            Libro libro3 = new Libro("Ciencia y futuro", 28.40, autor1, editorial1);
            autor1.addLibro(libro3);
            editorial1.addLibro(libro3);
            Libro libro4 = new Libro("La historia secreta", 22.90, autor3, editorial2);
            autor3.addLibro(libro4);
            editorial2.addLibro(libro4);
            Libro libro5 = new Libro("Viaje al centro", 18.30, autor2, editorial1);
            autor1.addLibro(libro5);
            editorial1.addLibro(libro5);
            Libro libro6 = new Libro("Programación avanzada", 35.20, autor3, editorial2);
            autor2.addLibro(libro6);
            editorial2.addLibro(libro6);
            Libro libro7 = new Libro("El mundo de los sueños", 20.10, autor1, editorial1);
            autor1.addLibro(libro7);
            editorial1.addLibro(libro7);
            Libro libro8 = new Libro("Aventuras espaciales", 30.50, autor2, editorial2);
            autor2.addLibro(libro8);
            editorial2.addLibro(libro8);

            em.persist(libro1);
            em.persist(libro2);
            em.persist(libro3);
            em.persist(libro4);
            em.persist(libro5);
            em.persist(libro6);
            em.persist(libro7);
            em.persist(libro8);

            // Dar de alta 2 librerías con 4 libros cada una
            Libreria libreria1 = new Libreria("Librería Central", "Juan Pérez", "Calle Mayor, 10", em.createQuery("FROM Libro ORDER BY id", Libro.class).setMaxResults(4).getResultList());
            Libreria libreria2 = new Libreria("Librería Barrio", "María López", "Avenida Europa, 22", em.createQuery("FROM Libro ORDER BY id", Libro.class).setFirstResult(4).setMaxResults(4).getResultList());
            em.persist(libreria1);
            em.persist(libreria2);

            transaction.commit();

            // Consultas
            libreriaController.mostrarLibrosConEditorialYAutor();
            libreriaController.mostrarAutoresConLibros();
            libreriaController.mostrarLibreriasConLibros();

        } finally {
            em.close();
            JpaUtil.closeEntityManagerFactory();
        }
    }
}
