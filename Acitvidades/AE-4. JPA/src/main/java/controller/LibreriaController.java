package controller;

import dao.*;
import database.HibernateUtil;
import model.*;
import org.hibernate.Session;

import java.util.List;

public class LibreriaController {
    private AutorDAO autorDAO;
    private EditorialDAO editorialDAO;
    private LibroDAO libroDAO;
    private LibreriaDAO libreriaDAO;

    public LibreriaController() {
        autorDAO = new AutorDAO();
        editorialDAO = new EditorialDAO();
        libroDAO = new LibroDAO();
        libreriaDAO = new LibreriaDAO();
    }

    public void agregarAutor(Autor autor) {
        if (autor.getFechaNacimiento() != null) {
            autorDAO.agregarAutor(autor);
        } else {
            System.out.println("Fecha de nacimiento no válida");
        }
    }

    public void agregarEditorial(Editorial editorial) {
        editorialDAO.agregarEditorial(editorial);
    }

    public void agregarLibro(Libro libro, int idAutor, int idEditorial) {
        Session session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Autor autor = session.get(Autor.class, idAutor);
        Editorial editorial = session.get(Editorial.class, idEditorial);
        session.getTransaction().commit();
        session.close();
        if (autor == null) {
            System.out.println("Error: No se encontró el autor con ID " + idAutor);
            return;
        }
        if (editorial == null) {
            System.out.println("Error: No se encontró la editorial con ID " + idEditorial);
            return;
        }
        libro.setAutor(autor);
        libro.setEditorial(editorial);
        libroDAO.agregarLibro(libro);
    }

    public void agregarLibreria(Libreria libreria, List<Integer> idsLibros) {
        Session session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        for (Integer id : idsLibros) {
            Libro libro = session.get(Libro.class, id);
            libreria.getLibros().add(libro);
        }
        session.getTransaction().commit();
        session.close();

        libreriaDAO.agregarLibreria(libreria);
    }

    public void mostrarLibrosConEditorialYAutor() {
        List<Libro> libros = libroDAO.obtenerLibrosConEditorialYAutor();
        for (Libro libro : libros) {
            System.out.println(libro.getTitulo() + " - " + libro.getAutor().getNombre() + " - " + libro.getEditorial().getNombre());
        }
    }

    public void mostrarAutoresConLibros() {
        List<Autor> autores = autorDAO.obtenerAutoresConLibros();
        for (Autor autor : autores) {
            System.out.println(autor.getNombre() + " " + autor.getApellidos() + " - " + autor.getLibros().size() + " libros");
        }
    }

    public void mostrarLibreriasConLibros() {
        List<Libreria> librerias = libreriaDAO.obtenerLibreriasConLibros();
        for (Libreria libreria : librerias) {
            System.out.println(libreria.getNombre() + " - " + libreria.getLibros().size() + " libros");
        }
    }
}