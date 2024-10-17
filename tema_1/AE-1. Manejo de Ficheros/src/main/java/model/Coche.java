package model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Coche {
    private int id;
    private String matricula;
    private String marca;
    private String modelo;
    private String color;


}