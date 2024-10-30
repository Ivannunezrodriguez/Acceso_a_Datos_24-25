package model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Coche implements Serializable {

    @Serial
    private static final long serialVersionUID = 2229836618165669008L;
    private int id;
    private String matricula;
    private String marca;
    private String modelo;
    private String color;


}