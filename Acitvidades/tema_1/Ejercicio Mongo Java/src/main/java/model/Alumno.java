package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonProperty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Alumno {

    @BsonProperty("name")
    private String name;  // El nombre del alumno

    @BsonProperty("age")
    private int age;  // Edad del alumno

    @BsonProperty("gender")
    private String gender;  // Género del alumno

    @BsonProperty("email")
    private String email;  // Correo electrónico del alumno

    @BsonProperty("phone")
    private String phone;  // Número de teléfono

    @BsonProperty("calification")
    private int calification;  // Calificación del alumno

    @BsonProperty("higher_grade")
    private String higherGrade;  // Nivel superior del alumno (e.g., DAM, DAW)

    @BsonProperty("rating")
    private double rating;  // Valoración del alumno

    @Override
    public String toString() {
        return "Alumno{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", calification=" + calification +
                ", higherGrade='" + higherGrade + '\'' +
                ", rating=" + rating +
                '}';
    }
}
