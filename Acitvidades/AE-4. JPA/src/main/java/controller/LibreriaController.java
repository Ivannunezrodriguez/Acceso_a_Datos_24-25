package controller;

import dao.LibreriaDAO;
import model.Autor;
import model.Libreria;
import model.Libro;
import org.hibernate.Session;

public class LibreriaController {
    private LibreriaDAO libreriaDAO;

    public LibreriaController(Session session) {
        this.libreriaDAO = new LibreriaDAO(session);
    }

    public void mostrarLibrosConEditorialYAutor() {
        System.out.println("Lista de libros con editorial y autor:");
        for (Libro l : libreriaDAO.obtenerLibrosConEditorialYAutor()) {
            System.out.println(l.getTitulo() + " - " + l.getAutor().getNombre() + " - " + l.getEditorial().getNombre());
        }
    }

    public void mostrarAutoresConLibros() {
        System.out.println("Lista de autores con sus libros:");
        for (Autor a : libreriaDAO.obtenerAutoresConLibros()) {
            int numLibros = (a.getLibros() != null) ? a.getLibros().size() : 0;
            System.out.println(a.getNombre() + " " + a.getApellidos() + " - " + numLibros + " libros");
        }
    }

    public void mostrarLibreriasConLibros() {
        System.out.println("Lista de librerías con sus libros:");
        for (Libreria l : libreriaDAO.obtenerLibreriasConLibros()) {
            System.out.println(l.getNombre() + " - " + l.getLibros().size() + " libros");
        }
    }
}