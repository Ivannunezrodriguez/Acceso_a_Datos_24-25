package dao;

import jakarta.persistence.EntityManager;
import model.Autor;
import model.Libreria;
import model.Libro;

import java.util.List;

public class LibreriaDAO {
    private EntityManager em;

    public LibreriaDAO(EntityManager em) {
        this.em = em;
    }

    public List<Libro> obtenerLibrosConEditorialYAutor() {
        return em.createQuery("SELECT l FROM Libro l JOIN FETCH l.editorial JOIN FETCH l.autor", Libro.class).getResultList();
    }

    public List<Autor> obtenerAutoresConLibros() {
        return em.createQuery("SELECT DISTINCT a FROM Autor a LEFT JOIN FETCH a.libros", Autor.class).getResultList();
    }

    public List<Libreria> obtenerLibreriasConLibros() {
        return em.createQuery("SELECT DISTINCT l FROM Libreria l LEFT JOIN FETCH l.libros", Libreria.class).getResultList();
    }
}