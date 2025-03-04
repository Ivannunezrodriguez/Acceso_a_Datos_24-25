import jakarta.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Curso")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCurso;
    private String nombre;

    @ManyToMany(mappedBy = "cursos")
    private Set<Profesor> profesores;

    @OneToOne
    @JoinColumn(name = "id_aula")
    private Aula aula;

    @OneToMany(mappedBy = "curso")
    private Set<Alumno> alumnos;
}
