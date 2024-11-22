package model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Pasajero {
    private int id;
    private String nombre;
    private int edad;
    private double peso;

public void mostrarPasajero(){

    System.out.println("id = " + id);
    System.out.println("nombre = " + nombre);
    System.out.println("edad = " + edad);
    System.out.println("peso = " + peso);

}
}