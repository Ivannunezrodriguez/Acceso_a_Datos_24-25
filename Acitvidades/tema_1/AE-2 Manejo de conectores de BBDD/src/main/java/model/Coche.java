package model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Coche {
    private int id;
    private String marca;
    private String modelo;
    private int anio;

public void  mostrarCoche() {
    System.out.println("id = " + id);
    System.out.println("marca = " + marca);
    System.out.println("modelo = " + modelo);
    System.out.println("año = " + anio);

}

}