import controller.LibreriaController;
import model.Autor;
import model.Editorial;
import model.Libro;
import model.Libreria;

import java.util.Arrays;
import java.util.List;

public class Entrada {

    public static void main(String[] args) {
        LibreriaController libreriaController = new LibreriaController();

        // Agregar autores
        Autor autor1 = new Autor("Gabriel", "García Márquez", "1927-03-06");
        Autor autor2 = new Autor("Isabel", "Allende", "1942-08-02");
        libreriaController.agregarAutor(autor1);
        libreriaController.agregarAutor(autor2);

        // Agregar editoriales
        Editorial editorial1 = new Editorial("RBA", "Madrid, España");
        Editorial editorial2 = new Editorial("Planeta", "Barcelona, España");
        libreriaController.agregarEditorial(editorial1);
        libreriaController.agregarEditorial(editorial2);

        // Agregar libros
        libreriaController.agregarLibro(new Libro("Cien años de soledad", 25.99), 1, 1);
        libreriaController.agregarLibro(new Libro("La casa de los espíritus", 20.50), 2, 2);

        // Agregar librerías
        Libreria libreria1 = new Libreria("Librería Central", "Juan Pérez", "Calle Mayor, 10");
        libreriaController.agregarLibreria(libreria1, Arrays.asList(1, 2));


        // Mostrar información
        libreriaController.mostrarLibrosConEditorialYAutor();
        libreriaController.mostrarAutoresConLibros();
        libreriaController.mostrarLibreriasConLibros();
    }
}