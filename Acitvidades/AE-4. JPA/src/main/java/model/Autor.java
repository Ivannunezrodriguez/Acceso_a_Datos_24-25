package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellidos;
    private Date fechaNacimiento;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Libro> libros = new ArrayList<>();

    public Autor(String nombre, String apellidos, String fechaNacimiento) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            this.fechaNacimiento = sdf.parse(fechaNacimiento);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Formato de fecha incorrecto, use yyyy-MM-dd", e);
        }
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros != null ? libros : new ArrayList<>();
    }

    public void addLibro(Libro libro) {
        this.libros.add(libro);
        libro.setAutor(this);
    }
}