package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@NamedQueries({
        @NamedQuery(name = "Libro.buscaPrimerosCuatro", query = "SELECT l FROM Libro l ORDER BY l.id ASC"),
        @NamedQuery(name = "Libro.buscaSuientesCuatro", query = "SELECT l FROM Libro l ORDER BY l.id ASC")
})
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String titulo;
    @Column
    private double precio;

    @ManyToOne
    @JoinColumn(name = "editorial_id")
    private Editorial editorial;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    public Libro(String titulo, double precio, Autor autor, Editorial editorial) {
        this.titulo = titulo;
        this.precio = precio;
        this.autor = autor;
        this.editorial = editorial;
    }

    public Libro(String titulo, double precio) {
        this.titulo = titulo;
        this.precio = precio;


    }
}