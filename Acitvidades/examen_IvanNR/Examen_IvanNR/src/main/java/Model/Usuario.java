package Model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Usuario implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private int id;
    private String nombre;
    private String apellido;
    private String correo;
    private String pass;

    public Usuario(String nombre, String apellido, String correo, String pass) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.pass = pass;
    }
}
