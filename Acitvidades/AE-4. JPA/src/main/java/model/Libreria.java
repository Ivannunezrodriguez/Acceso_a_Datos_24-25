package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Libreria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String nombreDueno;
    private String direccion;

    @ManyToMany
    @JoinTable(name = "libreria_libro", joinColumns = @JoinColumn(name = "libreria_id"), inverseJoinColumns = @JoinColumn(name = "libro_id"))
    private List<Libro> libros = new ArrayList<>();

    public Libreria(String nombre, String nombreDueno, String direccion, List<Libro> libros) {
        this.nombre = nombre;
        this.nombreDueno = nombreDueno;
        this.direccion = direccion;
        this.libros = libros;
    }
}